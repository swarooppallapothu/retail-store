import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { SubCategory } from '../models/sub-category.model';

@Injectable()
export class SubCategoryService {

    api: string = environment.API_ENDPOINT_PREFIX;
    entity: string = `${this.api}api/sub-category`;

    constructor(private http: HttpClient) {

    }

    getAll(): Observable<any> {
        return this.http.get(`${this.entity}/all`);
    }

    getByCategory(categoryId: string): Observable<any> {
        return this.http.get(`${this.entity}/category/${categoryId}`);
    }

    saveSubCategory(entity: SubCategory): Observable<any> {
        return this.http.post(this.entity, entity);
    }

    updateSubCategory(entity: SubCategory): Observable<any> {
        return this.http.put(this.entity, entity);
    }

}