import com.diacht.ktest.TaskL2
import com.diacht.ktest.TaskValidationResults
import com.diacht.ktest.domain.usecases.GenerateL2TaskUseCase
import com.diacht.ktest.domain.usecases.ValidateL2DoubleTaskUseCase
import com.diacht.ktest.domain.usecases.ValidateL2IntTaskUseCase
import com.diacht.ktest.domain.usecases.ValidateL2StrTaskUseCase
import com.diacht.ktest.domain.usecases.ValidateL2UseCase
import org.example.KTests.BuildConfig
import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

internal class MainTest {
    @Test
    fun testGithubUser() {
        assertNotEquals(seed(), "user", "Впишіть ім'я СВОГО GitHub користувача.")
        assertTrue(seed().isNotEmpty(), "Не вказано ім'я GitHub користувача")
    }

    @Test
    fun task1Test() {
        when (BuildConfig.LAB_NUMBER) {
            1 -> {
                val buffer = StringBuilder()
                interceptPrintln(buffer)
                main(emptyArray())
                assertEquals("Щось не так з третім кошеням", 5, buffer.lines().size)
                val lastLine = buffer.lines()[3]
                assertTrue(
                    lastLine.contains("рудий", true) &&
                            lastLine.contains("\uD83D\uDC06") &&
                            lastLine.contains("кошеня №3", ignoreCase = true) &&
                            lastLine.contains("віком 6 років", ignoreCase = true) &&
                            lastLine.contains("вагою 8 ", ignoreCase = true),
                    "Щось не так з третім кошеням"
                )
            }
            2 -> {
                val generator = GenerateL2TaskUseCase()
                val seed = seed()
                val task = generator(seed)
                testCalculate(task, ValidateL2IntTaskUseCase(), seed)
            }
            else -> assertTrue(false, "Некоректний номер лаболаторної роботи")
        }
    }

    @Test
    fun task2Test() {
        when (BuildConfig.LAB_NUMBER) {
            1 -> {
            }
            2 -> {
                val generator = GenerateL2TaskUseCase()
                val seed = seed()
                val task = generator(seed)
                testCalculate(task, ValidateL2DoubleTaskUseCase(), seed)
            }
            else -> assertTrue(false, "Некоректний номер лаболаторної роботи")
        }
    }

    @Test
    fun task3Test() {
        when (BuildConfig.LAB_NUMBER) {
            1 -> {
            }
            2 -> {
                val generator = GenerateL2TaskUseCase()
                val seed = seed()
                val task = generator(seed)
                testCalculate(task, ValidateL2StrTaskUseCase(), seed)
            }
            else -> assertTrue(false, "Некоректний номер лаболаторної роботи")
        }
    }


    fun testCalculate(task: TaskL2, useCase: ValidateL2UseCase, seed: String) {
        val result = useCase(task, seed)
        when (result) {
            is TaskValidationResults.WrongResult -> assertEquals(result.description, result.expected, result.actual)
            is TaskValidationResults.Fail -> assertTrue(false, result.description)
            TaskValidationResults.Success -> {}
            else -> {}
        }
    }
}