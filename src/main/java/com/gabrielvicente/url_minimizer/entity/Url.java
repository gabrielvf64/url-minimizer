package com.gabrielvicente.url_minimizer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Url {

    @Id
    private String id;

    private String originalUrl;

    @Indexed(expireAfterSeconds = 0)
    private LocalDateTime expiresAt;

    public Url() {
    }

    public Url(String id, String originalUrl, LocalDateTime expiresAt) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.expiresAt = expiresAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
