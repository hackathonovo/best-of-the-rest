import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {API_BASE} from "../app.constants";
import {Speciality} from "../models/speciality.model";
import {Subject} from "rxjs/Subject";

@Injectable()
export class SpecialityService {

  specialitiesUpdate = new Subject<Speciality[]>();

  constructor(private http: Http) {
  }

  getAllSpecialities() {
    return this.http.get(API_BASE + '/specialities')
      .map(res => <Speciality[]>res.json());
  }

  getUserSpecialities(userId: number) {
    return this.http.get(API_BASE + '/users/' + userId + '/specialities');
  }

  createSpeciality(spec: Speciality) {
    this.http.post(API_BASE + '/specialities', spec)
      .subscribe(res => {
        if (res.status === 200) {
          this.getAllSpecialities()
            .subscribe(resp => this.specialitiesUpdate.next(resp));
        }
      });
  }

  deleteSpeciality(specId: number) {
    this.http.delete(API_BASE + '/specialities/' + specId)
      .subscribe(res => {
        if (res.status === 200) {
          this.getAllSpecialities()
            .subscribe(resp => this.specialitiesUpdate.next(resp));
        }
      });
  }
}
