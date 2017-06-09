package com.speedway.mobile.eclesiastico.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.speedway.mobile.eclesiastico.R;

import static com.speedway.mobile.eclesiastico.R.id.btn_pesquisa;
import static com.speedway.mobile.eclesiastico.R.id.txt_pesquisa;
import static com.speedway.mobile.eclesiastico.R.id.webviewmusicas;

public class MusicasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        WebView view = (WebView) findViewById(R.id.webView);
//        view.getSettings().setJavaScriptEnabled(true);
//        view.getSettings().setBuiltInZoomControls(true);
//        view.loadUrl("https://www.cifraclub.com.br/?q=" + Uri.encode(nomeMusica.getText().toString()));
//
//        view.setWebViewClient(new WebViewClient());
//            public boolean shouldOverriceUrlLoading(WebView view, String url){
//                return false;
//        }

        //Conectou os componentes visuais
        final TextView txtPesquisa = (TextView) findViewById(txt_pesquisa);
        Button btnPesquisa = (Button) findViewById(btn_pesquisa);
        final WebView view = (WebView) findViewById(webviewmusicas);

//        view.loadUrl("https://www.cifraclub.com.br/?q=" + Uri.encode(txtPesquisa.getText().toString()));

        //Configurando os componentes
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(false);
        view.setWebViewClient (new WebViewClient());

        //Configurando os listeners
        btnPesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view.loadUrl("https://www.cifraclub.com.br/?q=" + Uri.encode(txtPesquisa.getText().toString()));
            }
        });


        //
//        String url = ("https://www.cifraclub.com.br/?q=" + Uri.encode(txtPesquisa.getText().toString()));
//        WebView view = (WebView) this.findViewById(R.id.webviewmusicas);
//        view.getSettings().setJavaScriptEnabled(true);
//        view.getSettings().setBuiltInZoomControls(true);
//        view.loadUrl(url);

    }
}
