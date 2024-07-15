package com.gabrielvicente.url_minimizer.controller;

import com.gabrielvicente.url_minimizer.request.MinimizeUrlRequest;
import com.gabrielvicente.url_minimizer.response.MinimizedUrlResponse;
import com.gabrielvicente.url_minimizer.service.UrlMinizerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlMinimizerController {

    private final UrlMinizerService service;

    public UrlMinimizerController(UrlMinizerService service) {
        this.service = service;
    }

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<MinimizedUrlResponse> minimizeUrl(@RequestBody MinimizeUrlRequest request, HttpServletRequest servletRequest) {
        MinimizedUrlResponse minimizedUrl = service.minimizeUrl(request, servletRequest);
        return ResponseEntity.ok(minimizedUrl);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String id) {
        return service.redirectToOriginalUrl(id);
    }
}
