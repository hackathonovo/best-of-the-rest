import {Component, OnInit} from "@angular/core";
import {User} from "../shared/models/user.model";
import {UserService} from "../shared/services/user.service";
import {AlertService} from "../shared/services/alert.service";
import {UserDto} from "./user-dto.model";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {SpecialityDto} from "./speciality.model";
import {Speciality} from "../shared/models/speciality.model";
import {SpecialityService} from "../shared/services/speciality.service";

@Component({
  selector: 'app-user-new',
  templateUrl: './user-new.component.html',
  styleUrls: ['./user-new.component.css']
})
export class UserNewComponent implements OnInit {

  homeLocLat: number;
  homeLocLng: number;
  workLocLat: number;
  workLocLng: number;

  editMode = false;
  id: number;

  model = new User();

  idSpec: number;
  spec: string;
  specLevel: number;
  specialities: SpecialityDto[] = [];
  allSpecialities: Speciality[] = [];

  constructor(private route: ActivatedRoute,
              private userService: UserService,
              private alertService: AlertService,
              private specialityService: SpecialityService,
              private router: Router) {
  }

  ngOnInit() {
    this.route.params
      .subscribe(
        (params: Params) => {
          this.id = +params['id'];
          this.editMode = params['id'] != null;
          if (this.editMode) {
            this.initForm(this.id);
            this.specialityService.getUserSpecialities(this.id)
              .subscribe(res => this.specialities = <SpecialityDto[]>res.json());
          }
        }
      );
    this.specialityService.getAllSpecialities()
      .subscribe(allSpec => this.allSpecialities = allSpec);
  }

  initForm(id: number) {
    this.userService.getUser(id)
      .subscribe(user => {
        this.model.firstName = user.firstName;
        this.model.lastName = user.lastName;
        this.model.contact = user.contact;
        this.model.email = user.email;
        this.model.category = user.category;
        this.model.availableFrom = user.availableFrom;
        this.model.availableTo = user.availableTo;
        this.homeLocLat = user.homeLocationX;
        this.homeLocLng = user.homeLocationY;
        this.workLocLat = user.workLocationX;
        this.workLocLng = user.workLocationY;
      });
  }

  onHomeMapClick(event: any) {
    this.homeLocLat = event.coords.lat;
    this.homeLocLng = event.coords.lng;
  }

  onWorkMapClick(event: any) {
    this.workLocLat = event.coords.lat;
    this.workLocLng = event.coords.lng;
  }

  onAddSpeciality() {
    const specDto: SpecialityDto = new SpecialityDto();
    specDto.id = this.idSpec;
    specDto.level = this.specLevel;
    this.specialities.push(specDto);
  }

  onClear() {
    this.specialities = [];
    this.idSpec = null;
    this.specLevel = null;
  }

  getSpeciality(id: number) {
    for (const s of this.allSpecialities) {
      if (s.id == id) {
        return s.name;
      }
    }
    return null;
  }

  onSubmit() {
    const userDto = new UserDto();

    const user: User = new User();
    user.firstName = this.model.firstName;
    user.lastName = this.model.lastName;
    user.contact = this.model.contact;
    user.email = this.model.email;
    user.category = this.model.category;
    user.availableFrom = new Date();
    user.availableTo = new Date;
    user.homeLocationX = this.homeLocLat;
    user.homeLocationY = this.homeLocLng;
    user.workLocationX = this.workLocLat;
    user.workLocationY = this.workLocLng;

    userDto.user = user;
    userDto.specialities = this.specialities;

    console.log(JSON.stringify(user));
    if (this.editMode) {
      this.userService.updateUser(this.id, userDto)
        .subscribe(res => {
          res.status === 200 ? this.alertService.success(res.statusText) : this.alertService.error(res.statusText);
          this.router.navigate(['/admin', 'users']);
        });
    } else {
      this.userService.createUser(userDto)
        .subscribe(res => {
          res.status === 200 ? this.alertService.success(res.statusText) : this.alertService.error(res.statusText);
          this.router.navigate(['/admin', 'users']);
        });
    }
  }

}
