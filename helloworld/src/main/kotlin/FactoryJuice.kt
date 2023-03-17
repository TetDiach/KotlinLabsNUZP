import com.diacht.ktest.FactoryItf
import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import com.diacht.ktest.Receipt
import com.diacht.ktest.juicefactory.*

class FactoryJuice : FactoryItf() {
    val storageJuiceFactory = StorageJuiceFactory()

    override fun resetSimulation() {
        storageJuiceFactory.resetSimulation()
    }

    override fun loadProducts(productsFromSupplier: List<Product>) {
        productsFromSupplier.forEach {
            storageJuiceFactory.addProduct(it)
        }
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
        val orderDone = mutableListOf<Product>()
        order.forEach {
            when (it.first) {
                ORANGE_JUICE -> {
                    getProductForReceipt(OrangeJuiceReceipt, it.second)
                    orderDone.add(Product(ORANGE_JUICE, it.second))
                }
                APPLE_JUICE -> {
                    getProductForReceipt(AppleJuiceReceipt, it.second)
                    orderDone.add(Product(APPLE_JUICE, it.second))
                }
                APPLE_CARROT_JUICE -> {
                    getProductForReceipt(AppleCarrotJuiceReceipt, it.second)
                    orderDone.add(Product(APPLE_CARROT_JUICE, it.second))
                }
                TOMATO_CARROT_JUICE -> {
                    getProductForReceipt(TomatoCarrotJuiceReceipt, it.second)
                    orderDone.add(Product(TOMATO_CARROT_JUICE, it.second))
                }
                TOMATO_JUICE -> {
                    getProductForReceipt(TomatoJuiceReceipt, it.second)
                    orderDone.add(Product(TOMATO_JUICE, it.second))
                }
            }
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
}