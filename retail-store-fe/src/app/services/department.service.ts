import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable()
export class DepartmentService {

    api: string = environment.API_ENDPOINT_PREFIX;
    entity: string = `${this.api}api/department`;

    constructor(private http: HttpClient) {

    }

    getAll(): Observable<any> {
        return this.http.get(`${this.entity}/all`);
    }

    getByLocation(locationId: string): Observable<any> {
        return this.http.get(`${this.entity}/location/${locationId}`);
    }

}