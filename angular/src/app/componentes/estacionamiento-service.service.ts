import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
 
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Registro } from '../model/registro';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class EstacionamientoServiceService {
  
  private registrosUrl = 'http://localhost:8080/registroVigilante';  // URL to web api

  constructor(
    private http: HttpClient) { }

      /** GET hero by id. Will 404 if id not found */
  getRegistroPlaca(placa: string): Observable<Response> {
    const url = `${this.registrosUrl}/${'registro'}/${placa}`;
    return this.http.get<Response>(url).pipe(
      tap(_ => this.log(`buscar registro por placa=${placa}`)),
      catchError(this.handleError<Response>(`getRegistroPlaca placa=${placa}`))
    );
  }

  addRegistro (registro: Registro): Observable<Response> {
    return this.http.post<Response>(this.registrosUrl+'/guardarRegistro', registro, httpOptions).pipe(
      tap((registro: Registro) => this.log(`agregando registro w/ id=${registro.placa}`)),
      catchError(this.handleError<Response>('addRegistro'))
    );
  }

  updateRegistro(placa: string): Observable<Response> {
    return this.http.put<Response>(this.registrosUrl+'/registro/'+placa, httpOptions).pipe(
      tap(_=> this.log(`facturando registro w/ id=${placa}`)),
      catchError(this.handleError<Response>('updateRegistro'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
 
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
 
      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
 
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
 
  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    console.log(`HeroService: ${message}`);
  }
}


