package com.example.animelistapi.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.example.animelistapi.ui.viewmodel.AnimeListViewModel
import com.example.animelistapi.data.api.RetrofitList
import com.example.animelistapi.data.repository.iListRepositoryImpl
import com.example.animelistapi.databinding.FragmentAnimeDetailsBinding
import com.example.animelistapi.ui.viewmodel.AnimeDetailsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup


class AnimeDetails : Fragment() {

    private lateinit var _binding: FragmentAnimeDetailsBinding
    private val binding get() = _binding

    private val viewModel: AnimeDetailsViewModel =
        AnimeDetailsViewModel(iListRepositoryImpl(RetrofitList.apis))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var args = AnimeDetailsArgs.fromBundle(requireArguments())
        val animeId = args.IdArgs.toInt()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAnimeDetails(animeId)
        }

        viewModel.animeDetail.observe(viewLifecycleOwner) { anime ->
            anime?.let {
                binding.apply {
                    smallAnimeTitle.text = anime.title.romaji
                    smallAnimestatus.text = anime.status
                    smallAnimeyear.text = anime.seasonYear.toString()
                    season.text = anime.season
                    smallAnimeDescription.text = Jsoup.parse(anime.description).text()
                    resultEnglish.text = anime.title.english ?: "No English Title"
                    resultFormat.text = anime.format

                    Glide.with(smallAnimeImage.context)
                        .load(anime.coverImage.medium)
                        .into(smallAnimeImage)
                }
            }
        }
    }


}