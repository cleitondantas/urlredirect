package br.com.rocketdevelopment.urlredirect.config;

import br.com.rocketdevelopment.urlredirect.application.gateways.ShortnerGateway;
import br.com.rocketdevelopment.urlredirect.application.usecases.URLShortenerInteractor;
import br.com.rocketdevelopment.urlredirect.infrastructure.gateways.ShortnerRepositoryGateway;
import br.com.rocketdevelopment.urlredirect.infrastructure.gateways.ShortnersEntityMapper;
import br.com.rocketdevelopment.urlredirect.infrastructure.persistence.ShortenerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    URLShortenerInteractor shortnerInteractor(ShortnerGateway shortnerGateway) {
        return new URLShortenerInteractor(shortnerGateway);
    }

    @Bean
    ShortnerGateway shortnerGateway(ShortenerRepository shortenerRepository, ShortnersEntityMapper shortnersEntityMapper) {
        return new ShortnerRepositoryGateway(shortenerRepository, shortnersEntityMapper);
    }
    @Bean
    ShortnersEntityMapper shortnersEntityMapper() {
        return new ShortnersEntityMapper();
    }
}
