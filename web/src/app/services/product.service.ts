import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Product } from '../store/shopping-cart/shopping-cart.models';

@Injectable({
    providedIn: 'root'
})
export class ProductService {

    private products: Product[] = [
        {
            id: '' + Math.random(),
            name: 'Book 1',
            description: 'Qwerty qwerqwer',
            price: 123
        },
        {
            id: '' + Math.random(),
            name: 'Book 2',
            description: 'Qwerty qwerqwer',
            price: 123
        }
    ];

    constructor() {
    }

    get(): Observable<Product[]> {
        console.log('enter service', this.products)
        return of(this.products);
    }

    add(item: Product): Observable<Product> {
        this.products = [
            ...this.products,
            item
        ];

        return of(item);
    }
    update(item: Product): Observable<Product> {
        this.products.map(item => item.id === item.id ? item : item);

        return of(item);
    }

    delete(item: Product): Observable<Product> {
        this.products = this.products.filter(b => b.id !== item.id);
        return of(item);
    }
}
