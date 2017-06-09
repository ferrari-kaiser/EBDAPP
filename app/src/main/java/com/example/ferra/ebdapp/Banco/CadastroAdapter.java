package com.example.ferra.ebdapp.Banco;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ferra.ebdapp.Activity.CadastroActivity;
import com.example.ferra.ebdapp.R;

import java.util.List;

/**
 * Created by ferrari on 03/06/2017.
 */

public class CadastroAdapter extends BaseAdapter {

    private Context context;
    private List<Cadastro> list;

    public CadastroAdapter(Context context, List<Cadastro> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0).getId();
    }

    @Override
    public View getView(int position, View arg1, ViewGroup arg2) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.cadastro, null);

        TextView tv = (TextView) layout.findViewById(R.id.nome);
        tv.setText(list.get(position).getNome());


        Button editarBt = (Button) layout.findViewById(R.id.editar);
        editarBt.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, CadastroActivity.class);
                intent.putExtra("nome", list.get(auxPosition).getNome());
                intent.putExtra("email", list.get(auxPosition).getEmail());
                intent.putExtra ("telefone", list.get (auxPosition).getTelefone ());
                intent.putExtra("id", list.get(auxPosition).getId());
                context.startActivity(intent);
            }
        });

//        Button deletarBt = (Button) layout.findViewById(R.id.deletar);
//        deletarBt.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View arg0) {
//                BD bd = new BD(context);
//                bd.deletar(list.get(auxPosition));
//
//                layout.setVisibility(View.GONE);
//            }
//        });

        return layout;
    }

    }
