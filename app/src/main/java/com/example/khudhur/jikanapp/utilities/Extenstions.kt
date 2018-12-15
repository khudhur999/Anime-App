package com.example.khudhur.jikanapp.utilities

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun EditText.setTextChangeListner(callback : (text : String)-> Unit){
    addTextChangedListener(object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            callback(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    })
}
 fun ImageView.setImageFromURL (url :  String){
     Picasso.get().load(url).into(this)
 }
fun View.gone(){
    visibility = View.GONE
}
fun View.visible(){
    visibility = View.VISIBLE
}