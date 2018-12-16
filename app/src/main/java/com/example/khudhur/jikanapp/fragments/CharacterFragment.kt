package com.example.khudhur.jikanapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.khudhur.jikanapp.R
import com.example.khudhur.jikanapp.adapters.CharacterAdapter
import com.example.khudhur.jikanapp.models.Character
import com.example.khudhur.jikanapp.models.CharacterSearchResponse
import com.example.khudhur.jikanapp.utilities.CharacterInterfase
import com.example.khudhur.jikanapp.utilities.Consts
import com.example.khudhur.jikanapp.utilities.gone
import com.example.khudhur.jikanapp.utilities.visible
import kotlinx.android.synthetic.main.fragment_character.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CharacterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterSearchEditText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                searchCharacter(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }
    private fun searchCharacter (searchQuery : String){
        progressBar3.visible()
        val retrofit = Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val characterInterface = retrofit.create(CharacterInterfase::class.java)
        characterInterface.searchCharacter(searchQuery).enqueue(object : Callback<CharacterSearchResponse>{
            override fun onFailure(call: Call<CharacterSearchResponse>, t: Throwable) {
                Toast.makeText(activity,t.message,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<CharacterSearchResponse>, response: Response<CharacterSearchResponse>) {
                response.body()?.let {
                    prepareCharacterRecyclerview(it.results)
                    progressBar3.gone()
                    characterRecyclerView.visible()

                }
            }

        })
    }
    private fun prepareCharacterRecyclerview(characterList : List<Character>){
        characterRecyclerView.layoutManager = GridLayoutManager(activity,3)
        characterRecyclerView.adapter = CharacterAdapter(characterList)
    }


}
