package com.example.ferra.ebdapp.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ferrari on 30/05/2017.
 */

public class DBUsuario extends SQLiteOpenHelper {
    private static final String NOME_BD = "cadastro";
    private static final int VERSAO_BD = 7;


    public DBUsuario (Context context) {
        super (context, NOME_BD, null, VERSAO_BD);
    }


    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL ("create table cadastro(_id integer primary key autoincrement," +
                                            " nome text not null, " +
                                            "email text not null," +
                                            "telefone int not null," +
                                            "senha text not null);");
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int arg1, int arg2) {
        db.execSQL ("drop table cadastro;");
        onCreate (db);
    }

}
