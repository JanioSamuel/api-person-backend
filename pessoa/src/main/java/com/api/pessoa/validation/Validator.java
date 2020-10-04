package com.api.pessoa.validation;

import com.api.pessoa.model.Person;

public interface Validator {

	void validate(Person person) throws Exception;
}
