import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InstructorsComponent } from './instructors/instructors.component';
import { ScheduleComponent } from './schedule/schedule.component';

const routes: Routes = [
  { path: 'instructors', component: InstructorsComponent },
  { path: 'schedule', component: ScheduleComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
