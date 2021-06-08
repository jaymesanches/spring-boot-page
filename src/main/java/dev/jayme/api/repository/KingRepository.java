package dev.jayme.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import dev.jayme.api.model.King;

public interface KingRepository extends CrudRepository<King, Long>, KingRepositoryQuery {
	Page<King> findAll(Pageable pagination);
}
