import {Component, OnInit} from "@angular/core";
import {SpecialityService} from "../shared/services/speciality.service";
import {Speciality} from "../shared/models/speciality.model";

@Component({
  selector: 'app-lookup-table',
  templateUrl: './lookup-table.component.html',
  styleUrls: ['./lookup-table.component.css']
})
export class LookupTableComponent implements OnInit {

  allSpecialities: Speciality[] = [];

  spec: Speciality = new Speciality();

  constructor(private specialityService: SpecialityService,
  ) { }

  ngOnInit() {
    this.specialityService.getAllSpecialities()
      .subscribe(allSpec => this.allSpecialities = allSpec);
    this.specialityService.specialitiesUpdate
      .subscribe(res => this.allSpecialities = res);
  }

  removeSpeciality(specId: number) {
    const confirmation = confirm('Jeste li sigurni da želite izbrisati specijalnost?');
    if (confirmation) {
      this.specialityService.deleteSpeciality(specId);
      this.spec = new Speciality();
    }
  }

  addSpeciality() {
    this.specialityService.createSpeciality(this.spec);
    this.spec = new Speciality();
  }

}
