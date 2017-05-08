package com.example.ferra.ebdapp.Controller;

import com.example.ferra.ebdapp.Activity.CadastroActivity;
import com.example.ferra.ebdapp.R;
import com.example.ferra.ebdapp.util.l.Utils;
import com.example.ferra.ebdapp.util.l.mask.MaskEditTextChangedListener;
import com.example.ferra.ebdapp.util.l.validations.ValidationsForms;

/**
 * Created by ferrari on 21/04/2017.
 */

public class CadastroController extends BaseActivityController<CadastroActivity> {


    public CadastroController(CadastroActivity activity) {
        super(activity);
    }

    public void initDataComponent(){


        activity.getEddatanascimento().addTextChangedListener(new MaskEditTextChangedListener("##/##/####", activity.getEddatanascimento()));
        activity.getEdtelefonecelular().addTextChangedListener(new MaskEditTextChangedListener("(##)#####-####", activity.getEdtelefonecelular()));


        Utils.hideSoftKeyboardOnMaxLength(activity, activity.getEddatanascimento(), 10);
        Utils.hideSoftKeyboardOnMaxLength(activity, activity.getEddatanascimento(), 10);
        Utils.hideSoftKeyboardOnMaxLength(activity,activity.getEdtelefonecelular(), 13);

    }

    public boolean isValidateActivity(){
        boolean nomeError = false;
        boolean cpfError = false;
        boolean dataDeAniverssárioError = false;
        boolean emailError = false;
        boolean nacionalidadeError = false;
        boolean telefoneCelularError = false;
        boolean cepError = false;


        if(activity.getEdnome().getText().toString().isEmpty()){
            activity.getEdnome().setError(activity.getString(R.string.error_invalid));
            activity.getEdnome().requestFocus();
            nomeError = true;
        }


        if(activity.getEddatanascimento().getText().toString().length() < 10){
            activity.getEddatanascimento().setError(activity.getString(R.string.error_data_nascimento_invalida));
            activity.getEddatanascimento().requestFocus();
            dataDeAniverssárioError = true;
        }





        if(activity.getEdtelefonecelular().getText().toString().isEmpty()){
            activity.getEdtelefonecelular().setError(activity.getString(R.string.error_invalid));
            activity.getEdtelefonecelular().requestFocus();
            telefoneCelularError = true;
        }


        if(!ValidationsForms.isEmail(activity.getEdemail().getText().toString())){
            activity.getEdemail().setError(activity.getString(R.string.error_invalid_email));
            activity.getEdemail().requestFocus();
            emailError = true;
        }


        if(nomeError ||  dataDeAniverssárioError ||emailError || telefoneCelularError){
            return false;
        }else {
            return true;
        }
    }

}
