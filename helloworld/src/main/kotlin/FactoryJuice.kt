import com.diacht.ktest.*
import com.diacht.ktest.juicefactory.*

class FactoryJuice : FactoryItf() {
    val storageJuiceFactory = StorageJuiceFactory()
    val orderDoneAll = mutableListOf<Pair<ProductType, Int>>()

    override fun resetSimulation() {
        storageJuiceFactory.resetSimulation()
        orderDoneAll.clear()
    }

    override fun loadProducts(productsFromSupplier: List<Product>) {
        productsFromSupplier.forEach {
            storageJuiceFactory.addProduct(it)
        }
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
        val orderDone = mutableListOf<Product>()
        var count = 0
        var i = -1
        order.forEach { productTypeIntPair ->
            when (productTypeIntPair.first) {
                ORANGE_JUICE -> {
                    getProductForReceipt(OrangeJuiceReceipt, productTypeIntPair.second)
                    orderDone.add(Product(ORANGE_JUICE, productTypeIntPair.second))
                }

                APPLE_JUICE -> {
                    getProductForReceipt(AppleJuiceReceipt, productTypeIntPair.second)
                    orderDone.add(Product(APPLE_JUICE, productTypeIntPair.second))
                }

                APPLE_CARROT_JUICE -> {
                    getProductForReceipt(AppleCarrotJuiceReceipt, productTypeIntPair.second)
                    orderDone.add(Product(APPLE_CARROT_JUICE, productTypeIntPair.second))
                }

                TOMATO_CARROT_JUICE -> {
                    getProductForReceipt(TomatoCarrotJuiceReceipt, productTypeIntPair.second)
                    orderDone.add(Product(TOMATO_CARROT_JUICE, productTypeIntPair.second))
                }

                TOMATO_JUICE -> {
                    getProductForReceipt(TomatoJuiceReceipt, productTypeIntPair.second)
                    orderDone.add(Product(TOMATO_JUICE, productTypeIntPair.second))
                }
            }
            count = productTypeIntPair.second
            orderDoneAll
                .filter { it.first == productTypeIntPair.first }
                .forEachIndexed { index, pair ->
                    count += pair.second
                    i = index
                }

            if (i > -1)
                orderDoneAll.removeAt(i)
            orderDoneAll.add(Pair(productTypeIntPair.first, count))
            count = 0
            i = -1
        }
        return orderDone
    }

    fun getProductForReceipt(receipt: Receipt, count: Int) {
        receipt.products.forEach() {
            storageJuiceFactory.getProduct(it.type, count * it.count)
        }
    }

    override fun getLeftovers(): List<Product> {
//        val leftOvers = mutableListOf<Product>()
//        leftOvers.addAll(storageJuiceFactory.getLeftovers())
//        leftOvers.addAll()
        return storageJuiceFactory.getLeftovers()
    }

    override fun getPopularDrink(): Product {
        orderDoneAll.add(Pair(NONE, 0))
        orderDoneAll.sortByDescending { it.second }
        return Product(orderDoneAll[0].first, orderDoneAll[0].second)
    }
}