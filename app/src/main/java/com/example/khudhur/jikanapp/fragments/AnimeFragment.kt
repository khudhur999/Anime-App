package com.example.khudhur.jikanapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.khudhur.jikanapp.AnimeInterface
import com.example.khudhur.jikanapp.utilities.Consts
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.adapters.AnimeAdapter
import com.example.khudhur.jikanapp.models.Anime
import com.example.khudhur.jikanapp.models.CharactersAppearances
import com.example.khudhur.jikanapp.models.AnimeSearchResponse
import com.example.khudhur.jikanapp.utilities.gone
import com.example.khudhur.jikanapp.utilities.visible
import kotlinx.android.synthetic.main.fragment_anime.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AnimeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_anime, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        searchAnime("2010")
        super.onViewCreated(view, savedInstanceState)
        searchAnimeEditText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                searchAnime(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

    }

    private fun searchAnime(searchQuery: String) {
        progressBar.visible()


        val retrofit = Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val animeInterface = retrofit.create(AnimeInterface::class.java)
        animeInterface.searchAnime(searchQuery).enqueue(object : Callback<AnimeSearchResponse> {
            override fun onFailure(call: Call<AnimeSearchResponse>, t: Throwable) {
                Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                progressBar.gone()
            }

            override fun onResponse(call: Call<AnimeSearchResponse>, response: Response<AnimeSearchResponse>) {
            response.body()?.let {
                prepareRecyclerView(it.results)
                progressBar.gone()
                recyclerView.visible()

            }
            }

        })

    }

    private fun prepareRecyclerView(animeList: List<Anime>) {
        recyclerView.layoutManager = GridLayoutManager(activity,3)
        recyclerView.adapter = AnimeAdapter(animeList)
    }


}
