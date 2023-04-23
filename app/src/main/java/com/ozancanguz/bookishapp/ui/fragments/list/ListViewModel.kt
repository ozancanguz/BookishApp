package com.ozancanguz.bookishapp.ui.fragments.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.bookishapp.data.book.Book
import com.ozancanguz.bookishapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel@Inject constructor(private val repository: Repository,application: Application):AndroidViewModel(application) {


    private val _bookList = MutableStateFlow<Book?>(null)
    val bookList: StateFlow<Book?> = _bookList

    fun getBooks() {
        viewModelScope.launch {
            repository.remote.getBooks().collect { response ->
                if (response.isSuccessful) {
                    _bookList.value = response.body()
                } else {
                    Log.d("list view model", "no data")
                }
            }
        }


    }

}