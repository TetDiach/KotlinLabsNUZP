import org.junit.jupiter.api.Test
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

internal class MainTest {
    @Test
    fun testGithubUser() {
        assertNotEquals(seed(), "user", "Впишіть ім'я СВОГО GitHub користувача.")
        assertTrue(seed().isNotEmpty(), "Не вказано ім'я GitHub користувача")
    }
}