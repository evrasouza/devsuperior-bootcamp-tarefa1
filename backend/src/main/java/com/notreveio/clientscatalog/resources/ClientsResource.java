package com.notreveio.clientscatalog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.notreveio.clientscatalog.dto.ClientsDTO;
import com.notreveio.clientscatalog.services.ClientsService;


@RestController
@RequestMapping(value = "/clients")
public class ClientsResource {
	
	@Autowired
	private ClientsService service;

	@GetMapping
	public ResponseEntity<List<ClientsDTO>> findAll(){
		List<ClientsDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientsDTO> findById(@PathVariable Long id){
		ClientsDTO dtoClients = service.findById(id);
		return ResponseEntity.ok().body(dtoClients);
	}
	
	@PostMapping
	public ResponseEntity<ClientsDTO> insert(@RequestBody ClientsDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	

}
