package soft.dev.academy.customersorders.dto;

import soft.dev.academy.customersorders.entity.Customer;

import javax.persistence.Id;

public class CustomerDto {

    @Id
    private int id;

    private String firstName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String secondName;

    public CustomerDto(int id, String firstName, String secondName, String login, String password, String type) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public CustomerDto() {

    }

    public String getEmail() {
        return email;
    }

    public String email;

    public void setEmail(String email) {
        this.email = email;
    }

    private String login;

    private String password;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
