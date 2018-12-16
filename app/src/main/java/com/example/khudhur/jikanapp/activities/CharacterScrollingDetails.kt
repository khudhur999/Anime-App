package com.example.khudhur.jikanapp.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.adapters.AnimeFromCharAdapter
import com.example.khudhur.jikanapp.adapters.NickNameAdapter
import com.example.khudhur.jikanapp.models.Character
import com.example.khudhur.jikanapp.models.CharactersAppearances
import com.example.khudhur.jikanapp.utilities.Consts
import com.example.khudhur.jikanapp.utilities.setImageFromURL
import kotlinx.android.synthetic.main.activity_character_scrolling_details.*
import kotlinx.android.synthetic.main.content_character_scrolling_details.*

class CharacterScrollingDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_scrolling_details)
        setSupportActionBar(toolbar)
        val character = intent.getParcelableExtra<Character>(Consts.CHARACTER)
        characterToolbar_layout.title = character.name
        characterCollapsingImageView.setImageFromURL(character.imageUrl)
        characterFab.setOnClickListener {
            if (character.url == "N/A") {
                Toast.makeText(
                        this@CharacterScrollingDetails,
                        "no website found !",
                        Toast.LENGTH_LONG
                ).show()
            } else {

                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(character.url))
                startActivity(browserIntent)

            }
        }
        prepareRecyclers(character.anime)
        prepareRecyclerName(character.alternativeNames)
    }



    fun prepareRecyclers(characters: List<CharactersAppearances>){
        recyclerView3.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView3.adapter = AnimeFromCharAdapter(characters)



    }
    fun prepareRecyclerName (nickname : List<String> ){
        nameRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        nameRecyclerView.adapter = NickNameAdapter(nickname)
    }


    }

