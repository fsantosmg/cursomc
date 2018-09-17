package net.valorweb.recources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.valorweb.domain.Cliente;
import net.valorweb.services.ClienteService;

@RestController
@RequestMapping(value = "clientes")
public class ClienteResource {

	@Autowired
	ClienteService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> listAll() {

		return ResponseEntity.ok().body(service.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findPorId(@PathVariable Integer id) {

		return ResponseEntity.ok().body(service.findById(id));

	}

}
