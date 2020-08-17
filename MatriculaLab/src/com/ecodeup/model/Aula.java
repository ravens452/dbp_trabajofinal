package com.ecodeup.model;

public class Aula {
	private String numero;
	private int capacidad;
	
	public Aula(String numero, int capacidad) {
		super();
		this.numero = numero;
		this.capacidad = capacidad;
	}
	public Aula()
	{
		super();
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	@Override
	public String toString() {
		return "Aula [numero=" + numero + ", capacidad=" + capacidad + "]";
	}
	
	
}
