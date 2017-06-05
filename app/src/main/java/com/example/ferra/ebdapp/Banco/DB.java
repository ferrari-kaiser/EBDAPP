package com.example.ferra.ebdapp.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ferrari on 03/06/2017.
 */

public class DB {

    private SQLiteDatabase db;

    public DB(Context context){
        DBUsuario auxBd = new DBUsuario(context);
        db = auxBd.getWritableDatabase();
    }


    public void inserir(Cadastro cadastro){
        ContentValues valores = new ContentValues();
        valores.put("nome", cadastro.getNome());
        valores.put("email", cadastro.getEmail());
        valores.put("telefone", cadastro.getTelefone());
        valores.put("senha", cadastro.getSenha());
        valores.put("confirmasenha", cadastro.getConfirmasenha());

        db.insert("cadastro", null, valores);
    }


    public void atualizar(Cadastro cadastro){
        ContentValues valores = new ContentValues();
        valores.put("nome", cadastro.getNome());
        valores.put("email", cadastro.getEmail());
        valores.put("telefone", cadastro.getTelefone());
        valores.put("senha", cadastro.getSenha());
        valores.put("confirmasenha", cadastro.getConfirmasenha());

        db.update("cadastro", valores, "_id = ?", new String[]{""+cadastro.getId()});
    }


    public void deletar(Cadastro cadastro){
        db.delete("cadastro", "_id = "+cadastro.getId(), null);
    }


    public List<Cadastro> buscar(){
        List<Cadastro> list = new ArrayList<Cadastro> ();
        String[] colunas = new String[]{"_id", "nome", "email"};

        Cursor cursor = db.query ("cadastro", colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                Cadastro cadastro = new Cadastro();
                cadastro.setId(cursor.getLong(0));
                cadastro.setNome(cursor.getString(1));
                cadastro.setEmail(cursor.getString(2));
//                cadastro.setTelefone (cursor.getInt (3));
                list.add(cadastro);

            }while(cursor.moveToNext());
        }

        return(list);
    }

}
