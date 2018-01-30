package soft.dev.academy.customersorders.validators;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import soft.dev.academy.customersorders.dto.CustomerDto;

import java.util.regex.Pattern;

@Component
public class CustomerDtoValidator implements Validator {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String LOGIN_PATTERN = "[a-zA-Z0-9]{5,}";

    @Override
    public boolean supports(Class<?> aClass) {
        return CustomerDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CustomerDto customerDto = (CustomerDto)o;
        if (StringUtils.isEmpty(customerDto.getFirstName())) {
            errors.rejectValue("firstName", "NotNull.customerModel.firstName");
        }

        Pattern loginPattern = Pattern.compile(LOGIN_PATTERN,
                Pattern.CASE_INSENSITIVE);
        if (!(loginPattern.matcher(customerDto.getLogin()).matches())) {
            errors.rejectValue("login", "customerModel.login.pattern");
        }

    }
}
