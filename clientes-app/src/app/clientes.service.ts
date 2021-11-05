import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from './clientes/cliente';
import { environment } from '../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  url: string = environment.apiURL + "/api/clientes"

  constructor(
    private http : HttpClient
  ) { }

  salvar(cliente:Cliente) : Observable<Cliente> {
    return this.http.post<Cliente>(this.url, cliente);
  }

  getCLientes() : Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.url);   
  }

  getClienteById(id: number) : Observable<Cliente> {
    return this.http.get<any>(this.url + "/" + id);
  }

  atualizar(cliente: Cliente) : Observable<any> {
    return this.http.put<Cliente>(this.url+"/"+cliente.id, cliente);
  }

  deletar(id: number) : Observable<any> {
    return this.http.delete<any>(this.url + '/' + id)
  }
}
