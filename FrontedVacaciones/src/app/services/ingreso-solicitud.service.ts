import { Injectable } from '@angular/core';
import {Headers,Http,Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import swal from 'sweetalert2';

@Injectable()
export class IngresoSolicitudService {

  private _url = "http://localhost:8090";  
  constructor(private _http: Http) {}

  public create(solicitud):Observable<any>{
    const headers = new Headers({'Content-type':'application/json'});     
    return this._http.post(`${this._url}/solicitud/vacaciones`,solicitud, headers)
    .map(this.extractData)
    .catch(this.handleError);    
       }

       private extractData(res:Response){
        swal({
          title: 'Excelente!',
          text: '',
          type: 'success',
          confirmButtonText: 'Cool'
        })
        return res.json()||{};
      }
    
      private handleError(error:Response | any){    
        let errMsg: string;
        if(error instanceof Response){
          const body =error.json() || '';
          const err = body.error|| JSON.stringify(body);
          errMsg = `${error.status} - ${error.statusText || ''} ${err} `;
          alert(body.message);
        }else{
          errMsg =error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable.throw(errMsg);
      }
    
  

}
