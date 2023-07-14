package com.jhorghifratama201103643.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewLanjutanMainActivity extends AppCompatActivity
{

    private WebView _webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_lanjutan_main);

        _webView1 = (WebView) findViewById(R.id.webView1);

        WebViewClient webViewClient = new WebViewClient();
        _webView1.setWebViewClient(webViewClient);

        WebChromeClient webChromeClient = new WebChromeClient();
        _webView1.setWebChromeClient(webChromeClient);

        WebSettings webSettings = _webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        WebAppInterface webAppInterface = new WebAppInterface(this, WebViewLanjutanMainActivity.this);
        _webView1.addJavascriptInterface(webAppInterface, "Android");

        String url = "https://stmikpontianak.net/011100862/webview_lanjutan.html";
        _webView1.loadUrl(url);

    }
}