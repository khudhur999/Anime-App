package com.example.khudhur.jikanapp.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.R.string.character
import com.example.khudhur.jikanapp.activities.AnimeScrollingDetails
import com.example.khudhur.jikanapp.activities.CharacterScrollingDetails
import com.example.khudhur.jikanapp.models.Character
import com.example.khudhur.jikanapp.models.CharactersAppearances
import com.example.khudhur.jikanapp.utilities.Consts
import kotlinx.android.synthetic.main.item_char.view.*

class CharMangaAdapter(val charlist : List<CharactersAppearances> ) :RecyclerView.Adapter<CharMangaAdapter.CharViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_char,parent,false)
        return CharViewHolder(view)
    }

    override fun getItemCount(): Int {
        return charlist.size
    }

    override fun onBindViewHolder(viewHolder: CharViewHolder, position: Int) {
        viewHolder.setChar(charlist[position])
    }



    inner class CharViewHolder : RecyclerView.ViewHolder {
        val view: View

        constructor(view: View) : super(view) {
            this.view = view
            this.view.setOnClickListener {
                val scrollingIntent = Intent(it.context, CharacterScrollingDetails::class.java)
                val char = charlist[layoutPosition]
                scrollingIntent.putExtra(Consts.ANIME, char)
                it.context.startActivity(scrollingIntent)
            }
        }
            fun setChar (char : CharactersAppearances){
                view.animeCharTextView.text = char.name
            }
    }
}