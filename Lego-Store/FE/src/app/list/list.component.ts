import { Component, OnInit } from '@angular/core';
import {Category} from '../model/category';
import {Lego} from '../model/lego';
import {LegoService} from '../service/lego.service';
import {CategoryService} from '../service/category.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CartService} from '../service/cart.service';
import {DataService} from '../service/data.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  categoryList: Category[];
  legoList: Lego[];
  nameLego = '';
  idToDelete = 1;
  legoDetail: Lego ;
  cart: any = this.legoService.getCart();

  constructor(private legoService: LegoService,
              private categoryService: CategoryService,
              private cartService: CartService,
              private dataService: DataService
              ) {
  }

  legoForm: FormGroup;

  getAllLego() {
    this.legoService.getAllLego(this.nameLego).subscribe(value => this.legoList = value);
  }

  getAllCategory() {
    this.categoryService.getAllCategory().subscribe(value => this.categoryList = value);
  }

  ngOnInit(): void {
    this.legoForm = new FormGroup(
      {
        id: new FormControl(''),
        tenNguoiThue: new FormControl('', [Validators.required]),
        ngaySinh: new FormControl('', [Validators.required]),
        cmnd: new FormControl('', [Validators.required]),
        phongTro: new FormControl('', [Validators.required])
      });
    this.getAllLego();
    this.getAllCategory();
  }

  search() {
    this.getAllLego();
  }

  resetForm() {
    this.legoForm.reset();
  }

  onSubmit() {
    const lego = this.legoForm.value;
    this.legoService.createLego(lego).subscribe(
      value => {
      },
      error => {
      },
      () => {
        this.getAllLego();
        this.legoForm.reset();
        // this.toast.success('Thêm mới thành công!');
      }
    );
  }

  edit(lego: Lego) {
    this.legoForm.patchValue(lego);
  }

  update() {
    const lego = this.legoForm.value;
    this.legoService.updateLego(lego).subscribe(value => {
        this.getAllLego();
        this.legoForm.reset();
        // this.toast.success('Chỉnh sửa thành công!');
      },
      error => {
        // this.toast.error('Chỉnh sửa thất bại!');
      },
      () => {

      });
  }

  compareWithId(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }


  delete() {
    this.legoService.deleteLego(this.idToDelete).subscribe(
      value => this.getAllLego()
    );
    // this.toast.success('Xóa Thành công !');
  }

  setDelete(id: number,
            nameLego: string) {
    this.idToDelete = id;
    this.nameLego = nameLego;
  }

  detail(lego: Lego) {
    this.legoDetail = lego

  }

  onAddToCart(lego: any) {
    const index = this.cart.findIndex((item) => {
      return item.id === lego.id;
    });
    if (index >= 0) {
      this.cart[index].quantity += 1;
    } else {
      const cartItem: any = {
        id: lego.id,
        name: lego.name,
        price: lego.price,
        quantity: 1,
        imageBox: lego.imageBox
      };
      this.cart.push(cartItem);
    }
    this.cartService.saveCart(this.cart);
    this.dataService.changeData({
      quantity: this.cartService.getTotalQuantity()
    });
    Swal.fire('Thông Báo !!', 'Đã thêm vào giỏ hàng', 'success').then();
  }

}
