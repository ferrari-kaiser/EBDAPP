package com.speedway.mobile.eclesiastico.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.speedway.mobile.eclesiastico.R;
import com.speedway.mobile.eclesiastico.controller.CadastroController;
import com.speedway.mobile.eclesiastico.model.Membro;
import com.speedway.mobile.eclesiastico.util.Identity;

import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;


public class PerfilActivity extends AppCompatActivity {


    private android.widget.EditText ednome;
    private android.widget.EditText edtelefonecelular;
    private android.widget.EditText eddatanascimento;
    private android.widget.EditText edemail;
    private CircleImageView perfilImagem;
    private Button btnAtualizarDados;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

//        this.btnCadastre = (Button) findViewById(R.id.btn_entrar);
        this.edtelefonecelular = (EditText) findViewById(R.id.ed_telefone_celular);
        this.edemail = (EditText) findViewById(R.id.ed_email);
        this.eddatanascimento = (EditText) findViewById(R.id.ed_data_nascimento);
        this.ednome = (EditText) findViewById(R.id.ed_nome);
        this.perfilImagem = (CircleImageView) findViewById(R.id.imagem_perfil);
        this.btnAtualizarDados = (Button)findViewById(R.id.btn_atualizar_dados);

        edtelefonecelular.setText(Identity.membroLogado.getTelefone());
        edemail.setText(Identity.membroLogado.getEmail());
        ednome.setText(Identity.membroLogado.getNome());

        btnAtualizarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Identity.membroLogado.setNome(ednome.getText().toString());
                Identity.membroLogado.setEmail(edemail.getText().toString());
                Identity.membroLogado.setTelefone(edtelefonecelular.getText().toString());

                new CadastroController(null).enviarCadastro(Identity.membroLogado,PerfilActivity.this);
            }
        });

        if (Identity.membroLogado.getDataNascimento() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            eddatanascimento.setText(sdf.format(new Date(Identity.membroLogado.getDataNascimento())));
        }

        if (Identity.membroLogado.getFotoBase64() != null) {
            byte[] decodedString = Base64.decode(Identity.membroLogado.getFotoBase64(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            this.perfilImagem.setImageBitmap(decodedByte);
        }


    }
}
