import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './store/shopping-cart/shopping-cart.models';
import { select, Store } from '@ngrx/store';
import { ProductService } from './services/product.service';
import * as actions from './store/shopping-cart/shopping-cart.actions';
import { selectShoppingCartCount, selectShoppingCartList } from './store/shopping-cart/shopping-cart.selectors';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'web-app';
  products$: Observable<Product[]> | undefined;
  count$: Observable<number> | undefined;

  constructor(private store: Store) { }

  async ngOnInit() {
    this.initDispatch();
    this.initSubscriptions();
    this.products$?.subscribe(res => console.log('products', res))
  }

  private initDispatch(): void {
    // Init
    this.store.dispatch(actions.getAllShoppingCart());
  }

  private initSubscriptions(): void {
    // Init Subcritions
    this.products$ = this.store.pipe(select(selectShoppingCartList));
    this.count$ = this.store.pipe(select(selectShoppingCartCount));
  }

}
