import { Injectable } from '@angular/core';

import { Actions, createEffect, ofType } from '@ngrx/effects';

import { map, switchMap } from 'rxjs/operators';
import { ProductService } from 'src/app/services/product.service';
import * as actions from './shopping-cart.actions';
import { Product } from './shopping-cart.models';


@Injectable()
export class ShoppingCartEffects {
    constructor(private readonly actions$: Actions, private readonly productService: ProductService) {
    }

    getAllShoppingCart$ = createEffect(() =>
        this.actions$.pipe(
            ofType(actions.getAllShoppingCart.type),
            switchMap(() => this.productService.get()),
            map((items: Product[]) => {
                console.log('enter effect', items)
                return actions.getAllShoppingCartSuccess({items})
            })
        )
    );

    addShoppingCart$ = createEffect(() =>
        this.actions$.pipe(
            ofType(actions.addShoppingCart.type),
            switchMap(({item}) => this.productService.add(item)),
            map((item: Product) => actions.addShoppingCartSuccess({item}))
        )
    );

    updateShoppingCart$ = createEffect(() =>
        this.actions$.pipe(
            ofType(actions.updateShoppingCart.type),
            switchMap(({item}) => this.productService.update(item)),
            map((item: Product) => actions.updateShoppingCartSuccess({item}))
        )
    );

    deleteShoppingCart$ = createEffect(() =>
        this.actions$.pipe(
            ofType(actions.deleteShoppingCartSuccess.type),
            switchMap(({item}) => this.productService.delete(item)),
            map((item: Product) => actions.deleteShoppingCartSuccess({item}))
        )
    );
}
