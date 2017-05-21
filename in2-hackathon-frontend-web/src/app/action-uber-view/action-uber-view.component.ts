import {Component, OnInit} from "@angular/core";
import {ActionService} from "../shared/services/action.service";
import {ActivatedRoute} from "@angular/router";
import {ActionDetails} from "../shared/models/action-details.model";
import {User} from "../shared/models/user.model";
import {UserService} from "../shared/services/user.service";
import {Speciality} from "../shared/models/speciality.model";
import {SpecialityService} from "../shared/services/speciality.service";

@Component({
  selector: 'app-action-uber-view',
  templateUrl: './action-uber-view.component.html',
  styleUrls: ['./action-uber-view.component.css']
})
export class ActionUberViewComponent implements OnInit {

  id: number;
  actionDetails: ActionDetails = new ActionDetails();
  heading: string;

  loaded = false;
  users: User[] = [];
  allSpecialities: Speciality[] = [];

  category: string;
  level: number;
  speciality: string;

  constructor(
    private route: ActivatedRoute,
    private actionService: ActionService,
    private specialityService: SpecialityService,
    private userService: UserService) { }

  ngOnInit() {
    this.route.params
      .subscribe(
        params => {
          this.id = +params['id'];
          this.actionService.getActionDetails(this.id)
            .subscribe(ad => {
              this.actionDetails = ad;
              this.heading = this.actionDetails.action.heading;
              this.loaded = true;
            });
        }
      );
    this.specialityService.getAllSpecialities()
      .subscribe(spec => this.allSpecialities = spec);
    this.userService.getAllUsers()
      .subscribe(res => this.users = res);
    this.userService.filteringSubject
      .subscribe((usrs: User[]) => this.users = usrs);
  }

  onFilter() {
    this.userService.filterUser(this.category, this.speciality, this.level);
  }

  onClearFilter() {
    this.speciality = null;
    this.level = null;
    this.category = null;
  }

}
