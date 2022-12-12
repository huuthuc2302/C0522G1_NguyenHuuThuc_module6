import { Component, OnInit } from '@angular/core';
import {Lego} from '../model/lego';
import {CartService} from '../service/cart.service';
import {DataService} from '../service/data.service';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  carts: any[];
  totalPrice = this.cartService.getTotalPrice();
  totalQuantity = this.cartService.getTotalQuantity();

  constructor(private cartService: CartService,
              private dataService: DataService,
              private title: Title) {
    this.title.setTitle('Giỏ hàng');
  }

  ngOnInit(): void {
    // tslint:disable-next-line:variable-name
    const _this = this;
    setTimeout(() => {
      _this.dataService.changeData({
        quantity: _this.cartService.getTotalQuantity()
      });
    }, 1);
    this.carts = this.cartService.getCart();
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });
  }

  decrease(index: number, quantity: any) {
    let decreaseQuantity = parseInt(quantity, 10) - 1;
    decreaseQuantity = decreaseQuantity > 0 ? decreaseQuantity : 1;
    this.carts[index].quantity = decreaseQuantity;
    this.cartService.saveCart(this.carts);
    this.totalPrice = this.cartService.getTotalPrice();
    this.totalQuantity = this.cartService.getTotalQuantity();
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });
  }

  increase(index: number, quantity: any) {
    let increaseQuantity = parseInt(quantity, 10) + 1;
    increaseQuantity = increaseQuantity <= 999 ? increaseQuantity : 999;
    this.carts[index].quantity = increaseQuantity;
    this.cartService.saveCart(this.carts);
    this.totalPrice = this.cartService.getTotalPrice();
    this.totalQuantity = this.cartService.getTotalQuantity();
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });
  }

}
