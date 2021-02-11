import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TicketmasterComponent } from './components/ticketmaster/ticketmaster.component';
import { EventService } from './event-service.service';
import { HttpClientModule } from '@angular/common/http';
import { EventPanelComponent } from './components/event-panel/event-panel.component';
import { ItineraryService } from './itinerary.service';


@NgModule({
  declarations: [
    AppComponent,
    TicketmasterComponent,
    EventPanelComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [EventService, ItineraryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
