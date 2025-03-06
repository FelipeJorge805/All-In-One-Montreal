import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Event from './event';

@Injectable({
  providedIn: 'root'
})
export default class EventService {

  private eventsUrl: string

  constructor(private http: HttpClient) {
    this.eventsUrl = 'http://localhost:8080/events';
   }

  public findAll(): Observable<Event[]> {
    return this.http.get<Event[]>(this.eventsUrl);
  }

  public save(event: Event) {
    //let obj = Object.fromEntries(Object.entries(event));
    return this.http.post<Event>('http://localhost:8080/submitEvent', event).subscribe({
      next: response => console.log(response), 
      error: err => console.log(err)
    });
  }
}
