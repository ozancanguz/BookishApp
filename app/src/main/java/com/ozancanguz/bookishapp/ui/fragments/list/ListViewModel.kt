package com.ozancanguz.bookishapp.ui.fragments.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.bookishapp.data.book.Book
import com.ozancanguz.bookishapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel@Inject constructor(private val repository: Repository,application: Application):AndroidViewModel(application) {


    val bookList=MutableLiveData<Book>()

    fun getBooks(){

        viewModelScope.launch {
            val response=repository.remote.getBooks()
            if(response.isSuccessful){
                bookList.postValue(response.body())
            }else{
                Log.d("list view model","no data")
            }
        }
    }

}