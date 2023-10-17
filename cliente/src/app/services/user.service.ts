import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/User";
import {environment} from "../../environments/environments";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  getUserById(id: number) {
    if (environment.servidorEncendido)
      return this.http.get<User>(environment.URL_SERVER + '/user/' + id)
    else
      return null
  }

  getAllUsers() {
    if (environment.servidorEncendido)
      return this.http.get<[User]>(environment.URL_SERVER + '/user/' + 'all')
    else
      return null
  }
}
