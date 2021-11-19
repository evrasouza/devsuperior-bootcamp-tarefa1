package com.notreveio.clientscatalog.dto;

import java.io.Serializable;
import java.time.Instant;

import com.notreveio.clientscatalog.entities.Clients;

public class ClientsDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Instant birthDate;
	private Integer chrildren;
	
	public ClientsDTO() {
		
	}

	public ClientsDTO(Long id, String name, String cpf, Double income, Instant birthDate, Integer chrildren) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.chrildren = chrildren;
	}
	
	public ClientsDTO(Clients entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.birthDate = entity.getBirthDate();
		this.chrildren = entity.getChrildren();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChrildren() {
		return chrildren;
	}

	public void setChrildren(Integer chrildren) {
		this.chrildren = chrildren;
	}
	
	

}
