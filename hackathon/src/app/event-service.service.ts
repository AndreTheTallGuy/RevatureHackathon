import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from 'environments/environment';
@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private http: HttpClient) { }

  public getEvent(city: string): Observable<any>{
    let regex = /\s/gi;
    let cityName = city.replace(regex, '%20')
    return this.http.get(`https://app.ticketmaster.com/discovery/v2/events.json?city=${cityName}&startDateTime=2021-11-02T14:00:00Z&sort=date,asc&apikey=${environment.apiKeys.tm}`);
  }


}
