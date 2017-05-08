package com.example.ferra.ebdapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.ferra.ebdapp.R;

import static com.example.ferra.ebdapp.R.id.nav_calendario;
import static com.example.ferra.ebdapp.R.id.nav_sair;
import static com.example.ferra.ebdapp.R.id.webviewfeed;

public class FeedActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private Button btnSair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        final WebView view = (WebView) findViewById(webviewfeed);

        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(false);
        view.setWebViewClient (new WebViewClient ());

        view.loadUrl("http://www.adguara2.org.br/#fwdmspPlayer0?catid=0&trackid=0");

    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//            Intent  intent = new Intent(getApplicationContext(), LoginActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intent.putExtra("SAIR", true);
//            startActivity(intent);
//        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.feed, menu);
        return true;



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.nav_calendario) {
            Intent intent = new Intent(getApplicationContext(), CalendarioActivity.class);
            startActivity(intent);


            return true;
        }


        return super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == nav_calendario) {
            Intent intent = new Intent(getApplicationContext(), CalendarioActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_agenda) {
            Intent intent = new Intent(getApplicationContext(), AgendaActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_musicas) {
            Intent intent = new Intent(getApplicationContext(), MusicasActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_perfil) {
            Intent intent = new Intent(getApplicationContext(), PerfilActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_como_chegar) {
            Intent intent = new Intent(getApplicationContext(), ComoChegarActivity.class);
            startActivity(intent);

        } else {
            if (id == nav_sair) {
                Intent  intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("SAIR", true);
                startActivity(intent);

            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

//
//        @Override
//        protected void onResume() {
//            if(getIntent().getBooleanExtra("SAIR", false)){
//                finish();
//            }
//            super.onResume();
//        }



    }


}
