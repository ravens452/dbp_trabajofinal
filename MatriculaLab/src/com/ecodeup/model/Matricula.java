package com.ecodeup.model;

public class Matricula {
	private int cui;
	private int codigo_laboratorio;
	public Matricula(int cui, int codigo_laboratorio) {
		super();
		this.cui = cui;
		this.codigo_laboratorio = codigo_laboratorio;
	}

	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCui() {
		return cui;
	}

	public void setCui(int cui) {
		this.cui = cui;
	}

	public int getCodigo_laboratorio() {
		return codigo_laboratorio;
	}

	public void setCodigo_laboratorio(int codigo_laboratorio) {
		this.codigo_laboratorio = codigo_laboratorio;
	}
	
	private String nombre;
	private String correo;
	private String curso;
	private int c_curso;
	public int getC_curso() {
		return c_curso;
	}

	public void setC_curso(int c_curso) {
		this.c_curso = c_curso;
	}

	private String grupo;
	private String aula;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	@Override
	public String toString() {
		return "Matricula [cui=" + cui + ", codigo_laboratorio=" + codigo_laboratorio + "]";
	}
}
