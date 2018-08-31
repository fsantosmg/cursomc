package net.valorweb.recources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.valorweb.domain.Categoria;
import net.valorweb.services.CategoriaService;

@RestController
@RequestMapping(value="categorias")
public class CategoriaResource {
	
	@Autowired
	CategoriaService service;

	@GetMapping
	public List<Categoria> listar(){
	
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(service.buscar(id));
		
	}
	
}
