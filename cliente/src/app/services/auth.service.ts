import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environments";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
  }

  URL = environment.URL_SERVER + '/auth/'

  register(data: any) {
    return this.http.post(this.URL + 'register', data)
  }

  login(data: any) {
    return this.http.post(this.URL + 'login', data, {observe: 'response'})
  }

}
