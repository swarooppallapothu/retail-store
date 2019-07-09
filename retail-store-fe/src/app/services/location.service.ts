import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable()
export class LocationService {

    api: string = environment.API_ENDPOINT_PREFIX;
    entity: string = `${this.api}api/location`;

    constructor(private http: HttpClient) {

    }

    getLocations(): Observable<any> {
        return this.http.get(`${this.entity}/all`);
    }

}