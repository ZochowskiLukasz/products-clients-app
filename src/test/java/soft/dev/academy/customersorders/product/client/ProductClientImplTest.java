package soft.dev.academy.customersorders.product.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import soft.dev.academy.customersorders.dto.ProductDto;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@RestClientTest(ProductClientImpl.class)
public class ProductClientImplTest {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        String productString =
                objectMapper.writeValueAsString(new ProductDto(1, "butterf", 5,"FOOD" ));

        this.server.expect(requestTo("/products/1"))
                .andRespond(withSuccess("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"name\": \"butterf\",\n" +
                        "  \"type\": \"Food category\",\n" +
                        "  \"quantity\": 5\n" +
                        "}", MediaType.APPLICATION_JSON));
    }


    @Test
    public void findById() {
        ProductDto productDto = productClient.findById(1);
        Assert.assertEquals("butterf",productDto.getName());
    }
}