package com.notreveio.clientscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notreveio.clientscatalog.dto.ClientsDTO;
import com.notreveio.clientscatalog.entities.Clients;
import com.notreveio.clientscatalog.repositories.ClientsRepository;

@Service
public class ClientsService {
	
	@Autowired
	private ClientsRepository repository;

	@Transactional(readOnly = true)
	public List<ClientsDTO> findAll(){
		List<Clients> list = repository.findAll();

		return list.stream().map(x -> new ClientsDTO(x)).collect(Collectors.toList());
	}

}
