package com.bae.cats.service;

import java.util.ArrayList;
import java.util.List;

import com.bae.cats.domain.Cat;

public class CatServiceList implements CatService {
	private List<Cat> cats = new ArrayList<>();

	@Override
	public String hello() {
		return "Hello, World!";
	}

	@Override
	public Cat createCat(Cat cat) {
		cats.add(cat);
		Cat created = cats.get(cats.size() - 1);
		return created;
	}

	@Override
	public List<Cat> getCats() {
		return this.cats;
	}

	@Override
	public Cat getCat(Integer id) {
		return this.cats.get(id);
	}

	@Override
	public Cat replaceCat(Integer id, Cat newCat) {
		Cat replaceCat = cats.set(id, newCat);
		return replaceCat;
	}

	@Override
	public void removeCat(Integer id) {
		Cat deleteCat = cats.get(id);
		cats.remove(deleteCat);
		System.out.println("Deleted ID: " + id);
	}
}
