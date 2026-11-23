import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router'
import { LivroService } from '../../core/services/livro.service'
import { Observable, of } from 'rxjs'
import type { Livro } from '../../core/models/livro';
import { MatCard, MatCardContent, MatCardHeader } from '@angular/material/card';
import { AsyncPipe } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-livro-detalhes',
  imports: [MatCard, MatCardContent, MatCardHeader, AsyncPipe, MatButtonModule],
  templateUrl: './livro-detalhes.html',
  styleUrl: './livro-detalhes.css',
})
export class LivroDetalhes implements OnInit {
  livro: Observable<Livro> = of();
  private livroService = inject(LivroService)
  private route = inject(ActivatedRoute)

  ngOnInit()
  {
    const idLivro = this.route.snapshot.params['id']
    this.livro = this.livroService.buscarPorId(idLivro);
  }

  emprestar()
  {
    const idLivro = this.route.snapshot.params['id']
    this.livro = this.livroService.emprestar(idLivro)
  }

  devolver()
  {
    const idLivro = this.route.snapshot.params['id']
    this.livro = this.livroService.devolver(idLivro)
  }


}
