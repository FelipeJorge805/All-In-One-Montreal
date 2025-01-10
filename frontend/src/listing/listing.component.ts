import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-list',
  imports: [CommonModule],
  templateUrl: './listing.component.html',
  styleUrls: ['./listing.component.css']
})
export class ListingComponent implements OnInit {
  category!: string;
  validCategories = ['parties', 'sports', 'events', 'festivals'];
  events: any;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    const category = this.route.snapshot.paramMap.get('category')!;
  
    if (!this.validCategories.includes(category)) {
      console.log('Invalid category:', category);
      //this.router.navigate(['/']); // Redirect to the home page or an error page
      return;
    }
  
    this.category = category;
    console.log('Valid category:', this.category);
    this.fetchData(this.category);
  }
  
  fetchData(category: string): void {
    console.log(`Fetching data for ${category}`);

    //initialize a dummy event with title,description,location and date, and fake image url
    this.events = [
      {
        title: 'Event 1',
        description: 'Description 1',
        location: 'Location 1',
        date: '2021-07-01',
        image: 'https://via.placeholder.com/150',
        url: 'https://www.google.com'
      },
      {
        title: 'Event 2',
        description: 'Description 2',
        location: 'Location 2',
        date: '2021-07-02',
        image: 'https://via.placeholder.com/150',
        url: 'https://www.google.com'
      },
      {
        title: 'Event 3',
        description: 'Description 3',
        location: 'Location 3',
        date: '2021-07-03',
        image: 'https://via.placeholder.com/150',
        url: 'https://www.google.com'
      }
    ];
  }
}
