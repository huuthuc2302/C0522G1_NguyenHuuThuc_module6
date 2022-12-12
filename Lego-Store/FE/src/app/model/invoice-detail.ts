import {Invoice} from './invoice';
import {Lego} from './lego';

export interface InvoiceDetail {
  quantity?: number;
  lego?: Lego;
  invoice?: Invoice;
}
