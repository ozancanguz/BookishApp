package com.ozancanguz.bookishapp.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.bookishapp.R
import com.ozancanguz.bookishapp.data.book.Book
import com.ozancanguz.bookishapp.data.book.BookList
import com.ozancanguz.bookishapp.databinding.BookRowLayoutBinding
import com.ozancanguz.bookishapp.util.Util.Companion.loadImage

class BookListAdapter : RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {

    inner class BookViewHolder(val binding: BookRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    private var bookList = emptyList<BookList>()

    fun setData(newData: Book) {
        bookList = newData.result
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BookRowLayoutBinding.inflate(inflater, parent, false)
        return BookViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentBook = bookList[position]
        holder.binding.bookTitle.text = currentBook.title
        holder.binding.bookAuthor.text = "Author: "+currentBook.yazar
        holder.binding.bookPrice.text ="Price: " +currentBook.fiyat
        holder.binding.bookDiscount.text = "Discount: " +currentBook.indirim
        holder.binding.bookPublisher.text = "Publisher: " +currentBook.yayın
        holder.binding.bookImage.loadImage(currentBook.image)


    }
}
