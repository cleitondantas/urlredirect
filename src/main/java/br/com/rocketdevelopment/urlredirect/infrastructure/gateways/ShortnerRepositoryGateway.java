package br.com.rocketdevelopment.urlredirect.infrastructure.gateways;

import br.com.rocketdevelopment.urlredirect.application.gateways.ShortnerGateway;
import br.com.rocketdevelopment.urlredirect.domain.entity.Shortner;
import br.com.rocketdevelopment.urlredirect.infrastructure.persistence.ShortenerRepository;
import br.com.rocketdevelopment.urlredirect.infrastructure.persistence.ShortnerEntity;

public class ShortnerRepositoryGateway implements ShortnerGateway {

    private final ShortenerRepository shortenerRepository;
    private final ShortnersEntityMapper shortnersEntityMapper;

    public ShortnerRepositoryGateway(ShortenerRepository shortenerRepository, ShortnersEntityMapper shortnersEntityMapper) {
        this.shortenerRepository = shortenerRepository;
        this.shortnersEntityMapper = shortnersEntityMapper;
    }

    @Override
    public Shortner save(Shortner shortnerEntity) {
        ShortnerEntity saveEntity = shortenerRepository.save(shortnersEntityMapper.toEntity(shortnerEntity));
        return shortnersEntityMapper.toDomain(saveEntity);
    }

    @Override
    public Shortner findByShorten(String shorten) {
        Shortner shortner = shortenerRepository.findByShorten(shorten).map(shortnersEntityMapper::toDomain).orElseThrow(() -> new RuntimeException("URL not found"));
        return shortner;
    }
}
