package Validation;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Stateless
public class DataValidator {

    private Validator validator;

    @PostConstruct
    private void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public boolean check(Object obj){
        Set<ConstraintViolation<Object>> validate = validator.validate(obj);
        return validate.size() == 0;
    }
}
