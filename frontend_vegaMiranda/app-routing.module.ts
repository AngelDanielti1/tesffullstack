import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonListComponent } from './person-list/person-list.component';
import { PersonEditComponent } from './person-edit/person-edit.component';

const routes: Routes = [
  { path: 'persons', component: PersonListComponent },
  { path: 'edit-person/:id', component: PersonEditComponent },
  { path: 'edit-person', component: PersonEditComponent },
  { path: '', redirectTo: '/persons', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
