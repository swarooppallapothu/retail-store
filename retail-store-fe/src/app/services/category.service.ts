import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Category } from '../models/category.model';

@Injectable()
export class CategoryService {

    api: string = environment.API_ENDPOINT_PREFIX;
    entity: string = `${this.api}api/category`;

    constructor(private http: HttpClient) {

    }

    getAll(): Observable<any> {
        return this.http.get(`${this.entity}/all`);
    }

    getByDepartment(departmentId: string): Observable<any> {
        return this.http.get(`${this.entity}/department/${departmentId}`);
    }

    saveCategory(entity: Category): Observable<any> {
        return this.http.post(this.entity, entity);
    }

    updateCategory(entity: Category): Observable<any> {
        return this.http.put(this.entity, entity);
    }

}