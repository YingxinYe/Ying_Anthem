package com.example.ying_anthem.view.fragment


import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ying_anthem.R
import com.example.ying_anthem.model.pojo.Article
import com.example.ying_anthem.view.activities.MainActivity
import com.example.ying_anthem.view.adapter.RowArticleAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ArticleListFragment : Fragment(), RowArticleAdapter.setOnClickListener {


    var mlist: MutableLiveData<ArrayList<Article>> = MutableLiveData()
    val URL: String = "URL"
    val TAG = "News"
    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_article_list, container, false)


        //get data from server
        var newsFeedViewModel = (mContext as MainActivity).getViewModel()

        mlist = newsFeedViewModel.getNewFeed((mContext as MainActivity).application)

        //set up recycler view and adapter
        var rv: RecyclerView = view.findViewById(R.id.recycler_view)
        var rvLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)

        mlist.observe(this, Observer {
            if (it == null) {
                Log.i(TAG, "Empty list")
            } else {
                var adapter = RowArticleAdapter(context, it.toList() as ArrayList<Article>)
                adapter.initOnClickListener(this)

                rv.layoutManager = rvLayoutManager
                rv.adapter = adapter
            }
        })

        return view
    }

    //click on one of article list will open a new fragment with webview
    override fun onClickListener(v: View, position: Int) {
        var url: String? = mlist.value?.get(position)?.url
        var bundle = Bundle()
        bundle.putString(URL, url)
        var frag = FullArticleFragment()
        frag.arguments = bundle
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, frag).addToBackStack(null)
            .commit()
    }


}
