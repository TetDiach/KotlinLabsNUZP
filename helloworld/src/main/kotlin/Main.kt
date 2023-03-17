import com.diacht.ktest.compose.startTestUi
import me.tetiana.helloworld.BuildConfig

fun seed(): String = "DiachT"


fun labNumber() : Int = BuildConfig.LAB_NUMBER

fun iCalculate(x0: Int = -121, x1: Int = -35, x2: Int = -70, x3: Int = -121) : Double {
    return Math.sqrt(maxOf(Math.abs(x0), Math.abs(x1), Math.abs(x2), Math.abs(x3)).toDouble())
}

fun dCalculate(x0: Double = 96.05, x1: Double = 106.25, x2: Double = 76.25, x3: Double = 18.2) : Double {
    return Math.log(minOf(Math.abs(x0), Math.abs(x1), Math.abs(x2), Math.abs(x3)))
}

fun strCalculate(x0: String, x1: String) : Int {
    var result = 0
    for (i in 0..x0.length - 1) {
//        if (x0[i] != 'A' && x0[i] != 'C')
//            continue
//        if (x0[i] == 'C' && x1[i] == 'G') {
//            result ++
//        }

        if (i % 2 == 1 && x0[i] != x1[i]) {
            result++
            if ((x0[i] == 'C' && x1[i] == 'G') || (x1[i] == 'C' && x0[i] == 'G')) {
                result++
            }
        }
    }
    return result
}

fun getSimulationObject():FactoryJuice{
    return FactoryJuice()
}

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")

    startTestUi(seed(), labNumber())
//
//    var kitty = "Васько"
//    kitty += " \uD83D\uDC31"
//    val age = 7
//    println("Кошеня №1 - $kitty віком $age років")
//
//
//    val catName: String = "Мурзик \uD83D\uDC08"
//    val weight: Float = 3.5f
//    println("Кошеня №2 - $catName з вагою $weight кг")
//    println("Кошеня №3 - Рудий \uD83D\uDC06 з вагою 8.2 кг віком 6 років")
}
