package com.example.animelistapi.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.animelistapi.ui.viewmodel.AnimeDetailViewModel
import com.example.animelistapi.data.api.RetrofitList
import com.example.animelistapi.data.repository.iListRepositoryImpl
import com.example.animelistapi.databinding.FragmentAnimeDetailsBinding


class AnimeDetails : Fragment() {

    private lateinit var _binding: FragmentAnimeDetailsBinding
    private val binding get() = _binding

    private val viewModel: AnimeDetailViewModel =
        AnimeDetailViewModel(iListRepositoryImpl(RetrofitList.apis))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}