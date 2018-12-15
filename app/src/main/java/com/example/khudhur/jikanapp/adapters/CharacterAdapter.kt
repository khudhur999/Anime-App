package com.example.khudhur.jikanapp.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khudhur.jikanapp.activities.CharacterScrollingDetails
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.models.Character
import com.example.khudhur.jikanapp.utilities.Consts
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter(val characterList: List<Character>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character,parent,false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(viewHolder: CharacterViewHolder, position: Int) {
        viewHolder.setCharacter(characterList[position])
    }







    inner class CharacterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                val scrollingIntent = Intent(it.context,
                    CharacterScrollingDetails::class.java)
                val character = characterList[layoutPosition]
                scrollingIntent.putExtra(Consts.CHARACTER,character)
                it.context.startActivity(scrollingIntent)
            }
        }
        fun setCharacter (character : Character){
            view.characterTextView.text = character.name
            Picasso.get().load(character.imageUrl).into(view.characterImageView)
        }
    }
}