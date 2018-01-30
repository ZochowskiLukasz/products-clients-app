package soft.dev.academy.customersorders.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import soft.dev.academy.customersorders.dto.CustomerDto;
import soft.dev.academy.customersorders.security.providers.DatabaseAuthenticationProvider;
import soft.dev.academy.customersorders.service.CustomerService;
import soft.dev.academy.customersorders.validators.CustomerDtoValidator;

import java.util.Locale;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerDtoValidator customerDtoValidator;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private DatabaseAuthenticationProvider databaseAuthenticationProvider;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(customerDtoValidator);
    }

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/register")
    public String registerCustomer(Map<String, Object> model) {
        model.put("customerModel", new CustomerDto());
        return "customers/register";
    }

    @PostMapping("/customers/register")
    public String registerCustomer(@ModelAttribute("customerModel") @Validated CustomerDto customerDto, BindingResult result,
                                   Map<String, Object> model) {
        model.put("customerModel", customerDto);
        if (result.hasErrors()) {
            return "customers/register";
        }
        customerService.registerCustomer(customerDto);
        model.put("message", messageSource.getMessage("customer.registered",new Object[] {customerDto.getEmail()}, Locale.getDefault() ));
        return "message";
    }

    @GetMapping("/customers/activate")
    public String registerCustomer(@RequestParam("login") String login, @RequestParam("token") String token,Map<String, Object> model) {
        boolean activated=customerService.activateUser(login, token);

        String message;
        if (activated) {
            message = "customer.activated";
        } else {
            message = "customer.activated.fail";
        }

        model.put("message", messageSource.getMessage(message,new Object[] {login}, Locale.getDefault() ));

        return "message";
    }

    @GetMapping("/customers/login")
    public String customerLogin() {
        return "customers/login";
    }

    @GetMapping("/customers/shouldBeLogged")
    public String customerLogin(Map<String, Object> model,Authentication authentication) {
        model.put("message", "User "+authentication.getName()+" is logged");
        return "message";
    }
}
