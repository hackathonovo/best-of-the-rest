import {Component, Input, OnInit} from "@angular/core";
import {User} from "../shared/models/user.model";
import {SpecialityService} from "../shared/services/speciality.service";
import {Speciality} from "../shared/models/speciality.model";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  @Input() usr: User;
  viewMode = false;

  specialities: Speciality[];

  constructor(private specialityService: SpecialityService) { }

  ngOnInit() {
    this.specialityService.getUserSpecialities(this.usr.id)
      .subscribe(res => this.specialities = <Speciality[]>res.json());
  }

  changeViewMode() {
    this.viewMode = !this.viewMode;
  }

}
