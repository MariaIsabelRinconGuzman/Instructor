import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { FullCalendarModule } from '@fullcalendar/angular';
import { NgbCarouselModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InstructorsComponent } from './instructors/instructors.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { baseURL } from './service/baseurl';
import { Services } from './service/services';

FullCalendarModule.registerPlugins([ 
]);

@NgModule({
  declarations: [
    AppComponent,
    InstructorsComponent,
    ScheduleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FullCalendarModule,
    NgbModule,
    NgbCarouselModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [Services, {provide: 'baseURL', useValue: baseURL}],
  bootstrap: [AppComponent]
})
export class AppModule { }
