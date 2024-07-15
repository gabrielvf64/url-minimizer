package com.gabrielvicente.url_minimizer.service;

import com.gabrielvicente.url_minimizer.repository.UrlMinimizerRepository;
import com.gabrielvicente.url_minimizer.request.MinimizeUrlRequest;
import com.gabrielvicente.url_minimizer.response.MinimizedUrlResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class UrlMinizerService {

    private final UrlMinimizerRepository repository;

    public UrlMinizerService(UrlMinimizerRepository repository) {
        this.repository = repository;
    }

    public MinimizedUrlResponse minimizeUrl(MinimizeUrlRequest request, HttpServletRequest servletRequest) {
        String id;

        do {
            id = generateId();
        } while (repository.existsById(id));

        repository.save(request.toEntity(id));

        String finalUrl = servletRequest.getRequestURL().toString().replace("shorten-url", id);

        return new MinimizedUrlResponse(finalUrl);
    }

    private String generateId() {
        return RandomStringUtils.randomAlphabetic(5, 10);
    }
}

