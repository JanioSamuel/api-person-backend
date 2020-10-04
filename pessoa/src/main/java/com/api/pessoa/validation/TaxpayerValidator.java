package com.api.pessoa.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.api.pessoa.exception.RequiredFieldsException;
import com.api.pessoa.model.Person;
import com.api.pessoa.repository.PersonRepository;

@Component
@Qualifier("TaxpayerValidator")
public class TaxpayerValidator implements Validator {


	@Autowired
	private PersonRepository repository;
	
	@Override
	public void validate(Person person) throws Exception {
		Person p = repository.findByTaxpayerId(person.getTaxpayerId());
		if (p != null) {
			throw new RequiredFieldsException(String.format("A person with taxpayer id '%s' already exists", person.getTaxpayerId()));
		}
		
	}

}
