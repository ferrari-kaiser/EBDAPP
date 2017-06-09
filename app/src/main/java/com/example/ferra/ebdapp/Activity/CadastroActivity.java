package com.example.ferra.ebdapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ferra.ebdapp.Banco.Cadastro;
import com.example.ferra.ebdapp.Banco.DB;
import com.example.ferra.ebdapp.Controller.CadastroController;
import com.example.ferra.ebdapp.R;

public class CadastroActivity extends AppCompatActivity {

    CadastroController mController = new CadastroController(this);

    private Cadastro cadastro = new Cadastro();
    private android.widget.Button btnCadastre;
    private android.widget.EditText ednome;
    private android.widget.EditText edtelefone;
    private android.widget.EditText edsenha;
    private android.widget.EditText edconfirmasenha;
    private android.widget.EditText edemail;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);

//
        initView();

        mController.initDataComponent();

        btnCadastre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.isValidateActivity();

                if(mController.isValidateActivity()){
                    salvarUsuario ();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity (intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Deu Errado",Toast.LENGTH_LONG).show();
                }
            }
        });


        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){


                    cadastro.setId (bundle.getLong ("id"));
                    cadastro.setNome (bundle.getString ("nome"));
                    cadastro.setEmail (bundle.getString ("email"));
                    cadastro.setTelefone (bundle.getInt ("telefone"));
                    cadastro.setSenha (bundle.getString ("senha"));
//                    cadastro.setConfirmasenha (bundle.getString ("confirmasenha"));


                    ednome.setText (cadastro.getNome ());
                    edemail.setText (cadastro.getEmail ());
                    edtelefone.setText ((int) cadastro.getTelefone ());
                    edsenha.setText (cadastro.getSenha ());
//                    edconfirmasenha.setText (cadastro.getConfirmasenha ());


                    edsenha.setVisibility (View.VISIBLE);
                    edconfirmasenha.setVisibility (View.VISIBLE);
                    btnCadastre.setVisibility (View.VISIBLE);

            }
        }
    }

    private void salvarUsuario () {
        cadastro.setNome(ednome.getText().toString());
        cadastro.setEmail(edemail.getText().toString());
        cadastro.setTelefone (edtelefone.getInputType ());
        cadastro.setSenha (edsenha.getText().toString());
//        cadastro.setConfirmasenha (edconfirmasenha.getText().toString());



        DB db = new DB(this);
        db.inserir(cadastro);

        Toast.makeText(this, "Usuário inserido com sucesso!", Toast.LENGTH_SHORT).show();
    }




    public void editarUsuario(View view){
        cadastro.setNome(ednome.getText().toString());
        cadastro.setEmail(edemail.getText().toString());
        cadastro.setTelefone (edtelefone.getInputType ());
        cadastro.setSenha (edsenha.getText().toString());

        DB db = new DB(this);
        db.atualizar(cadastro);

        Toast.makeText(this, "Usuário \""+cadastro.getNome()+"\" atuailizado com sucesso.", Toast.LENGTH_SHORT).show();



    }

    private void initView() {

        this.btnCadastre = (Button) findViewById(R.id.btn_entrar);
        this.edtelefone = (EditText) findViewById(R.id.ed_telefone_celular);
        this.edemail = (EditText) findViewById(R.id.ed_email);
        this.edsenha = (EditText) findViewById(R.id.ed_senha);
        this.edconfirmasenha = (EditText) findViewById(R.id.ed_confirma_senha);
        this.ednome = (EditText) findViewById(R.id.ed_nome);
    }

    //get Set de Views

    public EditText getEdnome() {
        return ednome;
    }

    public void setEdnome(EditText ednome) {
        this.ednome = ednome;
    }


    public EditText getEdsenha() {
        return edsenha;
    }

    public void setEdsenha(EditText edsenha) {
        this.edsenha = edsenha;
    }


    public EditText getEdconfirmasenha() {
        return edconfirmasenha;
    }

    public void setEdconfirmasenha(EditText edconfirmasenha) {
        this.edconfirmasenha = edconfirmasenha;
    }


    public EditText getEdemail() {
        return edemail;
    }

    public void setEdemail(EditText edemail) {
        this.edemail = edemail;
    }

    public EditText getEdtelefone() {
        return edtelefone;
    }

    public void setEdtelefone(EditText edtelefone) {
        this.edtelefone = edtelefone;
    }


}