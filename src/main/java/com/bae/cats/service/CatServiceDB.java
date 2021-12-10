package com.bae.cats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.cats.domain.Cat;
import com.bae.cats.repo.CatRepo;

@Service
public class CatServiceDB implements CatService {

	private CatRepo repo;

	@Autowired
	public CatServiceDB(CatRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cat createCat(Cat cat) {
		Cat created = this.repo.save(cat);
		return created;
	}

	@Override
	public List<Cat> getCats() {
		return this.repo.findAll();
	}

	@Override
	public Cat getCat(Integer id) {
		return this.repo.findById(id).get();
	}

	@Override
	public Cat replaceCat(Integer id, Cat newCat) {
		Cat existing = this.repo.findById(id).get();

		existing.setFluffy(newCat.getFluffy());
		existing.setName(newCat.getName());
		existing.setSize(newCat.getSize());
		return null;
	}

	@Override
	public void removeCat(Integer id) {
		this.repo.deleteById(id);

	}

}
