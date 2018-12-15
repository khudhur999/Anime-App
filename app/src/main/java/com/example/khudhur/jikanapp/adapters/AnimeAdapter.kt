package com.example.khudhur.jikanapp.adapters

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.activities.AnimeScrollingDetails
import com.example.khudhur.jikanapp.models.Anime
import com.example.khudhur.jikanapp.utilities.Consts
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_anime.view.*

class AnimeAdapter(val animeList: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animeList.size

    }

    override fun onBindViewHolder(viewHolder: AnimeViewHolder, position: Int) {
        viewHolder.setAnime(animeList[position])

    }


    inner class AnimeViewHolder//                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(view.context as Activity
//                    , Pair<View, String>(view.discriptionTextView, "details_transition"))
//                scrollingIntent.putExtra(Consts.ANIME_ID, animeID)
//                options.toBundle()
    (val view: View) : RecyclerView.ViewHolder(view) {

        init {
            this.view.setOnClickListener {
                val scrollingIntent = Intent(it.context, AnimeScrollingDetails::class.java)
                val anime = animeList[layoutPosition]
                scrollingIntent.putExtra(Consts.ANIME, anime)

//                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(view.context as Activity
//                    , Pair<View, String>(view.discriptionTextView, "details_transition"))
//                scrollingIntent.putExtra(Consts.ANIME_ID, animeID)
                it.context.startActivity(scrollingIntent)
//                options.toBundle()
            }
        }

        fun setAnime(anime: Anime) {
            view.animeTextView.text = anime.title
            Picasso.get().load(anime.imageUrl).into(view.animeImageView)

        }
    }
}