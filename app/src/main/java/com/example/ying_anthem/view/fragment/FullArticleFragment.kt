package com.example.ying_anthem.view.fragment


import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.ying_anthem.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FullArticleFragment : Fragment() {

    lateinit var webview: WebView
    val URL: String = "URL"
    val TAG = "News"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_full_article, container, false)

        //get url from bundle
        var bundle: Bundle? = arguments
        var mUrl = bundle?.getString(URL, null)

        //set up webview
        webview = view.findViewById(R.id.web_view)
        webview.webViewClient = MyBrowser()
        webview.settings.javaScriptEnabled
        webview.loadUrl(mUrl)
        Log.i(TAG, "Got: " + mUrl)


        return view
    }


    //set up webview client
    private class MyBrowser : WebViewClient() {

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {

            view?.loadUrl(request?.url.toString())
            return super.shouldOverrideUrlLoading(view, request)
        }
    }


}
