package soft.dev.academy.customersorders.converters;

import soft.dev.academy.customersorders.dto.CustomerDto;
import soft.dev.academy.customersorders.entity.Customer;

public interface CustomerConverter {

    public Customer convert(CustomerDto customerDto);

    public CustomerDto convertDto(Customer customer);
}
