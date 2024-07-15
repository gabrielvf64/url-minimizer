package com.gabrielvicente.url_minimizer.repository;

import com.gabrielvicente.url_minimizer.entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlMinimizerRepository extends MongoRepository<Url, String> {
}
