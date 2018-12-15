package com.example.khudhur.jikanapp.utilities

import com.example.khudhur.jikanapp.models.CharacterSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterInterfase {
    @GET("search/character")
    fun searchCharacter(@Query("q") searchQuery: String): Call<CharacterSearchResponse>

//    @GET("anime/{id}")
//    fun characterDetails(@Path("id") id: Int) :Call<>
}