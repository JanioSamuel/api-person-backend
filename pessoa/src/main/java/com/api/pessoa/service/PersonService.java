package com.api.pessoa.service;

import java.util.List;

import com.api.pessoa.model.Person;

public interface PersonService {
	
	public List<Person> findAll();

	public Person insertPerson(Person person);

	public Person editPerson(Person person);

	public void deletePerson(int id);
}
