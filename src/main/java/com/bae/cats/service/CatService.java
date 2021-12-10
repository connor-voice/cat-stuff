package com.bae.cats.service;

import java.util.List;

import com.bae.cats.domain.Cat;

public interface CatService {

	public String hello();
	
	
	public Cat createCat(Cat cat);
	
	public List<Cat> getCats();
	
	public Cat getCat(Integer id);
	
	public Cat replaceCat(Integer id, Cat newCat);
	
	public void removeCat(Integer id);
}
