import { Component, inject } from '@angular/core';
import { LivroService } from '../core/services/livro-service';
import { Observable, of } from 'rxjs';
import { Livro } from '../core/models/livro';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-livro-lista-component',
  imports: [AsyncPipe],
  templateUrl: './livro-lista-component.html',
  styleUrl: './livro-lista-component.css',
})
export class LivroListaComponent {
  private livroService = inject(LivroService)
  
  listaLivros: Observable<Livro[]> = of();


  ngOnInit(): void {
    this.listaLivros = this.livroService.listar()
  }
}
