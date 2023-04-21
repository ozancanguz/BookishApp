package com.ozancanguz.bookishapp.data.api

import com.ozancanguz.bookishapp.data.book.Book
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface BookApi {

    @Headers(
        "Authorization: apikey 4IeDD4a3d0pzZpPENijBY4:3UABECFIqhaQo9m3uZT64A",
        "Content-Type: application/json"
    )
    @GET("newBook")
    suspend fun getBooks(): Response<Book>
}