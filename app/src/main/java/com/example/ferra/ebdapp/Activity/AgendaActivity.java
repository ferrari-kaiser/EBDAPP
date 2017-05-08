package com.example.ferra.ebdapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.ferra.ebdapp.R;

public class AgendaActivity extends AppCompatActivity {

//    private Button btn_chamada;
//    private Button btn_chamada_2;
//    private Button btn_chamada_3;
//    private Button btn_chamada_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamada);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//
//        btn_chamada = (Button) findViewById(R.id.btn_chamada);
//        btn_chamada_2 = (Button) findViewById(R.id.btn_chamada_2);
//        btn_chamada_3 = (Button) findViewById(R.id.btn_chamada_3);
//        btn_chamada_4 = (Button) findViewById(R.id.btn_chamada_4);
//
//        btn_chamada.setOnClickListener (new View.OnClickListener () {
//            @Override
//            public void onClick (View v) {
//                Intent intent = new Intent (getApplicationContext(), SalvarChamadaActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//        btn_chamada_2.setOnClickListener (new View.OnClickListener () {
//            @Override
//            public void onClick (View v) {
//                Intent intent = new Intent (getApplicationContext(), SalvarChamadaActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//
//        btn_chamada_3.setOnClickListener (new View.OnClickListener () {
//            @Override
//            public void onClick (View v) {
//                Intent intent = new Intent (getApplicationContext(), SalvarChamadaActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//
//        btn_chamada_4.setOnClickListener (new View.OnClickListener () {
//            @Override
//            public void onClick (View v) {
//                Intent intent = new Intent (getApplicationContext(), SalvarChamadaActivity.class);
//                startActivity(intent);
//
//            }
//        });






//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
