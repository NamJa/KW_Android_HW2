package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyWebBrowser extends AppCompatActivity {

    EditText editText;
    WebView webView;
    WebSettings webSettings;
    Button backBtn, nextBtn, calculateExecute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_browser);

        // 키패드 설정 ==> editText 클릭할 때, 레이아웃이 밀리지 않고 그대로 오버랩 하여 출력
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);
        backBtn = findViewById(R.id.backBtn);
        nextBtn = findViewById(R.id.nextBtn);
        calculateExecute = findViewById(R.id.calculateExecuteBtn);

        //webView 세팅
        webView.setWebViewClient(new WebViewClient());
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportMultipleWindows(false);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDomStorageEnabled(true);

        //webView 로딩
        webView.loadUrl("https://www.naver.com");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                editText.setText(url.toString());
            }
        });
        // 이전 버튼
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webView.canGoBack())
                    webView.goBack();
            }
        });
        // 다음 버튼
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webView.canGoForward())
                    webView.goForward();
            }
        });

        //editText에서 enter키 동작 정의
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH) //에뮬레이터 소프트키로 누를 경우
                {
                    String url = editText.getText().toString();
                    if(!url.startsWith("http"))
                    {
                        editText.setText("http://" + url);
                    }
                    webView.loadUrl(editText.getText().toString());
                    InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    im.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                } else { // 에뮬레이터에서 컴퓨터 키보드로 엔터버튼을 누를 경우
                    String url = editText.getText().toString();
                    if(!url.startsWith("http"))
                    {
                        editText.setText("http://" + url);
                    }
                    webView.loadUrl(editText.getText().toString());
                    InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    im.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
            }
        });
        // Mycalculator activity 실행
        calculateExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyCalculator.class);
                startActivity(intent);
            }
        });
    }
}