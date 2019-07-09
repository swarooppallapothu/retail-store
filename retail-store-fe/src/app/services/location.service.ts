import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable()
export class LocationService {

    api: string = environment.api;
    entity: string = `${this.api}/location`;

    constructor(private http: HttpClient) {

    }

    getLocations(): Observable<any> {
        return this.http.get(`${this.entity}/all`);
    }

}