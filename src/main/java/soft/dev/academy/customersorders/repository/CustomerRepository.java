package soft.dev.academy.customersorders.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soft.dev.academy.customersorders.entity.Customer;
import soft.dev.academy.customersorders.entity.CustomerStatus;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

    public Customer findOneByLoginAndToken(String login, String token);

    public Customer findOneByLoginAndPasswordAndStatus(String login, String password, CustomerStatus status);
}
