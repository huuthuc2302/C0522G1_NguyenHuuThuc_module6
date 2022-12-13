import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './list/list.component';
import {CartComponent} from './cart/cart.component';
import {SecurityModule} from './security/security.module';


const routes: Routes = [
  {
    path: '', component: ListComponent
  },
  {
    path: 'cart', component: CartComponent
  },
  {
    path: 'login', loadChildren: () => SecurityModule,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
