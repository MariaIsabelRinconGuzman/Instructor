import { Instructor } from "./instructor";

export interface Events {
    idEvent?: number;
	type: string;
	description: string;
	start: Date;
    end: Date;
    durationDays?: number;
    instructor: Instructor;
}