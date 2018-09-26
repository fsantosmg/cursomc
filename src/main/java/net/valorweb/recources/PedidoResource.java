package net.valorweb.recources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.valorweb.domain.Pedido;
import net.valorweb.services.PedidoService;

@RestController
@RequestMapping(value = "pedidos")
public class PedidoResource {

	@Autowired
	PedidoService service;
	
	

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findPorId(@PathVariable Integer id) {

		return ResponseEntity.ok().body(service.findById(id));

	}
	
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido pedido) {

		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(service.insert(pedido).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
