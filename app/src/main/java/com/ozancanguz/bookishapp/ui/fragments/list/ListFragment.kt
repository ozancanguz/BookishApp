package com.ozancanguz.bookishapp.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.bookishapp.data.adapter.BookListAdapter
import com.ozancanguz.bookishapp.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    private val binding get() = _binding!!

    // init viewmodel
    private val listViewModel:ListViewModel by viewModels()

    // init adapter
    private val bookListAdapter=BookListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentListBinding.inflate(inflater, container, false)


        // setting up recyclerview
        setupRv()


        // observe live data and update ui
        observeLiveData()


        return binding.root

    }

    private fun observeLiveData() {
        lifecycleScope.launch {
            listViewModel.bookList.collect {
                if (it != null) {
                    bookListAdapter.setData(it)
                }
            }
        }
        listViewModel.getBooks()
    }
    private fun setupRv() {
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=bookListAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}