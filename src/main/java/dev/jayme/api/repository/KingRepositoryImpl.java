package dev.jayme.api.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import dev.jayme.api.model.King;

public class KingRepositoryImpl implements KingRepositoryQuery {
	
	private EntityManager em;
	
	@Autowired
	public KingRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Page<King> findByCriteria(Pageable pageable) {
		var builder = em.getCriteriaBuilder();
		var query = builder.createQuery(King.class);
		query.from(King.class);
		var typedQuery = em.createQuery(query);
		typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		typedQuery.setMaxResults(pageable.getPageSize());
		var result = typedQuery.getResultList();
		return new PageImpl<King>(result, pageable, countKings());
	}

	private Long countKings() {
		var queryTotal = em.createQuery("select count(*) from King").getSingleResult();
		return (Long)queryTotal;
	}

}
