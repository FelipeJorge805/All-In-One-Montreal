import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private eventsUrl: string

  constructor(private http: HttpClient) {
    this.eventsUrl = 'http://localhost:8080/events';
   }

  public findAll(): Observable<Event[]> {
    return this.http.get<Event[]>(this.eventsUrl);
  }
}
