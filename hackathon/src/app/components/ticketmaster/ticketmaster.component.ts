import { Component, OnInit } from '@angular/core';
import { EventService } from 'app/event-service.service';

@Component({
  selector: 'app-ticketmaster',
  templateUrl: './ticketmaster.component.html',
  styleUrls: ['./ticketmaster.component.css']
})
export class TicketmasterComponent implements OnInit {

  events?: any;

  constructor(private event: EventService) { }



  ngOnInit(): void {
     this.event.getEvent('New York').subscribe(res=> {
       console.log(res);
       this.events = res._embedded.events;
     })
  }

}
