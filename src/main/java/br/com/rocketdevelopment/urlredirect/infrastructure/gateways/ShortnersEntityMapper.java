package br.com.rocketdevelopment.urlredirect.infrastructure.gateways;

import br.com.rocketdevelopment.urlredirect.domain.entity.Shortner;
import br.com.rocketdevelopment.urlredirect.infrastructure.persistence.ShortnerEntity;

public class ShortnersEntityMapper {
    public  ShortnerEntity toEntity(Shortner shortner) {
        return new ShortnerEntity(shortner.shorten(), shortner.url());
    }

    public  Shortner toDomain(ShortnerEntity shortnerEntity) {
        return new Shortner(shortnerEntity.getShorten(), shortnerEntity.getUrl());
    }
}
