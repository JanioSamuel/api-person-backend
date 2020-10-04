package com.api.pessoa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.pessoa.model.Person;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface PersonRepository extends CrudRepository<Person, Integer>{

	List<Person> findAll();
	
	Person findById(int id);
	
	Person findByTaxpayerId(String id);
}
