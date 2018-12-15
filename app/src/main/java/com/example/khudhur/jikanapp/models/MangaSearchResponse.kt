package com.example.khudhur.jikanapp.models

import com.google.gson.annotations.SerializedName

class MangaSearchResponse (
    @SerializedName("results")
    var results: List<Manga> = listOf()

)    : BaseSearchResponse()

