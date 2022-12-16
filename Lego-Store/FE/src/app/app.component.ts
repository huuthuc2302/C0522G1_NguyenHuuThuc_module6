import { Component } from '@angular/core';
import { render} from 'creditcardpayments/creditCardPayments';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FE';

  constructor() {
    // render(
    //   {
    //     id: "#myPayPalButtons",
    //     currency: "USD",
    //     value: "1000.00",
    //     onApprove: (details) => {
    //       alert("Transaction Successful")
    //     }
    //   }
    // )
  }

}
