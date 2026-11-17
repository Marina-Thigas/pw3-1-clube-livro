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
}
