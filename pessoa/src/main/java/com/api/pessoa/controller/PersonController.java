package com.api.pessoa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.pessoa.model.Person;
import com.api.pessoa.service.PersonService;
import com.api.pessoa.validation.Validator;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	@Qualifier("PersonValidator")
	private Validator personValidation;
	
	@Autowired
	@Qualifier("TaxpayerValidator")
	private Validator taxpayerValidation;

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public @ResponseBody List<Person> findAll() {
		return personService.findAll();
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public Person insertPerson(@Valid @RequestBody Person person) throws Exception {
		taxpayerValidation.validate(person);
		return personService.insertPerson(person);
	}

	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public Person editPerson(@Valid @RequestBody Person person) throws Exception {
		personValidation.validate(person);
		return personService.editPerson(person);
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deletePerson(final @PathVariable Integer id) {
		personService.deletePerson(id);
	}
}
