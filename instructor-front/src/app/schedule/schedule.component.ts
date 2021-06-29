import { Component, Inject, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { FullCalendarComponent, CalendarOptions } from '@fullcalendar/angular';
import { Events } from '../service/event';
import { Instructor } from '../service/instructor';
import { Services } from '../service/services';
import Swal from 'sweetalert2';
import { FormControl, FormGroup } from '@angular/forms';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit, OnChanges {

  @Input() instructorD: Instructor | undefined;

  @ViewChild('calendar')
  calendarComponent!: FullCalendarComponent;

  events: Events[] = [];
  form!: FormGroup;
  selectedEvent?: Events;

  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth',
    weekends: false, // initial value
    //dateClick: this.handleDateClick.bind(this), // bind is important!

  };

  constructor(config: NgbModalConfig, private modalService: NgbModal,
    private services: Services, @Inject('baseURL') private baseURL: string) { }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.instructorD != undefined) {
      this.getSchedule(this.instructorD.idInstructor);
    }
  }

  ngOnInit(): void {
    this.formulario();
    if (this.instructorD != undefined) {
      this.getSchedule(this.instructorD.idInstructor);
    }
  }

  public formulario() {
    this.form = new FormGroup({
      type: new FormControl(''),
      description: new FormControl(''),
      start: new FormControl(''),
      end: new FormControl('')
    });
  }

  getSchedule(id: number) {
    this.services.getSchedule(id).subscribe(events => this.events = events);
    console.log(this.events);
  }

  onSelect(event: Events): void {
    this.selectedEvent = event;
  }

  public open(content: any): void {
    this.modalService.open(content);
  }

  createEvent() {
    if (this.instructorD != undefined) {
      const body: Events = {
        type: this.form.value.type,
        description: this.form.value.description,
        start: this.form.value.start,
        end: this.form.value.end,
        instructor: this.instructorD
      }
      this.services.createEvent(body).subscribe((responses: any) => {
        console.log(responses);
        Swal.fire({
          title: 'The event was inserted correctly',
          position: 'center',
          icon: 'success',
          showConfirmButton: true,
        });
      }, (error: { error: { message: any; }; }) => Swal.fire({
        title: error.error.message,
        position: 'center',
        icon: 'error',
        showConfirmButton: true,
      }));
    }
  }

  editEvent() {
    if (this.instructorD != undefined) {
      const body: Events = {
        idEvent: this.selectedEvent?.idEvent,
        type: this.form.value.type,
        description: this.form.value.description,
        start: this.form.value.start,
        end: this.form.value.end,
        instructor: this.instructorD
      }
      this.services.editEvent(body).subscribe((responses: any) => {
        console.log(responses);
        Swal.fire({
          title: 'The event was updated correctly',
          position: 'center',
          icon: 'success',
          showConfirmButton: true,
        });
      }, (error: { error: { message: any; }; }) => Swal.fire({
        title: error.error.message,
        position: 'center',
        icon: 'error',
        showConfirmButton: true,
      }));
    }
  }

  deleteEvent() {
    if (this.instructorD != undefined && this.selectedEvent != undefined) {
      const body: Events = {
        idEvent: this.selectedEvent?.idEvent,
        type: this.selectedEvent?.type,
        description: this.selectedEvent?.description,
        start: this.selectedEvent?.start,
        end: this.selectedEvent?.end,
        instructor: this.instructorD
      }
      this.services.deleteEvent(body).subscribe((responses: any) => {
        console.log(responses);
        Swal.fire({
          title: 'The event was deleted correctly',
          position: 'center',
          icon: 'success',
          showConfirmButton: true,
        });
      }, (error: { error: { message: any; }; }) => Swal.fire({
        title: error.error.message,
        position: 'center',
        icon: 'error',
        showConfirmButton: true,
      }));
    }
  }
}
