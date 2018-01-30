package soft.dev.academy.customersorders.dto;


import java.io.Serializable;

public class ProductDto implements Serializable {

    private Integer id;

    private String name;

    private Integer quantity;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public ProductDto() {

    }

    public ProductDto(Integer id, String name, Integer quantity, String type) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
    }

}
