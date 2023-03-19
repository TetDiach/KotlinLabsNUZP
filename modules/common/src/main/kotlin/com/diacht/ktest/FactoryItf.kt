package com.diacht.ktest

abstract class FactoryItf {
    /**
     * Метод для cкидання стану симуляції, всі внутрішні стани, лічильники, списки продуктів і т.і. мають
     * бути зкинуті в реалзіції цього методу.
     */
    abstract fun resetSimulation()

    /**
     * Отримати продукти від постачальника, та зберігти їх в сховищі.
     */
    abstract fun loadProducts(productsFromSupplier: List<Product>)

    /**
     * Метод для прийняття замовлення, на вході список з даними про тип замовлення та кількість.
     */
    abstract fun order(order: List<Pair<ProductType, Int>>) : List<Product>

    /**
     * Метод для отримання залишків продуктів.
     */
    abstract fun getLeftovers() : List<Product>

    /**
     * Статистика подарунків. Повертає: Список Product(Тип продукту, кількість)
     */
    fun getGift() : List<Product> = emptyList()

    /**
     * Скількі грошей в кассі.
     */
    open fun getEarnings() : Int = 0

    /**
     * Статистика замовленнь. Повертає: Список Product(Тип продукту, кількість)
     */
    fun getOrderStatistics() : List<Product> = emptyList()

    /**
     * Найпопулярніший напій. Повертає: Product(Тип продукту, кількість), якщо такого продукту не має,
     * то треба повернути  Product(NONE, 0), якщо таких продуктів декілька, то повертає будь-який
     */
    open fun getPopularDrink() : Product = Product(NONE, 0)

    /**
     * Непопулярний напій. Повертає: Product(Тип продукту, кількість), якщо такого продукту не має,
     * то треба повернути  Product(NONE, 0), якщо таких продуктів декілька, то повертає будь-який
     */
    fun getUnpopularDrink() : Product = Product(NONE, 0)

    /**
     * Найприбутковий напій. Повертає: Pair(Тип продукту, кількість_грошей), якщо такого продукту не має,
     * то треба повернути  Product(NONE, 0), якщо таких продуктів декілька, то повертає будь-який
     */
    fun getMostEarnings() : Pair<ProductType, Int> = Pair(NONE, 0)
}