package com.notreveio.clientscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notreveio.clientscatalog.entities.Clients;
import com.notreveio.clientscatalog.services.ClientsService;

@RestController
@RequestMapping(value = "/clients")
public class ClientsResource {
	
	@Autowired
	private ClientsService service;

	@GetMapping
	public ResponseEntity<List<Clients>> findAll(){
		List<Clients> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	

}
