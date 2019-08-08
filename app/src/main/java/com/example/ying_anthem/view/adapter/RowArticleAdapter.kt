package com.example.ying_anthem.view.adapter

import android.content.Context
import android.support.annotation.NonNull
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.example.ying_anthem.R
import com.example.ying_anthem.model.pojo.Article


class RowArticleAdapter() : RecyclerView.Adapter<RowArticleAdapter.MyViewHolder>() {


    lateinit var mlist: ArrayList<Article>
    lateinit var context: Context
    lateinit var inflater: LayoutInflater
    lateinit var myOnClickListner: setOnClickListener

    constructor(context: Context?, list: ArrayList<Article>) : this() {
        this.context = context!!
        mlist = list
        inflater = LayoutInflater.from(context)
    }

    fun setData(list: ArrayList<Article>) {
        mlist = list
        notifyDataSetChanged()
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.row_article_list, viewGroup, false)
        return MyViewHolder(view)
    }

    fun initOnClickListener(myonClick: setOnClickListener) {
        myOnClickListner = myonClick
    }

    interface setOnClickListener {
        fun onClickListener(v: View, position: Int)
    }


    override fun onBindViewHolder(@NonNull myViewHolder: MyViewHolder, i: Int) {
        val article = mlist.get(i)
        myViewHolder.article_author.text = "From: ${article.author}"
        myViewHolder.article_title.text = article.title
        myViewHolder.article_description.text = article.description
        myViewHolder.article_content.text = article.content
        Glide.with(context).load(article.urlToImage).into(myViewHolder.article_image)

    }

    override fun getItemCount(): Int {
        return mlist.size
    }


    inner class MyViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var article_image: ImageView
        var article_title: TextView
        var article_author: TextView
        var article_description: TextView
        var article_content: TextView
        var car_view: CardView

        init {
            article_image = itemView.findViewById(R.id.article_Image)
            article_author = itemView.findViewById(R.id.article_author)
            article_title = itemView.findViewById(R.id.article_title)
            article_description = itemView.findViewById(R.id.article_description)
            article_content = itemView.findViewById(R.id.article_content)
            car_view = itemView.findViewById(R.id.article_card_view)
            car_view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            myOnClickListner.onClickListener(v, adapterPosition)
        }
    }
}
