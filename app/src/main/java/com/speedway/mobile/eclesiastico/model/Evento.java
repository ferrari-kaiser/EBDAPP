package com.speedway.mobile.eclesiastico.model;

public class Evento {

    private String descricaoEvento;
    private String fotoBase64;
    private long dataInicio;
    private long dataFim;


    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    public long getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(long dataInicio) {
        this.dataInicio = dataInicio;
    }

    public long getDataFim() {
        return dataFim;
    }

    public void setDataFim(long dataFim) {
        this.dataFim = dataFim;
    }

}
