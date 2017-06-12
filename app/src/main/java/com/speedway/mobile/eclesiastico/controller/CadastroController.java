package com.speedway.mobile.eclesiastico.controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

import com.speedway.mobile.eclesiastico.R;
import com.speedway.mobile.eclesiastico.activity.CadastroActivity;
import com.speedway.mobile.eclesiastico.model.BaseResponseRest;
import com.speedway.mobile.eclesiastico.model.Membro;
import com.speedway.mobile.eclesiastico.rest.ConnectionEclesiasticoService;
import com.speedway.mobile.eclesiastico.util.l.Utils;
import com.speedway.mobile.eclesiastico.util.l.mask.MaskEditTextChangedListener;
import com.speedway.mobile.eclesiastico.util.l.validations.ValidationsForms;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ferrari on 21/04/2017.
 */

public class CadastroController extends BaseActivityController<CadastroActivity> {


    public CadastroController(CadastroActivity activity) {
        super(activity);
    }

    public void initDataComponent() {


//        activity.getEddatanascimento().addTextChangedListener(new MaskEditTextChangedListener("##/##/####", activity.getEddatanascimento()));
        activity.getEdtelefone().addTextChangedListener(new MaskEditTextChangedListener("(##)#####-####", activity.getEdtelefone()));


//        Utils.hideSoftKeyboardOnMaxLength(activity, activity.getEddatanascimento(), 10);
//        Utils.hideSoftKeyboardOnMaxLength(activity, activity.getEddatanascimento(), 10);
        Utils.hideSoftKeyboardOnMaxLength(activity, activity.getEdtelefone(), 13);

    }

    public void enviarCadastro(Membro membro, final Activity activity){


        Call<BaseResponseRest> call = ConnectionEclesiasticoService.getService().cadastroMembro(membro);

        call.enqueue(new Callback<BaseResponseRest>() {
            @Override
            public void onResponse(Call<BaseResponseRest> call, Response<BaseResponseRest> response) {
                try {
                    Utils.alertaMensagem(activity, response.body().getMensagem(), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            activity.finish();
                        }
                    });

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<BaseResponseRest> call, Throwable t) {
                Utils.alertaMensagem(activity, t.getMessage());
                t.printStackTrace();
            }
        });
    }

    public boolean isValidateActivity() {
        boolean nomeError = false;
        boolean cpfError = false;
        boolean dataDeAniverssárioError = false;
        boolean emailError = false;
        boolean nacionalidadeError = false;
        boolean telefoneCelularError = false;
        boolean cepError = false;


        if (activity.getEdnome().getText().toString().isEmpty()) {
            activity.getEdnome().setError(activity.getString(R.string.error_invalid));
            activity.getEdnome().requestFocus();
            nomeError = true;
        }


        if (activity.getEdtelefone().getText().toString().isEmpty()) {
            activity.getEdtelefone().setError(activity.getString(R.string.error_invalid));
            activity.getEdtelefone().requestFocus();
            telefoneCelularError = true;
        }


        if (!ValidationsForms.isEmail(activity.getEdemail().getText().toString())) {
            activity.getEdemail().setError(activity.getString(R.string.error_invalid_email));
            activity.getEdemail().requestFocus();
            emailError = true;
        }


        if (nomeError || dataDeAniverssárioError || emailError || telefoneCelularError) {
            return false;
        } else {
            return true;
        }
    }

}
