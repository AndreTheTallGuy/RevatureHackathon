import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TicketmasterComponent } from './components/ticketmaster/ticketmaster.component';

const routes: Routes = [
  {path: '', component: TicketmasterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
