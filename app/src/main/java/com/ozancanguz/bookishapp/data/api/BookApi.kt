package com.ozancanguz.bookishapp.data.api

import com.ozancanguz.bookishapp.data.book.Book
import retrofit2.Response
import retrofit2.http.GET

interface BookApi {

    @GET("newBook")
    suspend fun getBooks(): Response<Book>
}