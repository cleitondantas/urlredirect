package br.com.rocketdevelopment.urlredirect;
import br.com.rocketdevelopment.urlredirect.domain.entity.Shortner;
import br.com.rocketdevelopment.urlredirect.infrastructure.gateways.ShortnerRepositoryGateway;
import br.com.rocketdevelopment.urlredirect.infrastructure.gateways.ShortnersEntityMapper;
import br.com.rocketdevelopment.urlredirect.infrastructure.persistence.ShortenerRepository;
import br.com.rocketdevelopment.urlredirect.infrastructure.persistence.ShortnerEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShortnerRepositoryGatewayTest {

    @Mock
    private ShortenerRepository shortenerRepository;

    @Mock
    private ShortnersEntityMapper shortnersEntityMapper;

    @InjectMocks
    private ShortnerRepositoryGateway shortnerRepositoryGateway;

    @Test
    public void findByShortenTest() {

        String shorten = "testShorten";
        ShortnerEntity shortnerEntity = new ShortnerEntity();
        Shortner shortner = new Shortner("shorten", "testUrl");
        when(shortenerRepository.findByShorten(shorten)).thenReturn(Optional.of(shortnerEntity));
        when(shortnersEntityMapper.toDomain(shortnerEntity)).thenReturn(shortner);
        Shortner result = shortnerRepositoryGateway.findByShorten(shorten);
        assertEquals(shortner, result);
    }

    @Test
    public void findByShortenNotFoundTest() {
        String shorten = "testShorten";
        when(shortenerRepository.findByShorten(shorten)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> shortnerRepositoryGateway.findByShorten(shorten));
    }

    @Test
    public void saveTest() {
        Shortner shortner = new Shortner("shorten", "testUrl");
        ShortnerEntity shortnerEntity = new ShortnerEntity();
        when(shortnersEntityMapper.toEntity(shortner)).thenReturn(shortnerEntity);
        when(shortenerRepository.save(shortnerEntity)).thenReturn(shortnerEntity);
        when(shortnersEntityMapper.toDomain(shortnerEntity)).thenReturn(shortner);

        Shortner result = shortnerRepositoryGateway.save(shortner);

        assertEquals(shortner, result);
    }
}