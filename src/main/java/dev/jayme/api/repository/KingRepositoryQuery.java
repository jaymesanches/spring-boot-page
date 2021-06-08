package dev.jayme.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.jayme.api.model.King;

public interface KingRepositoryQuery {
	Page<King> findByCriteria(Pageable pageable);
}
