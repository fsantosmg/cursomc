package net.valorweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import net.valorweb.domain.Cliente;
import net.valorweb.dto.ClienteDTO;
import net.valorweb.repositories.ClienteRepository;
import net.valorweb.services.exception.DataIntegrityException;
import net.valorweb.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente findById(Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {

		return repository.findAll();
	}

	public Cliente find(Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente insert(Cliente cliente) {

		cliente.setId(null);
		return repository.save(cliente);
	}

	public Cliente update(Cliente cliente) {

		Cliente clienteDb =  find(cliente.getId());
		updateData(cliente, clienteDb);

		return repository.save(clienteDb);
	}

	private void updateData(Cliente cliente, Cliente clienteDb) {
		clienteDb.setEmail(cliente.getEmail());
		clienteDb.setNome(cliente.getNome());
	}

	public void delete(Integer id) {

		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um cliente que possui pedidos!");
		}
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		return repository.findAll(PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy));

	}

	public Cliente fromDTO(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getNome(), clienteDTO.getEmail(),null, null);
	}
	
	public ClienteDTO fromCliente (ClienteDTO dto) {
		return dto;
		
	}

}
