package com.escom.webviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_back;
    private Button btn_home;
    private Button btn_forward;
    private Button btn_go;
    private EditText et_url;
    private WebView wv_main;
    private WebSettings webSettings;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_back = findViewById(R.id.btn_back);
        btn_forward = findViewById(R.id.btn_forward);
        btn_go = findViewById(R.id.btn_go);
        btn_home = findViewById(R.id.btn_home);
        et_url = findViewById(R.id.et_url);
        url = "www.google.com";
        wv_main.setWebViewClient(new WebController());
        webSettings = wv_main.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true );
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_back:
                wv_main.goBack();
                break;
            case R.id.btn_home:
                wv_main.loadUrl(url);
                break;
            case R.id.btn_go:
                wv_main.loadUrl(et_url.getText().toString());
                break;
            case R.id.btn_forward:
                wv_main.goForward();
                break;
        }
    }

    class WebController extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            et_url.setText(url);
        }
    }
}
