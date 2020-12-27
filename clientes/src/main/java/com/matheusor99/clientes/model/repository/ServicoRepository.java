package com.matheusor99.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusor99.clientes.model.entitys.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer>{
	
}
