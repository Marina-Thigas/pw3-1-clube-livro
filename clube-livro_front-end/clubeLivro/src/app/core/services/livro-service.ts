import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Livro } from '../models/livro';

@Injectable({
  providedIn: 'root',
})
export class LivroService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/livros';

  listar() : Observable<Livro[]>
  {
    return this.http.get<Livro[]>(`${this.apiUrl}`)
  }

  buscarPorId(id: Number) : Observable<Livro>
  {
    return this.http.get<Livro>(`${this.apiUrl}/${id}`)
  }

  cadastrar(livro: Livro): Observable<Livro>
  {
    return this.http.post<Livro>(`${this.apiUrl}`, livro)
  }

  atualizar(livro: Livro, id: Number): Observable<Livro>
  {
    return this.http.put<Livro>(`${this.apiUrl}/${id}`, livro)
  }

  deletar(id: Number): Observable<Livro>
  {
    return this.http.delete<Livro>(`${this.apiUrl}/${id}`)
  }

  emprestar(id: Number): Observable<Livro>
  {
    return this.http.post<Livro>(`${this.apiUrl}/${id}/emprestar`, null)
  }

  devolver(id: Number): Observable<Livro>
  {
    return this.http.post<Livro>(`${this.apiUrl}/${id}/devolver`, null)
  }
}
