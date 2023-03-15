package com.diacht.ktest.juicefactory

import com.diacht.ktest.Product
import com.diacht.ktest.Receipt
import com.diacht.ktest.SUGAR
import com.diacht.ktest.WATER
import java.util.concurrent.TimeUnit

object OrangeJuiceReceipt : Receipt(
    products = listOf(
        Product(type = ORANGE, count = 1200),
        Product(type = WATER, count = 250),
        Product(type = SUGAR, count = 25),
    ),
    time = 8,
    timeUnit = TimeUnit.SECONDS,
    outProductType = ORANGE_JUICE,
    price = 50,
)