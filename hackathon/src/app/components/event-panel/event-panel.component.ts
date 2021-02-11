import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-panel',
  templateUrl: './event-panel.component.html',
  styleUrls: ['./event-panel.component.css']
})
export class EventPanelComponent implements OnInit {


  @Input()
  event: any;
  eventName: any;
  eventUrl: any;
  eventImage: any;
  eventDate: any;
  eventPrice: any;
  splitDate: any;

  constructor() { }

  ngOnInit(): void {
    this.eventName =  this.event.name;
    this.eventUrl = this.event.url;
    this.eventImage = this.event.images[0].url;
    this.splitDate = this.event.dates.start.localDate.split("-");
    this.eventDate = this.splitDate[1] +"/" + this.splitDate[2] + "/" +this.splitDate[0];
    console.log(this.eventDate);
    
    this.eventPrice = ((parseInt(this.event.priceRanges[0].min) + parseInt(this.event.priceRanges[0].max)) / 2).toFixed(2);


  }


}
