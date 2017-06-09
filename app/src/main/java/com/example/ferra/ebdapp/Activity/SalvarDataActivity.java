package com.example.ferra.ebdapp.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.ferra.ebdapp.R;

import java.util.Date;

public class SalvarDataActivity extends AppCompatActivity {

    public Spinner sp_hora_inicial;
    public Spinner sp_hora_final;
    public Button btnBanner;
    private AlertDialog alerta;
    public static final int IMAGEM_INTERNA = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        // capturando dado
        Intent intent = getIntent();
        Long dateSelected = intent.getLongExtra("dataLongMiliseconds", 0);
        Date date = new Date(dateSelected);

        sp_hora_inicial = (Spinner) findViewById(R.id.sp_hora_inicial);
        sp_hora_final = (Spinner) findViewById(R.id.sp_hora_final);

        btnBanner = (Button) findViewById (R.id.btn_banner);

        btnBanner.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {

                alertaImagem ();

            }
        });

    }



    private void alertaImagem() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("EBD APP");
        //define a mensagem
        builder.setMessage("Deseja tirar foto ou selecionar imagem da galeria do aparelho?");
        //define um botão como positivo
        builder.setPositiveButton("Foto", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

                tirarFoto ();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Galeria", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
//
                pegarImg ();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }


    private void tirarFoto() {

        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 0);
    }


    public void pegarImg () {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGEM_INTERNA);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
            if (requestCode == IMAGEM_INTERNA) {
                if (resultCode == RESULT_OK) {

                    ((ImageView) findViewById (R.id.img_banner)).setImageURI (intent.getData ());


                }

            }

        if (intent != null){

            Bundle bundle = intent.getExtras();
            if (bundle!= null){



                Bitmap img = (Bitmap) bundle.get("data");


                ImageView iv = (ImageView) findViewById(R.id.img_banner);
                iv.setImageBitmap(img);
//


            }
        }

        }



//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
////        super.onActivityResult(requestCode, resultCode, data);
//        if (intent != null){
//
//            Bundle bundle = intent.getExtras();
//            if (bundle!= null){
//
//
//
//                Bitmap img = (Bitmap) bundle.get("data");
//
//
//                ImageView iv = (ImageView) findViewById(R.id.img_banner);
//                iv.setImageBitmap(img);
////
//
//
//            }
//        }
//    }
//


}
