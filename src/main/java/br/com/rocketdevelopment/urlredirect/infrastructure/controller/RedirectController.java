package br.com.rocketdevelopment.urlredirect.infrastructure.controller;

import br.com.rocketdevelopment.urlredirect.domain.usecases.URLShortener;
import br.com.rocketdevelopment.urlredirect.domain.entity.Shortner;

import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@Validated
@Log
public class RedirectController {
    private final URLShortener urlShortener;

    public RedirectController(URLShortener urlShortener) {
        this.urlShortener = urlShortener;
    }

    @GetMapping("/{urlcode}")
    public ResponseEntity<Void> redirect(@PathVariable String urlcode) {
        log.info("GET: Request Redirecting to " + urlcode);
        Shortner longURL = urlShortener.getLongURL(urlcode);
        log.info("GET: Response Redirecting to " + longURL.url());
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longURL.url())).build();
    }

    @PostMapping("/")
    public ResponseEntity<UrlResponse> create(@RequestBody @Valid UrlRequest uriRequest) {
        log.info("POST: Request Shortening URL " + uriRequest.url());
        Shortner shortner = urlShortener.shortenURL(uriRequest.url());
        log.info("POST: Response Shortening URL " + shortner.shorten());
        return ResponseEntity.status(HttpStatus.CREATED).body(new UrlResponse(shortner.shorten()));
    }
}
