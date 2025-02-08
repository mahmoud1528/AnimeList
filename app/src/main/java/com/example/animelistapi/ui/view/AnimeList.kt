package com.example.animelistapi.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animelistapi.ui.viewmodel.AnimeDetailViewModel
import com.example.animelistapi.data.api.RetrofitList
import com.example.animelistapi.data.repository.iListRepositoryImpl
import com.example.animelistapi.databinding.FragmentAnimeListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnimeList : Fragment() {

    private lateinit var _binding: FragmentAnimeListBinding
    private val binding get() = _binding

    private val viewModel: AnimeDetailViewModel =
        AnimeDetailViewModel(iListRepositoryImpl(RetrofitList.apis))

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

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            viewModel.getAnimeList()
            withContext(Dispatchers.Main) {
                binding.rvAnimeList.adapter = AnimeListAdapter(viewModel.animeDetail)
            }
        }

//        binding.rvAnimeList.setOnClickListener {
//            findNavController().navigate(R.id.action_animeList_to_animeDetails)
//        }

    }

}