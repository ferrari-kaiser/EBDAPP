package com.example.ferra.ebdapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ferra.ebdapp.Controller.CadastroController;
import com.example.ferra.ebdapp.R;

public class CadastroActivity extends AppCompatActivity {

    CadastroController mController = new CadastroController(this);

    private android.widget.Button btnCadastre;
    private android.widget.EditText ednome;
    private android.widget.EditText edtelefonecelular;
    private android.widget.EditText eddatanascimento;
    private android.widget.EditText edemail;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);

//        btnCadastre = (Button) findViewById(R.id.btn_entrar);
//
//        btnCadastre.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), FeedActivity.class);
//                startActivity(intent);
//            }
//        });

        initView();

        mController.initDataComponent();

        btnCadastre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.isValidateActivity();

                if(mController.isValidateActivity()){
                    Intent intent = new Intent(getApplicationContext(), FeedActivity.class);
                    startActivity (intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Deu Errado",Toast.LENGTH_LONG).show();
                }
            }
        });



    }

    private void initView() {

        this.btnCadastre = (Button) findViewById(R.id.btn_entrar);
        this.edtelefonecelular = (EditText) findViewById(R.id.ed_telefone_celular);
        this.edemail = (EditText) findViewById(R.id.ed_email);
        this.eddatanascimento = (EditText) findViewById(R.id.ed_data_nascimento);
        this.ednome = (EditText) findViewById(R.id.ed_nome);
    }

    //get Set de Views

    public EditText getEdnome() {
        return ednome;
    }

    public void setEdnome(EditText ednome) {
        this.ednome = ednome;
    }


    public EditText getEddatanascimento() {
        return eddatanascimento;
    }

    public void setEddatanascimento(EditText eddatanascimento) {
        this.eddatanascimento = eddatanascimento;
    }




    public EditText getEdemail() {
        return edemail;
    }

    public void setEdemail(EditText edemail) {
        this.edemail = edemail;
    }

    public EditText getEdtelefonecelular() {
        return edtelefonecelular;
    }

    public void setEdtelefonecelular(EditText edtelefonecelular) {
        this.edtelefonecelular = edtelefonecelular;
    }


}
