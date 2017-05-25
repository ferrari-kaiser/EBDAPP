package com.example.ferra.ebdapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.ferra.ebdapp.R;

import java.util.Date;

public class SalvarDataActivity extends AppCompatActivity {

    public Spinner sp_hora_inicial;
    public Spinner sp_hora_final;
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


//        // fazendo alguma coisa com o dado capturado
//        TextView txt = (TextView) findViewById(R.id.txt_salvar_data);
//        txt.setText(date.toString());


    }

//    public Spinner getsp_hora_inicial() {return sp_hora_inicial}

    public void pegarImg(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGEM_INTERNA);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
//        if (requestCode==IMAGEM_INTERNA){
//            if(resultCode==RESULT_OK){
//                Uri imagemSelecionada = intent.getData ();
//
//                String[] colunas = {MediaStore.Images.Media.DATA};
//
//                Cursor cursor = getContentResolver ().query (imagemSelecionada, colunas, null, null, null);
//                cursor.moveToFirst ();
//
//                int indexColuna = cursor.getColumnIndex (colunas[0]);
//                String pathImg = cursor.getString (indexColuna);
//                cursor.close ();
//
//                Bitmap bitmap = BitmapFactory.decodeFile (pathImg);
//                ImageView img_banner = (ImageView) findViewById (R.id.img_banner);
//                img_banner.setImageBitmap (bitmap);
//            }
//
//        }
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == IMAGEM_INTERNA) {
            if (resultCode == RESULT_OK) {
//
//                Uri uriImagemSelecionada = intent.getData();
//                ImageView img_banner = (ImageView) findViewById(R.id.img_banner);
//                img_banner.setImageURI(uriImagemSelecionada);

                ((ImageView) findViewById(R.id.img_banner)).setImageURI(intent.getData());



            }

        }

    }


}
