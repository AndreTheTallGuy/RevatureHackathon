import { Component, Input, OnInit } from '@angular/core';
import { ItineraryService } from 'app/itinerary.service';
import { Event } from '../../event';

@Component({
  selector: 'app-event-panel',
  templateUrl: './event-panel.component.html',
  styleUrls: ['./event-panel.component.css']
})
export class EventPanelComponent implements OnInit {


  @Input()
  event: any;
  eventName: any;
  eventAddress: any;
  eventUrl: any;
  eventImage: any;
  eventDate: any;
  eventPrice: any;
  splitDate: any;
  targetEvent: Event;

  constructor(private itinerary: ItineraryService) { }

  ngOnInit(): void {
    this.eventName =  this.event.name;
    this.eventUrl = this.event.url;
    this.eventImage = this.event.images[0].url;
    this.splitDate = this.event.dates.start.localDate.split("-");
    this.eventDate = this.splitDate[1] +"/" + this.splitDate[2] + "/" +this.splitDate[0];
    console.log(this.eventDate);
    this.eventAddress = this.event._embedded.venues[0].address.line1;
    console.log(this.eventAddress, "address");
    
    this.eventPrice = ((parseInt(this.event.priceRanges[0].min) + parseInt(this.event.priceRanges[0].max)) / 2).toFixed(2);


    this.targetEvent = { 
      eventTitle: this.eventName,
      eventAddress: this.eventAddress,
      eventDate: this.eventDate
    }
  }


  onSubmit(){
    console.log(this.targetEvent);
    
    this.itinerary.events.push(this.targetEvent)
  }

}
