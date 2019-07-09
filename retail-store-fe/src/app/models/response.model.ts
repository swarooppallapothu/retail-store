export class Response<T> {
    responseCode: string;
    data: T;
    recordsCount: number;
    pageSize: number;
    currentPage: number;
    message: number;
}