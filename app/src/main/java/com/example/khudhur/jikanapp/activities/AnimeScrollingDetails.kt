package com.example.khudhur.jikanapp.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.khudhur.jikanapp.AnimeInterface
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.models.Anime
import com.example.khudhur.jikanapp.utilities.Consts
import com.example.khudhur.jikanapp.utilities.setImageFromURL
import kotlinx.android.synthetic.main.activity_anime_scrolling_details.*
import kotlinx.android.synthetic.main.content_anime_scrolling_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeScrollingDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_scrolling_details)
        setSupportActionBar(toolbar)

        val anime = intent.getParcelableExtra<Anime>(Consts.ANIME)
//        getAnimeDetails(anime)
        fullAnimeInfo(anime)
    }

//    private fun getAnimeDetails(id: Anime) {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(Consts.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val animeInterface = retrofit.create(AnimeInterface::class.java)
//        animeInterface.getAnimeDetailes(id).enqueue(object : Callback<Anime> {
//            override fun onFailure(call: Call<Anime>, t: Throwable) {
//                Toast.makeText(this@AnimeScrollingDetails, t.message, Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(call: Call<Anime>, response: Response<Anime>) {
//                response.body()?.let {
//                    fullAnimeInfo(it)
//                }
//            }
//
//        })

//    }

    private fun fullAnimeInfo(anime: Anime) {
        toolbar_layout.title = anime.title

        detailsTextView.text = anime.synopsis
        animeCollapsingImageView.setImageFromURL(anime.imageUrl)
        typeTextView.text = "Type : ${anime.type}"
        episodsTextView.text = "Episods : ${anime.episodes}"
        fab.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(anime.url))
            if (anime.url == "N/A") {
                Toast.makeText(
                        this@AnimeScrollingDetails,
                        "no website found !",
                        Toast.LENGTH_LONG
                ).show()
            } else {


                startActivity(browserIntent)

            }
        }
    }
}
