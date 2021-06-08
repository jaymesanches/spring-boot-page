package dev.jayme.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.jayme.api.model.King;
import dev.jayme.api.repository.KingRepository;

@RestController
@RequestMapping("/kings")
public class KingResource {

	private KingRepository repository;

	@Autowired
	public KingResource(KingRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public ResponseEntity<Page<King>> listKings(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "2") Integer size) {
		var pageable = PageRequest.of(page, size);
		var kings = this.repository.findAll(pageable);
		var kings2 = this.repository.findByCriteria(pageable);
		return ResponseEntity.ok(kings2);
	}
}
