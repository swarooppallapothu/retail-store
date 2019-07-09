import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable()
export class SubCategoryService {

    api: string = environment.api;
    entity: string = `${this.api}/sub-category`;

    constructor(private http: HttpClient) {

    }

    getAll(): Observable<any> {
        return this.http.get(`${this.entity}/all`);
    }

    getByCategory(categoryId: string): Observable<any> {
        return this.http.get(`${this.entity}/category/${categoryId}`);
    }

}