package com.example.khudhur.jikanapp.models
import com.google.gson.annotations.SerializedName


open class BaseSearchResponse(
    @SerializedName("request_hash")
    var requestHash: String = "", // request:search:b5021fb5569664933c0ddceeeda2cfdfbe5ad745
    @SerializedName("request_cached")
    var requestCached: Boolean = false, // true
    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: String = "", // 43200

    @SerializedName("last_page")
    var lastPage: String = "" // 20
)

