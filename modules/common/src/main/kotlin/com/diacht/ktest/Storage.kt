package com.diacht.ktest

interface Storage {
    /**
     * Помістити продукт на зберігання в сховище.
     */
    fun addProduct(product: Product)

    /**
     * Отримати скільки вкзаного продукту містится в сховищі. Якщо такого продукту немає,
     * то метод має повернути 0.0.
     */
    fun checkProductCount(type: ProductType) : Int

    /**
     * Забрати вказаний продукт зі сховища.
     * @throws IllegalStateException Якщо продукту не вистачає або зовсім немає, то метод може
     * послати IllegalStateException("Продукту $type не вистачає")
     */
    fun getProduct(productType: ProductType, count: Int) : Product

    /**
     * Метод для отримання залишків продуктів.
     */
    fun getLeftovers() : List<Product>

    /**
     * Метод для зкидання стану симуляції, всписки продуктів мають бути зкинуті в реалзіції цього методу.
     */
    fun resetSimulation()
}