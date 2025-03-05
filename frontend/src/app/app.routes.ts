import { Routes } from '@angular/router';
import HomeComponent from '../home/home.component';
import ListingComponent from '../listing/listing.component';
import SubmitFormComponent from './submit-form/submit-form.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'submit', component: SubmitFormComponent },
    { path: ':category', component: ListingComponent },
    { path: '**', redirectTo: '' }
];
