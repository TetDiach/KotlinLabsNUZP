package com.diacht.ktest

interface Storage {
    /**
     * Помістити продукт на зберігання в сховище.
     */
    fun addProduct(product: Product)

    /**
     * Отримати скільки вказаного продукту міститься в сховищі. Якщо такого продукту немає,
     * то метод має повернути 0.0.
     */
    fun checkProductCount(type: ProductType) : Int

    /**
     * Забрати вказану кількість вказаного продукту зі сховища. Метод має змінити кількість залишків продукту у
     * сховищі та повернути продукт та кількість, що забрали.
     * @throws IllegalStateException Якщо продукту не вистачає або зовсім немає, то метод може
     * послати IllegalStateException("Продукту $type не вистачає")
     */
    fun getProduct(productType: ProductType, count: Int) : Product

    /**
     * Метод для отримання залишків продуктів.
     */
    fun getLeftovers() : List<Product>

    /**
     * Метод для скидання стану симуляції, списки продуктів мають бути скинуті в реалізації цього методу.
     */
    fun resetSimulation()
}