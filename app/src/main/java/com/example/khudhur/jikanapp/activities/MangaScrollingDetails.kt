package com.example.khudhur.jikanapp.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.khudhur.jikanapp.MangaInterface
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.models.Manga
import com.example.khudhur.jikanapp.utilities.Consts
import com.example.khudhur.jikanapp.utilities.setImageFromURL
import kotlinx.android.synthetic.main.activity_anime_scrolling_details.*
import kotlinx.android.synthetic.main.activity_manga_scrolling_details.*
import kotlinx.android.synthetic.main.content_anime_scrolling_details.*
import kotlinx.android.synthetic.main.content_manga_scrolling_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MangaScrollingDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga_scrolling_details)
        setSupportActionBar(mangaToolbar)
//        mangaFab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        val manga = intent.getParcelableExtra<Manga>(Consts.MANGA)
        fullMangaInfo(manga)
    }
//    private fun getMangaDetails (id: Manga){
//        val retrofit = Retrofit.Builder()
//            .baseUrl(Consts.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val mangaInterface = retrofit.create(MangaInterface::class.java)
//        mangaInterface.getMangaDetailes(id).enqueue(object : Callback<Manga> {
//            override fun onFailure(call: Call<Manga>, t: Throwable) {
//                Toast.makeText(this@MangaScrollingDetails ,t.message, Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(call: Call<Manga>, response: Response<Manga>) {
//                response.body()?.let {
//                    fullMangaInfo(it)
//                }
//            }
//
//        })
//
//    }
    private  fun fullMangaInfo (manga : Manga){
        mangaToolbar_layout.title = manga.title
        mangadetailsTextView.text = manga.synopsis
       mangaCollapsingImageView.setImageFromURL(manga.imageUrl)
    typeMangaTextView.text = "Type : ${manga.type}"
    chaptersTextView.text = "Episods : ${manga.chapters}"
    mangaFab.setOnClickListener {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(manga.url))
        if (manga.url == "N/A") {
            Toast.makeText(
                    this@MangaScrollingDetails,
                    "no website found !",
                    Toast.LENGTH_LONG
            ).show()
        } else {


            startActivity(browserIntent)

        }
    }
    }
}
