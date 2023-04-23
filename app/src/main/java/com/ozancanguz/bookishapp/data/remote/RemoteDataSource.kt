package com.ozancanguz.bookishapp.data.remote

import com.ozancanguz.bookishapp.data.api.BookApi
import com.ozancanguz.bookishapp.data.book.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val bookApi: BookApi) {


    suspend fun getBooks(): Flow<Response<Book>> {
        return flow {
            val response = bookApi.getBooks()
            emit(response)
        }
    }
}