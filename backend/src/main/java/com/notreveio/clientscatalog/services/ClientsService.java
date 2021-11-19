package com.notreveio.clientscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notreveio.clientscatalog.dto.ClientsDTO;
import com.notreveio.clientscatalog.entities.Clients;
import com.notreveio.clientscatalog.repositories.ClientsRepository;
import com.notreveio.clientscatalog.services.exceptions.ResourceNotFoundExeception;

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
		Clients entity = obj.orElseThrow(() -> new ResourceNotFoundExeception("Entity Not Found"));
		return new ClientsDTO(entity);
	}

	@Transactional
	public ClientsDTO insert(ClientsDTO dto) {
		Clients entity = new Clients();
		copyDtoEntity(dto, entity);
		entity = repository.save(entity);

		return new ClientsDTO(entity);
	}

	@Transactional
	public ClientsDTO update(Long id, ClientsDTO dto) {
		try {
			Clients entity = repository.getOne(id);
			copyDtoEntity(dto, entity);
			entity = repository.save(entity);
			return new ClientsDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExeception("Id Not Found" + id);
		}
	}
	
	private void copyDtoEntity(ClientsDTO dto, Clients entity) {
		
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChrildren(dto.getChrildren());
		
	}

}
