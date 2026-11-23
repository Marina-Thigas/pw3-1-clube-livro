import { Routes } from '@angular/router';
import { LivroListaComponent } from './pages/livro-lista-component/livro-lista-component';
import { LivroDetalhes } from './pages/livro-detalhes/livro-detalhes'

export const routes: Routes = [
    {path: 'livros', component: LivroListaComponent},
    {path: 'livros/detalhes/:id', component: LivroDetalhes}
];
