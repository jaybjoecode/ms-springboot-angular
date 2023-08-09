import { Action, createReducer, on } from '@ngrx/store';
import * as fromActions from './shopping-cart.actions';
import { ShoppingCartState } from './shopping-cart.models';

export const initialState: ShoppingCartState = {
    products: []
};

const _shoppingCartReducer = createReducer<ShoppingCartState>(
    initialState,
    on(fromActions.getAllShoppingCart, (state) => {
        return {
            ...state,
        }
    }),
    on(fromActions.getAllShoppingCartSuccess, (state, { items }) => {
        console.log('enter reducer', items)
        return {
            ...state,
            products: items
        }
    }),
    on(fromActions.addShoppingCart, (state) => {
        return {
            ...state,
        }
    }),
    on(fromActions.addShoppingCartSuccess, (state, { item }) => {
        return {
            ...state,
            products: [...state.products, item],
        }
    }),
    on(fromActions.updateShoppingCart, (state) => {
        return {
            ...state,
        }
    }),
    on(fromActions.updateShoppingCartSuccess, (state, { item }) => {
        return {
            ...state,
            products: state.products.map((b) => b.id === item.id ? item : b),
        }
    }),
    on(fromActions.deleteShoppingCart, (state) => {
        return {
            ...state,
        }
    }),
    on(fromActions.deleteShoppingCart, (state, { item }) => {
        return {
            ...state,
            products: state.products.filter((b) => b.id !== item.id)
        }
    }),
);

export function shoppingCartReducer(state = initialState, actions: Action): ShoppingCartState {
    return _shoppingCartReducer(state, actions);
}