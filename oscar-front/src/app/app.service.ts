import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Calcado } from './model/CalcadoModel';
import { FiltroBuscaCalcado } from './model/FiltroBuscaCalcadoModel';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  buscaComposta(calcado: FiltroBuscaCalcado): Promise<any> {
    return this.http.post(`http://localhost:8080/calcado/busca-composta`, calcado)
    .toPromise()
    .then((listaCalcado) => listaCalcado);
  }

  cadastraCalcado(calcado: Calcado): Promise<any> {
    return this.http.post(`http://localhost:8080/calcado`, calcado)
    .toPromise()
    .then((calcadoCadastrado) => calcadoCadastrado);
  }

  deletaCalcado(idCalcado: number): Promise<any> {
    return this.http.delete(`http://localhost:8080/calcado/${idCalcado}`)
    .toPromise()
    .then((resposta) => resposta);
  }

  editaCalcado(idCalcado: number, calcado: Calcado): Promise<any> {
    return this.http.put(`http://localhost:8080/calcado/${idCalcado}`, calcado)
    .toPromise()
    .then((resposta) => resposta);
  }
}

