package com.ecodeup.model;

public class Estudiante {
	private int cui;
	private String nombres;
	private String apellidos;
	private String correo;

	public Estudiante(int cui, String nombres, String apellidos, String correo) {
		super();
		this.cui = cui;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
	}

	public Estudiante() {
		super();
	}

	public int getCui() {
		return cui;
	}

	public void setCui(int cui) {
		this.cui = cui;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Estudiante [cui=" + cui + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + "]";
	}
}