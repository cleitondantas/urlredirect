package br.com.rocketdevelopment.urlredirect.domain.usecases;

import br.com.rocketdevelopment.urlredirect.domain.entity.Shortner;

public interface URLShortener {
    Shortner shortenURL(String url);
    Shortner getLongURL(String urlCode);
}
