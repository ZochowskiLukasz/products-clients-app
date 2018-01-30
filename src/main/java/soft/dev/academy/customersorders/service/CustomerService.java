package soft.dev.academy.customersorders.service;

import soft.dev.academy.customersorders.dto.CustomerDto;

public interface CustomerService {

    public void registerCustomer(CustomerDto customerDto);

    public boolean activateUser(String login, String password);

    public boolean authenticate(String login, String password);
}
