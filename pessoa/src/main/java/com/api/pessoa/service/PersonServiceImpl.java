package com.api.pessoa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.pessoa.model.Person;
import com.api.pessoa.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;

	@Override
	public List<Person> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Person insertPerson(Person person) {
		person.setCreatedAt(LocalDate.now());
		person.setUpdatedAt(LocalDate.now());
		return repository.save(person);
	}

	@Override
	public Person editPerson(Person person) {
		person.setUpdatedAt(LocalDate.now());
		return repository.save(person);
	}

	@Override
	public void deletePerson(int id) {
		Person entity = repository.findById(id);
		if (entity != null) {
			repository.delete(entity);
		}
	}
}
