import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable()
export class DepartmentService {

    api: string = environment.api;
    entity: string = `${this.api}/department`;

    constructor(private http: HttpClient) {

    }

    getAll(): Observable<any> {
        return this.http.get(`${this.entity}/all`);
    }

}