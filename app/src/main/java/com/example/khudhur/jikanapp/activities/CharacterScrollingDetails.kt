package com.example.khudhur.jikanapp.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.adapters.CharMangaAdapter
import com.example.khudhur.jikanapp.adapters.CharacterAdapter
import com.example.khudhur.jikanapp.models.Character
import com.example.khudhur.jikanapp.models.CharactersAppearances
import com.example.khudhur.jikanapp.utilities.Consts
import com.example.khudhur.jikanapp.utilities.setImageFromURL
import kotlinx.android.synthetic.main.activity_character_scrolling_details.*
import kotlinx.android.synthetic.main.content_character_scrolling_details.*
import kotlinx.android.synthetic.main.fragment_anime.*

class CharacterScrollingDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_scrolling_details)
        setSupportActionBar(toolbar)
        val character = intent.getParcelableExtra<Character>(Consts.CHARACTER)
        fillCharacterInfo(character)
    }
    private fun fillCharacterInfo (character : Character) {
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

    }
//    fun prepareRecyclers(charlist:){
//        recyclerView3.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
//        recyclerView3.adapter = CharMangaAdapter(charlist)
//
//        recyclerView .layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
//        recyclerView.adapter = CharacterAdapter(charlist )
//
//    }
}
