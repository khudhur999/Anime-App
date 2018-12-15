package com.example.khudhur.jikanapp

import com.example.khudhur.jikanapp.models.Anime
import com.example.khudhur.jikanapp.models.AnimeSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeInterface {
    @GET("search/anime")
    fun searchAnime (@Query("q")searchQuery: String): Call<AnimeSearchResponse>

//    @GET("anime/id")
//    fun getAnimeDetailes (@Query("q") id: Anime): Call<Anime>
}
