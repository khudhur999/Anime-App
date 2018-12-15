package com.example.khudhur.jikanapp

import com.example.khudhur.jikanapp.models.Manga
import com.example.khudhur.jikanapp.models.MangaSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaInterface {
    @GET("search/manga")
    fun searchManga (@Query ("q")searchQuery : String ): Call<MangaSearchResponse>
    @GET("anime/id")
    fun getMangaDetailes (@Query("q") id: Manga): Call<Manga>
}