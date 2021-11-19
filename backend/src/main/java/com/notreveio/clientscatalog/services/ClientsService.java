package com.notreveio.clientscatalog.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notreveio.clientscatalog.dto.ClientsDTO;
import com.notreveio.clientscatalog.entities.Clients;
import com.notreveio.clientscatalog.repositories.ClientsRepository;
import com.notreveio.clientscatalog.services.exceptions.DatabaseException;
import com.notreveio.clientscatalog.services.exceptions.ResourceNotFoundExeception;

@Service
public class ClientsService {
	
	@Autowired
	private ClientsRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientsDTO> findAllPaged(PageRequest pageRequest){
		Page<Clients> list = repository.findAll(pageRequest);

		return list.map(x -> new ClientsDTO(x));
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
	
	@Transactional
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e){
			throw new ResourceNotFoundExeception("Id Not Found" + id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}		
	}
	
	private void copyDtoEntity(ClientsDTO dto, Clients entity) {
		
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		
	}

}
