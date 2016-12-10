package com.pallefire.websearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et,et2;
    WebView wv;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        b1 = (Button) findViewById(R.id.bt1);
        b2 = (Button) findViewById(R.id.bt2);
        wv = (WebView) findViewById(R.id.wb1);
        wv.setWebViewClient(new MyBrowser());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.getSettings().setJavaScriptEnabled(true);
                String str = et.getText().toString();
                wv.loadUrl(str);
            }
        });

    }
    private class MyBrowser extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
