package com.ozancanguz.bookishapp.data.remote

import com.ozancanguz.bookishapp.data.api.BookApi
import com.ozancanguz.bookishapp.data.book.Book
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val bookApi: BookApi) {



    suspend fun getBooks(): Response<Book> {
        return bookApi.getBooks()
    }
}