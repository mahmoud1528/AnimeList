package com.example.animelistapi

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animelistapi.databinding.FragmentAnimeListBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val pref_name="night_option"
        lateinit var sharedPreferences: SharedPreferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(pref_name, Context.MODE_PRIVATE)


        val switchNightMode = findViewById<SwitchCompat>(R.id.nightmd)
        val switchState = sharedPreferences.getBoolean(pref_name, false)


        if(switchState){
            switchNightMode.isChecked = true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        switchNightMode.setOnCheckedChangeListener({ buttonView, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPreferences.edit().putBoolean(pref_name, true).apply()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPreferences.edit().putBoolean(pref_name, false).apply()
            }
        })

    }
}