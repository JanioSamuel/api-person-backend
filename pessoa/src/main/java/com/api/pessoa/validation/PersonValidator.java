package com.api.pessoa.validation;

import org.springframework.stereotype.Component;

import com.api.pessoa.exception.RequiredFieldsException;
import com.api.pessoa.model.Person;

@Component
public class PersonValidator implements Validator {

	@Override
	public void validate(Person person) throws Exception {
		if (person.getId() == null || person.getCreatedAt() == null) {
			throw new RequiredFieldsException("id and createdAt cannot be null");
		}
	}
}
