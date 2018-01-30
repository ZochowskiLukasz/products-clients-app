package soft.dev.academy.customersorders.product.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import soft.dev.academy.customersorders.dto.ProductDto;

import java.util.List;

@Component
public class ProductClientImpl implements ProductClient{

    @Value("${product.server.address}")
    private String productServiceAddress;

    private RestTemplate restTemplate;

    public ProductClientImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<ProductDto> findAll() {
        ResponseEntity<ProductDto[]> responseEntity = restTemplate.getForEntity(productServiceAddress+"/products/", ProductDto[].class);
        return CollectionUtils.arrayToList(responseEntity.getBody());
    }

    public ProductDto findById(@PathVariable Integer id) {
        return  restTemplate.getForObject(productServiceAddress+"/products/1", ProductDto.class);
    }

}
