import {Component, OnInit} from "@angular/core";
import {Action} from "../../shared/models/action.model";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {AlertService} from "../../shared/services/alert.service";
import {ActionService} from "../../shared/services/action.service";
import {SpecialityService} from "../../shared/services/speciality.service";
import {Speciality} from "../../shared/models/speciality.model";
import {User} from "../../shared/models/user.model";
import {UserService} from "../../shared/services/user.service";

@Component({
  selector: 'app-action-new',
  templateUrl: './action-new.component.html',
  styleUrls: ['./action-new.component.css']
})
export class ActionNewComponent implements OnInit {
  model: Action = new Action();
  isSearch: boolean = false;
  lat: number = 44.5376275;
  lng: number= 16.5904973;
  zoom: number = 7;

  editMode = false;
  id: number;

  category: string;
  level: number;
  speciality: string;

  allSpecialities: Speciality[] = [];

  users: User[] = [];

  constructor(
    private route: ActivatedRoute,
    private actionService: ActionService,
    private alertService: AlertService,
    private specialityService: SpecialityService,
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.model.urgency = "LOW";
    this.model.status = "";
    this.model.meetingTime = new Date();
    this.route.params
      .subscribe(
        (params: Params) => {
          this.id = +params['id'];
          this.editMode = params['id'] != null;
          if (this.editMode) {
            this.initForm(this.id);
          }
        }
      );
    this.specialityService.getAllSpecialities()
      .subscribe(spec => this.allSpecialities = spec);
    this.userService.getAllUsers()
      .subscribe(res => this.users = res);
    this.userService.filteringSubject
      .subscribe((usrs: User[]) => this.users = usrs);
  }

  initForm(id: number) {
    this.actionService.getAction(id)
      .subscribe(action => {
        this.model.heading = action.heading;
        this.model.description = action.description;
        this.model.actionType = action.actionType;
        this.model.baseLocationX = action.baseLocationX;
        this.model.baseLocationY = action.baseLocationY;
        this.model.actionLocationX = action.actionLocationX;
        this.model.actionLocationY = action.actionLocationY;
        this.model.status = action.status;
        this.model.meetingTime = action.meetingTime;
        this.model.urgency = action.urgency;
      });
  }

  onClick(event: any) {
    this.model.actionLocationX = event.coords.lat;
    this.model.actionLocationY = event.coords.lng;
  }

  onClickBase(event: any) {
    this.model.baseLocationX = event.coords.lat;
    this.model.baseLocationY = event.coords.lng;
  }

  onFilter() {
    this.userService.filterUser(this.category, this.speciality, this.level);
  }

  onClearFilter() {
    this.speciality = null;
    this.level = null;
    this.category = null;
  }

  onSubmit() {
    this.isSearch ? this.model.actionType = "SEARCH" : this.model.actionType = "RESCUE";
    this.model.status = 'PENDING';
    console.log(JSON.stringify(this.model));

    if (this.editMode) {
      this.actionService.updateAction(this.id, this.model)
        .subscribe(res => {
          res.status === 200 ? this.alertService.success(res.statusText) : this.alertService.error(res.statusText);
          this.router.navigate(['/actions']);
        });
    } else {
      this.actionService.createAction(this.model)
        .subscribe(res => {
          res.status === 200 ? this.alertService.success(res.statusText) : this.alertService.error(res.statusText);
          this.router.navigate(['/actions']);
        });
    }
  }
}
