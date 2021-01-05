import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from './clientes/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(
    private http : HttpClient
  ) { }

  getCliente(clienteCadastro:Cliente) : Cliente {
    let cliente : Cliente = clienteCadastro;
    return cliente;
  }
}
