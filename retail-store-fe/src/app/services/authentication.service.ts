import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable()
export class AuthenticationService {

    api: string = environment.API_ENDPOINT_PREFIX;
    entity: string = `${this.api}login`;

    constructor(private http: HttpClient) {

    }

    doLogin(loginDetails: any) {
        return this.http.post(this.entity, loginDetails);
    }
}