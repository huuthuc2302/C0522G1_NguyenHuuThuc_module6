import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Lego} from '../model/lego';

@Injectable({
  providedIn: 'root'
})
export class LegoService {

  API_URL = 'http://localhost:8080/';

  constructor(private  http: HttpClient) {
  }

  getAllLego(nameLego: string): Observable<Lego[]> {
    return this.http.get<Lego[]>(this.API_URL + 'legoList?nameLego=' + nameLego);
  }

  createLego(lego: Lego): Observable<void> {
    return this.http.post<void>(this.API_URL + 'legoList', lego);
  }

  updateLego(lego: Lego): Observable<void> {
    return this.http.patch<void>(this.API_URL + 'legoList', lego);
  }

  deleteLego(id: number): Observable<void> {
    return this.http.delete<void>(this.API_URL + 'legoList/' + id);
  }

  getCart() {
    const cartJson = sessionStorage.getItem('cart');
    if (cartJson) {
      return JSON.parse(cartJson);
    } else {
      return [];
    }
  }

}
