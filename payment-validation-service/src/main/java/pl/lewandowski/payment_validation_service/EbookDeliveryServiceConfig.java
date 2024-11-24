package pl.lewandowski.payment_validation_service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class EbookDeliveryServiceConfig {

    @Bean
    @LoadBalanced
    public RestClient.Builder getRestClient() {
        return RestClient.builder();
    }

    @Bean
    public EbookDeliveryClient createEbookDeliveryClient() {

        // podajemy nazwe serwisu, a nie konkretny adres z portem co jest bardziej elastyczne,
        // jesli mielibysmy wiecej instancji tego serwisu, bo load balancer rozrzuci rownomiernie ruch
        RestClient restClient = getRestClient()
                .baseUrl("http://EBOOK-DELIVERY-SERVICE")
                .build();

        // tworzymy adapter, ktory pozwala uzywac interfejsu do wywolywania REST
        // nie musimy recznie przekazywac metod, tylko adapter czyta je z interfejsu
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(EbookDeliveryClient.class);
    }
}
