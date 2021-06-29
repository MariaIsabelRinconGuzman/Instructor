import { Component, Inject, OnInit } from '@angular/core';
import { Instructor } from '../service/instructor';
import { Services } from '../service/services';

@Component({
  selector: 'app-instructors',
  templateUrl: './instructors.component.html',
  styleUrls: ['./instructors.component.css']
})
export class InstructorsComponent implements OnInit {
  instructors: Instructor[]= [];

  selectedInstructor?: Instructor;

  constructor(private services: Services, @Inject('baseURL') private baseURL: string) { }

  ngOnInit(): void {
    this.getInstructors();    
  }

  onSelect(instructor: Instructor): void {
    this.selectedInstructor = instructor;
  }

  getInstructors(): void{
    this.services.getInstructors().subscribe(instructors => this.instructors = instructors);
  }

}
