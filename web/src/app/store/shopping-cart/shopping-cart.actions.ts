import { createAction, props } from '@ngrx/store';
import { Product } from './shopping-cart.models';

export const getAllShoppingCart = createAction(
    '[ShoppingCart] getall'
);
export const getAllShoppingCartSuccess = createAction(
    '[ShoppingCart] getall success',
    props<{ items: Product[] }>()
);
export const addShoppingCart = createAction(
    '[ShoppingCart] add',
    props<{ item: Product }>()
);
export const addShoppingCartSuccess = createAction(
    '[ShoppingCart] add success',
    props<{ item: Product }>()
);
export const updateShoppingCart = createAction(
    '[ShoppingCart] update',
    props<{ item: Product }>());
export const updateShoppingCartSuccess = createAction(
    '[ShoppingCart] update success',
    props<{ item: Product }>()
);
export const deleteShoppingCart = createAction(
    '[ShoppingCart] delete',
    props<{ item: Product }>()
);
export const deleteShoppingCartSuccess = createAction(
    '[ShoppingCart] delete success',
    props<{ item: Product }>()
);