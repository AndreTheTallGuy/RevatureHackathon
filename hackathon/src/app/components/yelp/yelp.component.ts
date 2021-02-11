import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-yelp',
  templateUrl: './yelp.component.html',
  styleUrls: ['./yelp.component.css']
})
export class YelpComponent implements OnInit {


  resultList: any;
  httpOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin':'*',
      'Authorization':'Bearer 5kPEtTjBsrgZ1CpcC58mMa97k1c7r2QqJqz28zgrBkXBWyI2xZDYXQ6BmJQGks2LMduXbIU46fqogRRcvtvxxVDN3Zki0hgj5hCEbQC3wIbQ_yefcLayYnWojZclYHYx'
    })
  };

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  results() {
    this.searchYelp().subscribe(
      (data) => {console.log(data)}
    )
  }

  searchYelp(): Observable<any> {
    return this.http.get('https://api.yelp.com/v3/businesses/search?location=chicago', this.httpOptions);
  }

}