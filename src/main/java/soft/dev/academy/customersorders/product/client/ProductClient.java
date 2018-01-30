package soft.dev.academy.customersorders.product.client;

import org.springframework.web.bind.annotation.PathVariable;
import soft.dev.academy.customersorders.dto.ProductDto;

import java.util.List;

public interface ProductClient {

    public List<ProductDto> findAll();

    public ProductDto findById(Integer id);
}
