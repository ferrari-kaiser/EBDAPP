package com.speedway.mobile.eclesiastico.rest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import com.speedway.mobile.eclesiastico.model.*;

/**
 * Created by yesus on 09/06/17.
 */

public interface EclesiasticoMobileService {

    @POST("membro/autenticar")
    Call<AutenticacaoMembroResponse> autenticar(@Body AutenticacaoMembroRequest request);


    @POST("membro/cadastro")
    Call<BaseResponseRest> cadastro(@Body Membro membro);

    @GET("membro/imagem")
    Call<ImagemPerfilResponse> imagem(@Query("id") long id);

}
