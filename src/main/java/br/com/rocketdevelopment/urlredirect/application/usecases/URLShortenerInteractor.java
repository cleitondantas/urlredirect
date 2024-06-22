package br.com.rocketdevelopment.urlredirect.application.usecases;

import br.com.rocketdevelopment.urlredirect.application.gateways.ShortnerGateway;
import br.com.rocketdevelopment.urlredirect.domain.entity.Shortner;
import br.com.rocketdevelopment.urlredirect.domain.usecases.URLShortener;

import java.util.Random;

public class URLShortenerInteractor implements URLShortener {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;
    private final ShortnerGateway shortnerGateway;

    public URLShortenerInteractor(ShortnerGateway shortnerGateway) {
        this.shortnerGateway = shortnerGateway;
    }

    public Shortner shortenURL(String longUrl) {
        return shortnerGateway.save(new Shortner(generateKey(), longUrl));
    }

    public Shortner getLongURL(String shorten) {
        return shortnerGateway.findByShorten(shorten);
    }
    private String generateKey() {
        StringBuilder key = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            key.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return key.toString();
    }
}
