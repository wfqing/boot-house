package com.etoak.utils;

import org.apache.commons.collections4.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wfqing on 2020/4/22.
 */
public class Validator {
    private static javax.validation.Validator validator;
    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }
    public static void validate(Object object) {
        Set<ConstraintViolation<Object>> validate = validator.validate(object);

        if(CollectionUtils.isNotEmpty(validate)){
            Iterator<ConstraintViolation<Object>> iterator = validate.iterator();
            StringBuffer buffer = new StringBuffer();
            while(iterator.hasNext()){
                ConstraintViolation<Object> violation = iterator.next();
                String message = violation.getMessage();
                buffer.append(message).append(";");
            }
            throw new RuntimeException("参数错误"+ buffer.toString());


        }



    }

}
