import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from './clientes/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  url: string = "http://localhost:8080/api/clientes"

  constructor(
    private http : HttpClient
  ) { }

  salvar(cliente:Cliente) : Observable<Cliente> {
    return this.http.post<Cliente>(this.url, cliente);
  }
}
