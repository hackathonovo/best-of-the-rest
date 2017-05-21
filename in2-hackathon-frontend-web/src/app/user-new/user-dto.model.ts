import {User} from "../shared/models/user.model";
import {SpecialityDto} from "./speciality.model";

export class UserDto {
  user: User;
  specialities: SpecialityDto[];
}
