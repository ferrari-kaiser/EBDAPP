package com.example.ferra.ebdapp.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.name;
import static android.R.attr.version;

/**
 * Created by ferrari on 30/05/2017.
 */

public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "data.db";
    public static final String TABELA = "data";
    public static final String ID = "id";
    public static final String HORAINICIAL = "horainicial";
    public static final String HORAFINAL = "horafinal";
    public static final String DESCRICAO = "descricao";
    public static final String IMAGEM = "imagem";


    public CriaBanco (Context context, SQLiteDatabase.CursorFactory factory) {

        super (context, String.valueOf (name), factory, version);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {

        String sql = "CREATE TABLE"+TABELA+"("
                + ID + "integer primary key autoincrement,"
                + HORAINICIAL + "text,"
                + HORAFINAL + "text,"
                + DESCRICAO + "text,"
                + IMAGEM + "text"
                +")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);

    }
}
