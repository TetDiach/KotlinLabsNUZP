import com.diacht.ktest.FactoryItf
import com.diacht.ktest.Product
import com.diacht.ktest.ProductType

class FactoryJuice : FactoryItf() {
    val storageJuiceFactory = StorageJuiceFactory()

    override fun resetSimulation() {
        TODO("Not yet implemented")
    }

    override fun loadProducts(productsFromSupplier: List<Product>) {
        productsFromSupplier.forEach {
             storageJuiceFactory.addProduct(it)
        }
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
        TODO("Not yet implemented")
    }

    override fun getLeftovers(): List<Product> {
        TODO("Not yet implemented")
    }
}