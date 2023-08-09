import { NgModule } from '@angular/core';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';
import { shoppingCartReducer } from './shopping-cart.reducer';
import { ShoppingCartEffects } from './shopping-cart.effects';


@NgModule({
  declarations: [],
  imports: [
    StoreModule.forFeature('shoppingCart', shoppingCartReducer),
    EffectsModule.forFeature([ShoppingCartEffects]),
  ]
})
export class ShoppingCartStoreModule { }
