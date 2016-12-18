package com.devctrl.agoncal.data.entity;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by rob on 18.12.16.
 */
public class AddressIT {


    @Test
    public void shouldRaiseConstraintViolationCauseInvalidZipCode() {

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

        Address address = new Address("233 Spring Street", "New York", "NY", "DummyZip", "USA");

        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(1, violations.size());

        vf.close();
    }

}
