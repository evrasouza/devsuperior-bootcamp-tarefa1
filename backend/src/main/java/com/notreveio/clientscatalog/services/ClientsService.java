package com.notreveio.clientscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notreveio.clientscatalog.dto.ClientsDTO;
import com.notreveio.clientscatalog.entities.Clients;
import com.notreveio.clientscatalog.repositories.ClientsRepository;
import com.notreveio.clientscatalog.services.exceptions.EntityNotFoundExeception;

@Service
public class ClientsService {
	
	@Autowired
	private ClientsRepository repository;

	@Transactional(readOnly = true)
	public List<ClientsDTO> findAll(){
		List<Clients> list = repository.findAll();

		return list.stream().map(x -> new ClientsDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClientsDTO findById(Long id) {
		Optional<Clients> obj = repository.findById(id);
		Clients entity = obj.orElseThrow(() -> new EntityNotFoundExeception("Entity Not Found"));
		return new ClientsDTO(entity);
	}

}
