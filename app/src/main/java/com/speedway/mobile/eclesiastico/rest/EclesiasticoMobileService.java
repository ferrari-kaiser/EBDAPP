package com.speedway.mobile.eclesiastico.rest;

import com.speedway.mobile.eclesiastico.model.AutenticacaoMembroRequest;
import com.speedway.mobile.eclesiastico.model.AutenticacaoMembroResponse;
import com.speedway.mobile.eclesiastico.model.BaseResponseRest;
import com.speedway.mobile.eclesiastico.model.Evento;
import com.speedway.mobile.eclesiastico.model.ImagemPerfilResponse;
import com.speedway.mobile.eclesiastico.model.Membro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yesus on 09/06/17.
 */

public interface EclesiasticoMobileService {

    @POST("membro/autenticar")
    Call<AutenticacaoMembroResponse> autenticar(@Body AutenticacaoMembroRequest request);


    @POST("membro/cadastro")
    Call<BaseResponseRest> cadastroMembro(@Body Membro membro);

    @GET("membro/imagem")
    Call<ImagemPerfilResponse> imagem(@Query("id") long id);


    @POST("evento/cadastro")
    Call<BaseResponseRest> cadastroEvento(@Body Evento evento);


    @GET("evento/listarEventosDoDia")
    Call<List<Evento>> listarEventosDoDia(@Query("dataPesquisa") Long dataPesquisa);

}
