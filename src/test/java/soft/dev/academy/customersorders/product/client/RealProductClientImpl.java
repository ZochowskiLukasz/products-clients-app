package soft.dev.academy.customersorders.product.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import soft.dev.academy.customersorders.dto.ProductDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealProductClientImpl {

    @Autowired
    private ProductClient productClient;

    @Test
    public void findById() {
        ProductDto productDto = productClient.findById(1);
        Assert.assertEquals("butter",productDto.getName());
    }
}
