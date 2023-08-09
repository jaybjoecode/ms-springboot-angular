export interface Product {
    id?: string;
    name?: string;
    description?: string;
    price?: number;
    quantity?: number; 
}

export interface ShoppingCartState {
    products: Product[];
}