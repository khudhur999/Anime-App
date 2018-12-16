package com.example.khudhur.jikanapp.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.models.CharactersAppearances
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_char.view.*

class AnimeFromCharAdapter : RecyclerView.Adapter<AnimeFromCharAdapter.AnimeViewHolder> {
    val charAnimeList : List<CharactersAppearances>
    constructor(charAnimeList: List<CharactersAppearances>){
        this.charAnimeList = charAnimeList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_char, parent, false)
        return AnimeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return charAnimeList.size
    }

        override fun onBindViewHolder(viewHolder: AnimeViewHolder, position: Int) {
        viewHolder.setAnimeCharacter(charAnimeList[position])
    }



    inner class AnimeViewHolder : RecyclerView.ViewHolder{
    val view : View
        constructor(view: View) : super(view) {
            this.view = view
//            this.view.setOnClickListener {
//                val scrollingIntent = Intent(it.context,)
            }

        fun setAnimeCharacter(characterAnime: CharactersAppearances) {
            view.appearancesTitle.text = characterAnime.name

        }
    }
}