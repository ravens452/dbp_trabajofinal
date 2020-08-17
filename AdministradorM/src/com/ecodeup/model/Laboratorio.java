package com.ecodeup.model;

import com.ecodeup.model.Curso;
import com.ecodeup.model.Aula;

public class Laboratorio extends Curso {
	 private int id; 
	 private String grupo;
	 private int codigo_curso; 
	 private String nro_aula;
	 private boolean permitir_matricula;
	 
	 
	public boolean isPermitir_matricula() {
		return permitir_matricula;
	}
	public void setPermitir_matricula(boolean permitir_matricula) {
		this.permitir_matricula = permitir_matricula;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public Laboratorio(int codigo,String grupo, int codigo_curso, String nro_aula) {
		this.id = codigo;
		this.grupo = grupo;
		this.codigo_curso = codigo_curso;
		this.nro_aula = nro_aula;
	}
	public Laboratorio()
	{
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodigo_curso() {
		return codigo_curso;
	}
	public void setCodigo_curso(int codigo_curso) {
		this.codigo_curso = codigo_curso;
	}
	public String getNro_aula() {
		return nro_aula;
	}
	public void setNro_aula(String nro_aula) {
		this.nro_aula = nro_aula;
	}
	
	@Override
	public String toString() {
		return "Laboratorio [id=" + id + ", grupo= " + grupo + ", codigo_curso=" + codigo_curso + ", nro_aula=" + nro_aula + "]";
	}
	 
	 
	 
}
