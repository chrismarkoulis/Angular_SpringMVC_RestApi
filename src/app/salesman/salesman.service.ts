import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import {Salesman} from './salesman';
import { map } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';
// import 'rxjs/add/operator/map';
// import 'rxjs/add/operator/catch';


@Injectable()
export class SalesmanService{


    constructor(private _httpService: Http){}

    getAllSalesmen(): Observable<Salesman[]>{
        return this._httpService.get("http://localhost:8080/SpringRestJavaBased/salesman")
        .pipe(map((response: Response) => response.json()))
        .pipe(catchError(this.handleError));

    }

    private handleError(error: Response){

        return Observable.throw(error);

    }

    addSalesman(salesman: Salesman){

        let body = JSON.stringify(salesman);
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        if(salesman.scode){
           return this._httpService.put('http://localhost:8080/SpringRestJavaBased/salesman/' + salesman.scode, body, options);
        } else {
        return this._httpService.post("http://localhost:8080/SpringRestJavaBased/salesman", body, options);
        }
    }


    deleteSalesman(salesmanId: String){

       return this._httpService.delete('http://localhost:8080/SpringRestJavaBased/salesman/' + salesmanId)


    }

    getSalesmanById(salesmanId: String): Observable<Salesman>{
      return this._httpService.get('http://localhost:8080/SpringRestJavaBased/salesman/' + salesmanId)
      .pipe(map((response: Response) => response.json()))
      .pipe(catchError(this.handleError));
    }
}