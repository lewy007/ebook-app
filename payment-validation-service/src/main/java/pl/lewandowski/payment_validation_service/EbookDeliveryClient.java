package pl.lewandowski.payment_validation_service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface EbookDeliveryClient {

    @GetExchange("/ebook-delivery-service/send-email")
    public void sendEmail(@RequestParam String email);
}
