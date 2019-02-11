package com.example.dragonist.health;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView ivMain;
    private ImageView ivFind;
    private ImageView ivLike;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        ivMain = findViewById(R.id.main);
        ivFind = findViewById(R.id.find);
        ivLike = findViewById(R.id.like);
        webView = findViewById(R.id.web);

        webView.loadUrl("http://118.25.210.13:8080/HEALTH/index.jsp");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setAppCacheEnabled(true);


        ivMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://192.168.43.193:8080/HEALTH/index.jsp");
            }
        });

        ivFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://192.168.43.193:8080/HEALTH/search.jsp");
            }
        });

        ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://192.168.43.193:8080/HEALTH/mine.jsp");
            }
        });
    }
}
