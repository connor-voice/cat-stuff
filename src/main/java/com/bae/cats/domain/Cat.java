package com.bae.cats.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Double size;

	@Column
	private String fluffy;

	@Column
	private String name;

	public Cat() {
		super();
	}

	public Cat(Integer id, Double size, String fluffy, String name) {
		super();
		this.id = id;
		this.size = size;
		this.fluffy = fluffy;
		this.name = name;
	}

	public Cat(Double size, String fluffy, String name) {
		super();
		this.size = size;
		this.fluffy = fluffy;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public String getFluffy() {
		return fluffy;
	}

	public void setFluffy(String fluffy) {
		this.fluffy = fluffy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat [size=" + size + ", fluffy=" + fluffy + ", name=" + name + "]";
	}

}
