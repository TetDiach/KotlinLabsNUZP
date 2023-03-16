import org.example.KTests.BuildConfig
import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

internal class L1Test {

    @Test
    fun task1Test() {
        when (BuildConfig.LAB_NUMBER) {
            1 -> {
                val buffer = StringBuilder()
                interceptPrintln(buffer)
                main(emptyArray())
                assertEquals("Щось не так з третім кошеням", 5, buffer.lines().size)
                val lastLine = buffer.lines()[3]
                assertTrue(lastLine.contains("рудий", true), "Нема імені третього кошення")
                assertTrue(lastLine.contains("\uD83D\uDC06"), "Нема емоджі третього кошення")
                assertTrue(lastLine.contains("кошеня №3", true), "Нема номера третього кошення")
                assertTrue(lastLine.contains("віком 6 ", true), "Некоректний вік третього кошення")
                assertTrue(lastLine.contains("вагою 8.2 ", true), "Некоректна вага третього кошення")
            }
        }
    }
}