import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Instructor } from "./instructor";
import { baseURL } from "./baseurl";
import { Events } from "./event";

@Injectable()
export class Services{

  constructor(protected http: HttpClient) { }

    getInstructors(): Observable<Instructor[]> {
        return this.http.get<Instructor[]>(baseURL + "instructor");
    }

    getSchedule(id : number): Observable<Events[]> {
      return this.http.get<Events[]>(baseURL + "schedule/" + id);
    }

    createEvent(body: any): Observable<any> {
      return this.http.post(baseURL + "event", body);
    }

    editEvent(body: any): Observable<any> {
      return this.http.put(baseURL + "event", body);
    }

    deleteEvent(body: any): Observable<any> {
      return this.http.delete(baseURL + "event", body);
    }
}