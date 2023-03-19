import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import com.diacht.ktest.Storage

class StorageJuiceFactory : Storage {
//    val juicePress = JuicePress(this)
    val storage = mutableListOf<Product>()

    override fun addProduct(product: Product) {
        storage.add(product)
    }

    override fun checkProductCount(type: ProductType): Int {
        var res = 0
        storage
            .filter { it.type == type }
            .forEach { res += it.count }
        return res
    }

    override fun getProduct(productType: ProductType, count: Int): Product {
        var res = -count
        var errorRes = 0

        storage.removeAll(storage
            .filter { it.type == productType }
            .onEach {
                errorRes += it.count
                res += it.count
            }
        )
        if(res<0)  {
            storage.add(Product(productType, errorRes))
            throw IllegalStateException()
        } else {
            storage.add(Product(productType, res))
            return Product(productType, count)
        }
    }

    override fun getLeftovers(): List<Product> = storage

    override fun resetSimulation() {
        storage.clear()
    }
}