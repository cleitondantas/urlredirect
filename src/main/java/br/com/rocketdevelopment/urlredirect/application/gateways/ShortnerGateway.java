package br.com.rocketdevelopment.urlredirect.application.gateways;

import br.com.rocketdevelopment.urlredirect.domain.entity.Shortner;

public interface ShortnerGateway {
    Shortner save(Shortner shortnerEntity);
    Shortner findByShorten(String shorten);
}
