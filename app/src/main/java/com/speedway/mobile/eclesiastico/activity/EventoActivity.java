package com.speedway.mobile.eclesiastico.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.speedway.mobile.eclesiastico.R;
import com.speedway.mobile.eclesiastico.model.BaseResponseRest;
import com.speedway.mobile.eclesiastico.model.Evento;
import com.speedway.mobile.eclesiastico.rest.ConnectionEclesiasticoService;
import com.speedway.mobile.eclesiastico.util.l.Utils;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventoActivity extends AppCompatActivity {

    private Spinner sp_hora_inicial;
    private Spinner sp_hora_final;
    private Button btnBanner;
    private Button btnSalvar;
    private EditText txt_descricao;
    private AlertDialog alerta;
    public static final int IMAGEM_INTERNA = 12;
    public static Date date = new Date();
    private ListView listaEventos;

    private String fotoBase64 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sp_hora_inicial = (Spinner) findViewById(R.id.sp_hora_inicial);
        sp_hora_final = (Spinner) findViewById(R.id.sp_hora_final);

        btnBanner = (Button) findViewById(R.id.btn_banner);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        txt_descricao = (EditText) findViewById(R.id.txt_descricao);
        listaEventos = (ListView) findViewById(R.id.lista_eventos);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
                try {
                    Date dtInicial = sdf2.parse(sdf1.format(date) + " " + sp_hora_inicial.getSelectedItem().toString());
                    Date dtFinal = sdf2.parse(sdf1.format(date) + " " + sp_hora_final.getSelectedItem().toString());

                    Evento evento = new Evento();
                    evento.setDataInicio(dtInicial.getTime());
                    evento.setDataFim(dtFinal.getTime());
                    evento.setDescricaoEvento(txt_descricao.getText().toString());
                    evento.setFotoBase64(fotoBase64);

                    Call<BaseResponseRest> call = ConnectionEclesiasticoService
                            .getService()
                            .cadastroEvento(evento);

                    call.enqueue(new Callback<BaseResponseRest>() {
                        @Override
                        public void onResponse(Call<BaseResponseRest> call, Response<BaseResponseRest> response) {
                            if (response != null && response.body() != null) {
                                Utils.alertaMensagem(EventoActivity.this, response.body().getMensagem());
                                listarEventos();
                            }
                        }

                        @Override
                        public void onFailure(Call<BaseResponseRest> call, Throwable t) {
                            t.printStackTrace();
                            Utils.alertaMensagem(EventoActivity.this, t.getMessage());
                        }
                    });


                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        btnBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertaImagem();
            }
        });

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        TextView txtDataEvento = (TextView) findViewById(R.id.txt_data_evento);
        txtDataEvento.setText(sdf.format(date));

        listarEventos();

    }

    private void listarEventos(){
        Call<List<Evento>> call = ConnectionEclesiasticoService.getService().listarEventosDoDia(date.getTime());

        call.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                if(response!=null && response.body()!=null){

                    String[] arrResult = new String[response.body().size()];

                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                    int i=0;
                    for(Evento ev: response.body()){
                        arrResult[i++] = ev.getDescricaoEvento()
                                                + " de "
                                                + sdf.format(ev.getDataInicio())
                                                + " até " + sdf.format(ev.getDataFim());
                    }

                    ArrayAdapter<String> adapter =
                                new ArrayAdapter<>(getBaseContext(),
                                                            android.R.layout.activity_list_item,
                                                            android.R.id.text1,
                                                            arrResult);
                    listaEventos.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {
                Utils.alertaMensagem(EventoActivity.this, t.getMessage());
                t.printStackTrace();
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

                tirarFoto();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Galeria", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
//
                pegarImg();
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


    public void pegarImg() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGEM_INTERNA);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == IMAGEM_INTERNA) {
            if (resultCode == RESULT_OK) {
                ((ImageView) findViewById(R.id.img_banner)).setImageURI(intent.getData());
            }
        }

        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Bitmap img = (Bitmap) bundle.get("data");
                ImageView iv = (ImageView) findViewById(R.id.img_banner);
                iv.setImageBitmap(img);


                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                img.compress(Bitmap.CompressFormat.PNG, 100, stream);
                fotoBase64 = Base64.encodeToString(stream.toByteArray(), Base64.DEFAULT);
            }
        }
    }
}
