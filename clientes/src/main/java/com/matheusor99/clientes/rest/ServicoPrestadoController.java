package com.matheusor99.clientes.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.matheusor99.clientes.model.entitys.Cliente;
import com.matheusor99.clientes.model.entitys.ServicoPrestado;
import com.matheusor99.clientes.model.repository.ClienteRepository;
import com.matheusor99.clientes.model.repository.ServicoPrestadoRepository;
import com.matheusor99.clientes.rest.dto.ServicoPrestadoDTO;
import com.matheusor99.clientes.util.BigDecimalConverter;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {
	
	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository servicoPrestadoRepository;
	private final BigDecimalConverter bigDecimalConverter;
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Cliente cliente = clienteRepository
				.findById(dto.getIdCliente())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente."));
				
		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setData(data);
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor( bigDecimalConverter.converter(dto.getValor()) );
		
		return servicoPrestadoRepository.save(servicoPrestado);
	}
	
	@GetMapping
	public List<ServicoPrestado> pesquisar(
			@RequestParam(value="nome", required = false, defaultValue = "") String nome,
			@RequestParam(value="mes", required = false) Integer mes
	) {
		return servicoPrestadoRepository.findByNomeClienteAndMes("%" + nome + "%", mes);
	}
}
