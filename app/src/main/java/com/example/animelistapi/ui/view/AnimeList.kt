package com.example.animelistapi.ui.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animelistapi.MainActivity.Companion.pref_name
import com.example.animelistapi.MainActivity.Companion.sharedPreferences
import com.example.animelistapi.R
import com.example.animelistapi.ui.viewmodel.AnimeListViewModel
import com.example.animelistapi.data.api.RetrofitList
import com.example.animelistapi.data.repository.iListRepositoryImpl
import com.example.animelistapi.databinding.FragmentAnimeListBinding
import kotlinx.coroutines.launch

class AnimeList : Fragment() {


    private lateinit var _binding: FragmentAnimeListBinding
    private val binding get() = _binding

    private val viewModel: AnimeListViewModel =
        AnimeListViewModel(iListRepositoryImpl(RetrofitList.apis))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up RecyclerView
        binding.rvAnimeList.layoutManager = LinearLayoutManager(requireContext())

        viewLifecycleOwner.lifecycleScope.launch{
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
            viewModel.getAnimeList()

                binding.rvAnimeList.adapter = AnimeListAdapter(viewModel.animeList) { animeId ->
                    val action =
                        AnimeListDirections.actionAnimeListToAnimeDetails(animeId.toString())
                    findNavController().navigate(action)

                }
            }
        }
    }




}