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
import com.example.khudhur.jikanapp.MangaInterface
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.adapters.MangaAdapter
import com.example.khudhur.jikanapp.models.Manga
import com.example.khudhur.jikanapp.models.MangaSearchResponse
import com.example.khudhur.jikanapp.utilities.Consts
import com.example.khudhur.jikanapp.utilities.gone
import com.example.khudhur.jikanapp.utilities.visible
import kotlinx.android.synthetic.main.fragment_manga.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MangaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_manga, container, false)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mangaSearchEditText.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            searchManga(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }
    private fun searchManga (searchQuery: String){
        progressBar2.visible()

        val retrofit = Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val mangaInterface = retrofit.create(MangaInterface::class.java)
                mangaInterface.searchManga(searchQuery)
                .enqueue(object : Callback<MangaSearchResponse>{
            override fun onFailure(call: Call<MangaSearchResponse>, t: Throwable) {
            Toast.makeText(activity,t.message,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<MangaSearchResponse>, response: Response<MangaSearchResponse>) {
                response.body()?.let {
                    prepareMangaRecyclerView(it.results)
                    progressBar2.gone()
                    mangaRecyclerView.visible()
                }
            }


        })

    }

    private fun prepareMangaRecyclerView(mangaList: List<Manga>) {
        mangaRecyclerView.layoutManager = GridLayoutManager(activity,3)
        mangaRecyclerView.adapter = MangaAdapter(mangaList)
    }
}
