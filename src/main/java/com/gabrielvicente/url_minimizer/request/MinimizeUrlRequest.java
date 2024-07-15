package com.gabrielvicente.url_minimizer.request;

import com.gabrielvicente.url_minimizer.entity.Url;

import java.time.LocalDateTime;

public record MinimizeUrlRequest(String url) {

    public Url toEntity(String id) {
        return new Url(id, url, LocalDateTime.now().plusMinutes(1));
    }
}
