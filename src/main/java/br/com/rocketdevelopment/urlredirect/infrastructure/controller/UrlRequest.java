package br.com.rocketdevelopment.urlredirect.infrastructure.controller;

import org.hibernate.validator.constraints.URL;

public record UrlRequest(@URL(message = "Invalid URL")  String url) {
}
