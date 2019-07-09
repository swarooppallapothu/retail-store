import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable()
export class CategoryService {

    api: string = environment.api;
    entity: string = `${this.api}/category`;

    constructor(private http: HttpClient) {

    }

    getAll(): Observable<any> {
        return this.http.get(`${this.entity}/all`);
    }

    getByDepartment(departmentId: string): Observable<any> {
        return this.http.get(`${this.entity}/department/${departmentId}`);
    }

}