package com.speedway.mobile.eclesiastico.model;

public class ImagemPerfilResponse {
	
	private byte[] foto;

	
	public ImagemPerfilResponse(byte[] foto) {
		this.foto = foto;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}
