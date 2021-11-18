package com.notreveio.clientscatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notreveio.clientscatalog.entities.Clients;
import com.notreveio.clientscatalog.repositories.ClientsRepository;

@Service
public class ClientsService {
	
	@Autowired
	private ClientsRepository repository;

	public List<Clients> findAll(){
		return repository.findAll();
	}

}
