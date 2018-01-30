package soft.dev.academy.customersorders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import soft.dev.academy.customersorders.converters.CustomerConverter;
import soft.dev.academy.customersorders.dto.CustomerDto;
import soft.dev.academy.customersorders.entity.Customer;
import soft.dev.academy.customersorders.entity.CustomerStatus;
import soft.dev.academy.customersorders.repository.CustomerRepository;
import sun.plugin2.message.Message;

import java.util.Locale;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public void registerCustomer(CustomerDto customerDto) {
        Customer customer = customerConverter.convert(customerDto);
        customer.setStatus(CustomerStatus.NEW);
        customerRepository.save(customer);

        String activationTitle = messageSource.getMessage("mail.activation.title", new Object[] {
                customer.getFirstName()}, Locale.getDefault());

        String mailText = messageSource.getMessage("mail.activation.text", new Object[] {
                customer.getLogin(), customer.getToken()}, Locale.getDefault());

        emailService.sendSimpleMessage(customer.getEmail(), activationTitle, mailText);
    }

    @Override
    public boolean activateUser(String login, String token) {
        Customer customer = customerRepository.findOneByLoginAndToken(login, token);
        if (customer!=null&& customer.getStatus().equals(CustomerStatus.NEW)) {
            customer.setStatus(CustomerStatus.ACTIVATED);
            customerRepository.save(customer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean authenticate(String login, String password) {
        return customerRepository.findOneByLoginAndPasswordAndStatus(
                login, password, CustomerStatus.ACTIVATED)!=null? true: false;
    }
}
