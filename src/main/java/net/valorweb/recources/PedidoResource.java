package net.valorweb.recources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
