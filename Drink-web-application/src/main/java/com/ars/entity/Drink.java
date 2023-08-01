package com.ars.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Drink")
public class Drink {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String type;
	private boolean alcoholic;

	public Drink() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drink(int id, String name, String type, boolean alcoholic) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.alcoholic = alcoholic;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAlcoholic() {
		return alcoholic;
	}

	public void setAlcoholic(boolean alcoholic) {
		this.alcoholic = alcoholic;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", type=" + type + ", alcoholic=" + alcoholic + "]";
	}

}