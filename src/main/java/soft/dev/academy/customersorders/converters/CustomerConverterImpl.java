package soft.dev.academy.customersorders.converters;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import soft.dev.academy.customersorders.dto.CustomerDto;
import soft.dev.academy.customersorders.entity.Customer;

import java.util.UUID;

@Component
public class CustomerConverterImpl implements  CustomerConverter {

    @Override
    public Customer convert(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setSecondName(customerDto.getSecondName());
        customer.setLogin(customerDto.getLogin());
        customer.setPassword(DigestUtils.md5Hex(customerDto.getPassword()));
        customer.setToken(UUID.randomUUID().toString());
        customer.setId(customerDto.getId());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }

    @Override
    public CustomerDto convertDto(Customer customer) {
        return null;
    }
}
