package com.notreveio.clientscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notreveio.clientscatalog.entities.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long>{

}
