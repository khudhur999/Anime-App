package com.example.khudhur.jikanapp.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("mal_id")
    var malId: Int = 0, // 94975
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/character/94975/Leo
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/characters/4/225709.jpg?s=6c90f7c0f61b4fce47ad4265764d6d39
    @SerializedName("name")
    var name: String = "", // Leo
    @SerializedName("alternative_names")
    var alternativeNames: List<String> = listOf(),
    @SerializedName("anime")
    var anime: List<CharactersAppearances> = listOf(),
    @SerializedName("manga")
    var manga: List<CharactersAppearances> = listOf()
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList(),
            parcel.createTypedArrayList(CharactersAppearances.CREATOR),
            parcel.createTypedArrayList(CharactersAppearances.CREATOR)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(malId)
        parcel.writeString(url)
        parcel.writeString(imageUrl)
        parcel.writeString(name)
        parcel.writeStringList(alternativeNames)
        parcel.writeTypedList(anime)
        parcel.writeTypedList(manga)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}