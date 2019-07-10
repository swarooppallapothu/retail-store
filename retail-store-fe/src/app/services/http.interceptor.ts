import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { throwError, Observable } from 'rxjs';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';

@Injectable()
export class RequestInterceptor implements HttpInterceptor {

    constructor(
        private router: Router) { }

    addTokenToRequest(request: HttpRequest<any>, token: string): HttpRequest<any> {
        return request.clone({
            setHeaders: {
                'Authorization': `${token}`
            }
        });
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let userIdentity = localStorage.getItem('userIdentity') ? JSON.parse(localStorage.getItem('userIdentity')) : {}  || {};

        return next.handle(this.addTokenToRequest(request, userIdentity['Authorization']))
            .pipe(catchError(error => {
                if (error instanceof HttpErrorResponse) {
                    switch ((<HttpErrorResponse>error).status) {
                        case 401:
                            this.handleUnauthorizedRequest(request, next);
                            return throwError(error);
                        case 403:
                            this.handleUnauthorizedRequest(request, next);
                            return throwError(error);
                        case 400:
                            return throwError(error);
                        case 500:
                            return throwError(error);
                    }
                } else {
                    return Observable.throw(error);
                }
            }))

    }

    handleUnauthorizedRequest(request: HttpRequest<any>, next: HttpHandler): void {
        // this.authServerProvider.logout();
        this.router.navigate(['/login']);
    }
}
