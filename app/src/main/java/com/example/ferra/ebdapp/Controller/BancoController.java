package com.example.ferra.ebdapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ferra.ebdapp.Banco.CriaBanco;

/**
 * Created by ferrari on 30/05/2017.
 */

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;
    public String horainicial;
    public String horafinal;
    public String descricao;
    public String imagem;

    public BancoController (Context context, SQLiteDatabase.CursorFactory factory){
        banco = new CriaBanco(context, factory);
    }

    public String insereDado (String horainicial, String horafinal, String descricao, String imagem){
        this.horainicial = horainicial;
        this.horafinal = horafinal;
        this.descricao = descricao;
        this.imagem = imagem;

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(CriaBanco.HORAINICIAL, horainicial);
        valores.put(CriaBanco.HORAFINAL, horafinal);
        valores.put(CriaBanco.DESCRICAO, descricao);
        valores.put(CriaBanco.IMAGEM, imagem);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }


}
