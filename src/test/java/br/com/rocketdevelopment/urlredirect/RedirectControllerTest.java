package br.com.rocketdevelopment.urlredirect;

import br.com.rocketdevelopment.urlredirect.domain.entity.Shortner;
import br.com.rocketdevelopment.urlredirect.domain.usecases.URLShortener;
import br.com.rocketdevelopment.urlredirect.infrastructure.controller.RedirectController;
import br.com.rocketdevelopment.urlredirect.infrastructure.controller.UrlRequest;
import br.com.rocketdevelopment.urlredirect.infrastructure.controller.UrlResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RedirectControllerTest {

    @Mock
    private URLShortener urlShortener;

    @InjectMocks
    private RedirectController redirectController;

    @Test
    public void redirectTest() {

        String urlcode = "testCode";
        Shortner shortner = new Shortner(urlcode, "testUrl");
        when(urlShortener.getLongURL(urlcode)).thenReturn(shortner);

        ResponseEntity<Void> result = redirectController.redirect(urlcode);

        assertEquals(HttpStatus.FOUND, result.getStatusCode());
        assertEquals(shortner.url(), result.getHeaders().getLocation().toString());
    }
    @Test
    public void createTest() {
        // Arrange
        String url = "http://test.com";
        String shorten = "testShorten";
        UrlRequest urlRequest = new UrlRequest(url);
        Shortner shortner = new Shortner(shorten, url);
        when(urlShortener.shortenURL(url)).thenReturn(shortner);

        // Act
        ResponseEntity<UrlResponse> result = redirectController.create(urlRequest);

        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(shorten, result.getBody().urlCode());
    }
}