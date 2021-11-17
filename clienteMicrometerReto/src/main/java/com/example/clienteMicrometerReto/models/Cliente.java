package com.example.clienteMicrometerReto.models;

public class Cliente {

	private String nombre = "unknow";
	private String estado = "unknow";
	
	
	public Cliente() {};
	
	public Cliente(String nombre, String status) {
		super();
		this.nombre = nombre;
		this.estado = status;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getStatus() {
		return estado;
	}
	
	public void setStatus(String status) {
		this.estado = status;
	}
	
}
