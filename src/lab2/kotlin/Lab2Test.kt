import com.diacht.ktest.TaskL2
import com.diacht.ktest.TaskValidationResults
import com.diacht.ktest.domain.usecases.GenerateL2TaskUseCase
import com.diacht.ktest.domain.usecases.ValidateL2DoubleTaskUseCase
import com.diacht.ktest.domain.usecases.ValidateL2IntTaskUseCase
import com.diacht.ktest.domain.usecases.ValidateL2StrTaskUseCase
import com.diacht.ktest.domain.usecases.ValidateL2UseCase
import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals
import kotlin.test.assertTrue

internal class Lab2Test {

    @Test
    fun task1Test() {
        val generator = GenerateL2TaskUseCase()
        val seed = seed()
        val task = generator(seed)
        testCalculate(task, ValidateL2IntTaskUseCase(), seed)
    }

    @Test
    fun task2Test() {
        val generator = GenerateL2TaskUseCase()
        val seed = seed()
        val task = generator(seed)
        testCalculate(task, ValidateL2DoubleTaskUseCase(), seed)
    }

    @Test
    fun task3Test() {
        val generator = GenerateL2TaskUseCase()
        val seed = seed()
        val task = generator(seed)
        testCalculate(task, ValidateL2StrTaskUseCase(), seed)
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