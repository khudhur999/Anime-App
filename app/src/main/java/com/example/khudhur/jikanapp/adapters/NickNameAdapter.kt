//package com.example.khudhur.jikanapp.adapters
//
//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.example.khudhur.jikanapp.R
//import com.example.khudhur.jikanapp.models.Character
//import kotlinx.android.synthetic.main.item_nickname.view.*
//import org.w3c.dom.NameList
//
//class NickNameAdapter : RecyclerView.Adapter<NickNameAdapter.NameViewHolder> {
//    val nickNameList : List<String>
//    constructor(nickNameList: List<String>){
//        this.nickNameList = nickNameList
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nickname, parent, false)
//        return NameViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return nickNameList.size
//    }
//
//    override fun onBindViewHolder(viewHolder: NameViewHolder, position: Int) {
//            viewHolder.setNickName(nickNameList[position])
//    }
//
//
//
//    inner class NameViewHolder: RecyclerView.ViewHolder {
//        val view : View
//        constructor(view : View) : super(view) {
//            this.view = view
//        }
//        fun setNickName ( name : Character){
//            view.nameTextView.text = name.alternativeNames.toString()
//        }
//
//    }
//}