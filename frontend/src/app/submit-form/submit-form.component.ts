import { Component, Injectable } from '@angular/core';
import Event from '../event';
import EventService from '../event-service.service';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-submit-form',
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './submit-form.component.html',
  styleUrl: './submit-form.component.css'
})
@Injectable({providedIn: 'root'})
export default class SubmitFormComponent {
  public event: Event;
  public submitForm: FormGroup;
  
  constructor(private eventService: EventService, private formBuilder: FormBuilder) {
    this.event = new Event(0, '', '', '', new Date(), '', '');
    this.submitForm = this.formBuilder.group({
      title: '',
      description: '',
      location: '',
      date: '',
    });
   }

  ngOnInit(): void {
    // Initialization logic here
  }

  onSubmit(): void {
    // Submit logic here
    this.event = {sid:"0",...this.submitForm.value, image:'', url:'works'};
    this.eventService.save(this.event);
    console.log('Event submitted:', this.event);
    this.submitForm.reset();
  }
}
