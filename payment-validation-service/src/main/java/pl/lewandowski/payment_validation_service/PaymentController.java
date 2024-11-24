package pl.lewandowski.payment_validation_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-validation-service")
public class PaymentController {


    @Autowired
    EbookDeliveryClient ebookDeliveryClient;

    // Na ten adres ma przychodzic informacja jak zostanie dokonana jakas platnosc w Stripe
    @PostMapping("/webhook")
    public String webhook(@RequestBody String paymentInfo) throws JsonProcessingException {
        System.out.println(paymentInfo);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(paymentInfo);
        String email = root.path("data").path("object").path("customer_details").path("email").asText();

        System.out.println("Email: " + email);
        ebookDeliveryClient.sendEmail(email);
        return "hello world";
    }
}
