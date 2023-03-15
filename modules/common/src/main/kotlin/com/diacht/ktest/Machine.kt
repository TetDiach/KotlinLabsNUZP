package com.diacht.ktest

import java.util.concurrent.TimeUnit

const val MAX_PROCESS_PRODUCT = 5

open class Machine(private val storage: Storage) {
    private var currentReciept : Receipt? = null

    /**
     * Отримати продукти від постачальника, та зберігти їх в сховищі.
     */
    fun loadProducts(productsFromSupplier: List<Product>) = storage.getLeftovers()

    /**
     * Встановити "рецепт" який буде використано для створення вихідного продукту.
     */
    fun setReceipt(receipt: Receipt) {
        currentReciept = receipt
    }

    /**
     * Завантажити потрібні для рецепта продукти.
     */
    fun consumeProducts(products: List<Product>) = products.forEach {
        storage.addProduct(it)
//        if (storage.checkProductCount(it.type) > MAX_PROCESS_PRODUCT) {
//            throw IllegalStateException("Process overloaded with ${it.type} count > $MAX_PROCESS_PRODUCT")
//        }
    }

    /**
     * Створити вихідний продукт.
     */
    fun executeProcess() : Product {
        val receipt = currentReciept ?: throw IllegalStateException("Receipt isn't set")
        receipt.products.forEach {
            storage.getProduct(it.type, it.count)
        }
//      receipt.timeUnit.sleep(receipt.time)
        TimeUnit.MILLISECONDS.sleep(receipt.time)
        return Product(receipt.outProductType, 1)
    }
}