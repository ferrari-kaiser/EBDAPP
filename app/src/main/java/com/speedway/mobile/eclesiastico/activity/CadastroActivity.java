package com.speedway.mobile.eclesiastico.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.speedway.mobile.eclesiastico.R;
import com.speedway.mobile.eclesiastico.controller.CadastroController;
import com.speedway.mobile.eclesiastico.dao.Cadastro;
import com.speedway.mobile.eclesiastico.dao.DB;
import com.speedway.mobile.eclesiastico.model.BaseResponseRest;
import com.speedway.mobile.eclesiastico.model.Membro;
import com.speedway.mobile.eclesiastico.rest.ConnectionEclesiasticoService;
import com.speedway.mobile.eclesiastico.util.l.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    CadastroController mController = new CadastroController(this);

    private Cadastro cadastro = new Cadastro();
    private android.widget.Button btnCadastro;
    private android.widget.EditText ednome;
    private android.widget.EditText edtelefone;
    private android.widget.EditText edsenha;
    private android.widget.EditText edconfirmasenha;
    private android.widget.EditText edemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
        initView();

//        mController.initDataComponent();

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.isValidateActivity();

                if (mController.isValidateActivity()) {
//                    cadastrarUsuarioBD();
                    enviarCadastro();
                }
            }
        });


//        Intent intent = getIntent();
//        if(intent != null){
//            Bundle bundle = intent.getExtras();
//            if(bundle != null){
//
//
//                    cadastroMembro.setId (bundle.getLong ("id"));
//                    cadastroMembro.setNome (bundle.getString ("nome"));
//                    cadastroMembro.setEmail (bundle.getString ("email"));
//                    cadastroMembro.setTelefone (bundle.getInt ("telefone"));
//                    cadastroMembro.setSenha (bundle.getString ("senha"));
////                    cadastroMembro.setConfirmasenha (bundle.getString ("confirmasenha"));
//
//
//                    ednome.setText (cadastroMembro.getNome ());
//                    edemail.setText (cadastroMembro.getEmail ());
//                    edtelefone.setText ((int) cadastroMembro.getTelefone ());
//                    edsenha.setText (cadastroMembro.getSenha ());
////                    edconfirmasenha.setText (cadastroMembro.getConfirmasenha ());
//
//
//                    edsenha.setVisibility (View.VISIBLE);
//                    edconfirmasenha.setVisibility (View.VISIBLE);
//                    btnCadastro.setVisibility (View.VISIBLE);
//
//            }
//        }
    }


    public void enviarCadastro(){

        Membro membro  = new Membro();
        membro.setNome(ednome.getText().toString());
        membro.setEmail(edemail.getText().toString());
        membro.setSenha(edsenha.getText().toString());
        membro.setTelefone(edtelefone.getText().toString());

        new CadastroController(this).enviarCadastro(membro,this);
    }

    private void cadastrarUsuarioBD() {
        cadastro.setNome(ednome.getText().toString());
        cadastro.setEmail(edemail.getText().toString());
        cadastro.setTelefone(edtelefone.getInputType());
        cadastro.setSenha(edsenha.getText().toString());
//        cadastroMembro.setConfirmasenha (edconfirmasenha.getText().toString());


        DB db = new DB(this);
        db.inserir(cadastro);

        Toast.makeText(this, "Usuário inserido com sucesso!", Toast.LENGTH_SHORT).show();
    }


    public void editarUsuarioBD(View view) {
        cadastro.setNome(ednome.getText().toString());
        cadastro.setEmail(edemail.getText().toString());
        cadastro.setTelefone(edtelefone.getInputType());
        cadastro.setSenha(edsenha.getText().toString());

        DB db = new DB(this);
        db.atualizar(cadastro);

        Toast.makeText(this, "Usuário \"" + cadastro.getNome() + "\" atuailizado com sucesso.", Toast.LENGTH_SHORT).show();


    }

    private void initView() {

        this.btnCadastro = (Button) findViewById(R.id.btn_entrar);
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