package com.example.khudhur.jikanapp.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khudhur.jikanapp.activities.MangaScrollingDetails
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.models.Manga
import com.example.khudhur.jikanapp.utilities.Consts
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_manga.view.*

class MangaAdapter : RecyclerView.Adapter<MangaAdapter.MangaViewHolder> {
    val mangaList : List<Manga>
    constructor(mangaList: List<Manga>){
        this.mangaList =     mangaList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_manga,parent,false)
        return MangaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mangaList.size
    }

    override fun onBindViewHolder(viewHolder: MangaViewHolder, position: Int) {
        viewHolder.setManga(mangaList[position])
    }






    inner class MangaViewHolder : RecyclerView.ViewHolder {
        val view : View
        constructor(view: View): super(view){
            this.view = view
            this.view.setOnClickListener {
                val scrollingIntent = Intent(it.context, MangaScrollingDetails::class.java)
                val manga = mangaList[layoutPosition]
                scrollingIntent.putExtra(Consts.MANGA   , manga)
                it.context.startActivity(scrollingIntent)
            }
    }
        fun setManga (manga : Manga){
            view.mangaTextView.text = manga.title
//            view.mangaDiscriptionTextView.text = manga.synopsis
            Picasso.get().load(manga.imageUrl).into(view.mangaImageView)
        }
    }
}