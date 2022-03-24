package com.daleksic.errorhandlingdemo.validation;

import com.daleksic.errorhandlingdemo.entity.User;
import com.daleksic.errorhandlingdemo.exception.GenericValidationException;
import com.daleksic.errorhandlingdemo.util.Constants;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {
    public void validate(User user) {
        if(user.getFirstname().isBlank()){
            throw new GenericValidationException("first name is blank");
        }
        if(user.getLastname().isBlank()){
            throw new GenericValidationException("last name is blank");
        }

        validateOib(user.getOib());


    }

    private void validateOib(String oib) {
        if(oib.isBlank()){
            throw new GenericValidationException(Constants.FIELD_IS_BLANK);
        }
        if(OibValidation.checkOIBState(oib) == 1){
            throw new GenericValidationException("length is incorrect");
        }
        if(OibValidation.checkOIBState(oib) == 2){
            throw new GenericValidationException("length is incorrect");
        }
        if(OibValidation.checkOIBState(oib) == 3){
            throw new GenericValidationException("length is incorrect");
        }
    }
}
