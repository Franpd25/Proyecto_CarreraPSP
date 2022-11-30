package com.franprados.ProyectoCarrera.model;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	protected int id;
	protected String name;
	protected int age;
	protected int dorsal;
	protected String nationality;
	protected List<Carrera> careers;
	
	public Jugador() {
		this(-1, "", -1, 1, "", new ArrayList<>());
	}

	public Jugador(int id, String name, int age, int dorsal, String nationality, List<Carrera> careers) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dorsal = dorsal;
		this.nationality = nationality;
		this.careers = careers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<Carrera> getCareers() {
		return careers;
	}

	public void setCareers(List<Carrera> careers) {
		this.careers = careers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", name=" + name + ", age=" + age + ", dorsal=" + dorsal + ", nationality="
				+ nationality + ", careers=" + careers + "]";
	}

}
