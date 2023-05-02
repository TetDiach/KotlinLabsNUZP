import com.diacht.ktest.domain.usecases.CalculateL4TaskUseCase
import com.diacht.ktest.domain.usecases.GenerateL4TaskUseCase
import kotlinx.coroutines.runBlocking
import org.jetbrains.kotlin.daemon.common.toHexString
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeout
import java.security.MessageDigest
import java.time.Duration
import kotlin.random.Random
import kotlin.test.assertEquals

internal class L4Test {

    @Test
    fun taskTest() {
        val md = MessageDigest.getInstance("MD5")
        val calculator = CalculateL4TaskUseCase(md)
        val generator = GenerateL4TaskUseCase()
        val seed = seed()
        val task = generator(seed)
        val args = mutableListOf<List<String>>()
        val random = Random(task.digest[11] * task.digest[12] * task.digest[13] * task.digest[14])
        for (i in 0..9) {
            val current = mutableListOf<String>()
            for (j in 0..task.intTask.cnt) {
                val digest = md.digest(random.nextBytes(16))
                current.add(digest.toHexString())
            }
            args.add(current)
        }
        args.forEach {
            val result = calculator(task.intTask, it)
            var calculated : Double
            calculated = assertTimeout(Duration.ofSeconds(13), "Розрахунок виконується занадто довго") {
                return@assertTimeout runBlocking {
                    return@runBlocking serverDataCalculate(it)
                }
            }
            assertEquals(result, calculated, 0.001, "Некоректний результат для $it")
        }
    }

}