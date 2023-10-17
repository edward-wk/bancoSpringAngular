import {ErrorHandler, Injectable} from '@angular/core';
import {environment} from "../../environments/environments";

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlerService implements ErrorHandler {

  handleError(error: any): void {
    if (error.name == 'HttpErrorResponse') {
      console.log('Servidor apagado', error)
      environment.servidorEncendido = false
    }
  }

}
