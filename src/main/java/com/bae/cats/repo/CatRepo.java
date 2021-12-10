package com.bae.cats.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.cats.domain.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat, Integer> {

	// Spring will auto-generate all of the basic CRUD functionality

	List<Cat> findByName(String name);

	List<Cat> findBySize(Double size);

	List<Cat> findByFluffy(String isFluffy);

}