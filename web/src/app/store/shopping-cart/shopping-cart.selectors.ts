import { createFeatureSelector, createSelector } from '@ngrx/store';
import { ShoppingCartState } from './shopping-cart.models';

export const selectShoppingCartState = createFeatureSelector<ShoppingCartState>('shoppingCart');
export const selectShoppingCartList = createSelector(selectShoppingCartState, (state) => state.products);
export const selectShoppingCartCount = createSelector(selectShoppingCartState, (state) => state.products.length);
// export const selectBookIsLoading = createSelector(selectBookState, (state) => state.isLoading);

