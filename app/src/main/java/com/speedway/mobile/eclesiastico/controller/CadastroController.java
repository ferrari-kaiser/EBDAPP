package com.speedway.mobile.eclesiastico.controller;

import com.speedway.mobile.eclesiastico.activity.CadastroActivity;
import com.speedway.mobile.eclesiastico.R;
import com.speedway.mobile.eclesiastico.util.l.Utils;
import com.speedway.mobile.eclesiastico.util.l.mask.MaskEditTextChangedListener;
import com.speedway.mobile.eclesiastico.util.l.validations.ValidationsForms;

/**
 * Created by ferrari on 21/04/2017.
 */

public class CadastroController extends BaseActivityController<CadastroActivity> {


    public CadastroController(CadastroActivity activity) {
        super(activity);
    }

    public void initDataComponent(){


//        activity.getEddatanascimento().addTextChangedListener(new MaskEditTextChangedListener("##/##/####", activity.getEddatanascimento()));
        activity.getEdtelefone().addTextChangedListener(new MaskEditTextChangedListener("(##)#####-####", activity.getEdtelefone()));


//        Utils.hideSoftKeyboardOnMaxLength(activity, activity.getEddatanascimento(), 10);
//        Utils.hideSoftKeyboardOnMaxLength(activity, activity.getEddatanascimento(), 10);
        Utils.hideSoftKeyboardOnMaxLength(activity,activity.getEdtelefone(), 13);

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







        if(activity.getEdtelefone().getText().toString().isEmpty()){
            activity.getEdtelefone().setError(activity.getString(R.string.error_invalid));
            activity.getEdtelefone().requestFocus();
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
