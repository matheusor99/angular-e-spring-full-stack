package com.matheusor99.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusor99.clientes.model.entitys.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
