import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItineraryService {

  events: any[] = [];

  constructor(private http: HttpClient) { }



  public saveItinerary(): Observable<any>{
   let requestHeaders = new HttpHeaders({'Content-Type': 'application/json'});
    let body = {
      "uID": 1,
      "title": "My Itinerary",
      "events": this.events,
   
    }
    return this.http.post(`http://localhost:9001/itinerary/save`, body, {headers: requestHeaders })
  }
  


}
