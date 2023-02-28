package com.example.webviewsampleapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById<WebView>(R.id.webapp)

        loadWebViewWithHTMLFile(webView)
    }

    @SuppressLint("JavascriptInterface")
    fun loadWebViewWithHTMLFile(webView: WebView){
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("file:///android_asset/index.html")

        webView.addJavascriptInterface(WebAppInterface(), "Android")
        val webSettings = webView.getSettings()
        webSettings.setJavaScriptEnabled(true)
    }
}

class WebAppInterface
internal constructor() {
    @JavascriptInterface
    fun getAndroidVersion(): Int {
        return android.os.Build.VERSION.SDK_INT
    }
}