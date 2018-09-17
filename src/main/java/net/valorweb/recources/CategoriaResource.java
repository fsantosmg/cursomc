package net.valorweb.recources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.valorweb.domain.Categoria;
import net.valorweb.dto.CategoriaDTO;
import net.valorweb.services.CategoriaService;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaResource {

	@Autowired
	CategoriaService service;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> listAll() {

		List<Categoria> list = service.findAll();

		List<CategoriaDTO> listDto = list.stream().map(categoria -> new CategoriaDTO(categoria))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {

		return ResponseEntity.ok().body(service.find(id));

	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Categoria categoria) {

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(service.insert(categoria).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Integer id) {

		categoria.setId(id);

		categoria = service.update(categoria);

		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);

		return ResponseEntity.noContent().build();

	}

}
