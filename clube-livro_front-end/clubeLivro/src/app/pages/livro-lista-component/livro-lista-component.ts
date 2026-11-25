import { Component, inject } from '@angular/core';
import { LivroService } from '../../core/services/livro.service';
import { Observable, of } from 'rxjs';
import { Livro } from '../../core/models/livro';
import { AsyncPipe } from '@angular/common';
import { MatCard, MatCardContent, MatCardHeader } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-livro-lista-component',
  imports: [AsyncPipe, MatCard, MatCardContent, MatCardHeader, MatButtonModule, RouterLink],
  templateUrl: './livro-lista-component.html',
  styleUrl: './livro-lista-component.css',
})
export class LivroListaComponent {
  private livroService = inject(LivroService)
  
  listaLivros: Observable<Livro[]> = of();


  ngOnInit(): void {
    this.listaLivros = this.livroService.listar()
  }

  deletar(id: Number)
  {
    this.livroService.deletar(id).subscribe(() => {
        this.listaLivros = this.livroService.listar();
    })
  }
}
