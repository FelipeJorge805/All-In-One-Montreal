import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { EventService } from '../app/event-service.service';
import { Event } from '../app/event';

@Component({
  selector: 'app-list',
  imports: [CommonModule],
  templateUrl: './listing.component.html',
  styleUrls: ['./listing.component.css']
})
export class ListingComponent implements OnInit {
  category!: string;
  validCategories = ['parties', 'sports', 'events', 'festivals'];
  events: Event[] = [];

  constructor(private route: ActivatedRoute, private eventService: EventService) {}

  ngOnInit() {
    const category = this.route.snapshot.paramMap.get('category')!;
  
    if (!this.validCategories.includes(category)) {
      console.log('Invalid category:', category);
      //this.router.navigate(['/']); // Redirect to the home page or an error page
      return;
    }
  
    this.category = category;
    console.log('Valid category:', this.category);
    
    this.eventService.findAll().subscribe(data => {
      this.events = data;
    });
  }
  
}
