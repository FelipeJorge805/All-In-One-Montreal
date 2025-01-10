import { Routes } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { ListingComponent } from '../listing/listing.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: ':category', component: ListingComponent },
    { path: '**', redirectTo: '' }
];
