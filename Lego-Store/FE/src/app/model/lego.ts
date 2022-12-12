import {Category} from './category';

export interface Lego {

  id?: number;

  name?: string;

  price?: number;

  releaseYear?: string;

  numberOfPieces?: string;

  quantity?: number;

  imageUrl?: string;

  imageBox?: string;

  category?: Category ;

}
