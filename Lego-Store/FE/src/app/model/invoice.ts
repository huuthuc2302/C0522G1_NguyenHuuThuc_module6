import {InvoiceDetail} from './invoice-detail';

export interface Invoice {
  id?: number;
  code?: string;
  time?: Date;
  status?: boolean;
  invoiceDetail?: InvoiceDetail[];
}
