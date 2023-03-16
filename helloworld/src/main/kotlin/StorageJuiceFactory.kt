import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import com.diacht.ktest.Storage

class StorageJuiceFactory : Storage {
    val storage = mutableListOf<Product>()

    override fun addProduct(product: Product) {
        storage.add(product)
    }

    override fun checkProductCount(type: ProductType): Int {
        var res = 0
        storage.forEach {
            if (it.type == type) res += it.count
        }
        return res
    }

    override fun getProduct(productType: ProductType, count: Int): Product {
        var res = -count
        var errorRes = 0
        var productNew: Product
        storage.forEach {
            if (it.type == productType) {
                errorRes += it.count
                res = it.count + res
                storage.remove(it)
            }
        }
        if(res<0)  {
            storage.add(Product(productType, errorRes))
            throw IllegalStateException()
        }
        productNew = Product(productType, res)
        storage.add(productNew)
        return productNew
    }

    override fun getLeftovers(): List<Product> = storage

    override fun resetSimulation() {
        storage.clear()
    }
}