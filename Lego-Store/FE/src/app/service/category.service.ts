import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  API_URL = 'http://localhost:8080/';
  constructor(private  http: HttpClient) { }

  getAllCategory() :Observable<Category[]>{
    return this.http.get<Category[]>(this.API_URL + "categoryList")
  }

}
