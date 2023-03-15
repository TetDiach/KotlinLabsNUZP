var globalOutBuffer : StringBuilder? = null

fun interceptPrintln(sb: StringBuilder) {
    globalOutBuffer = sb
}

fun println(str: String) {
    if (globalOutBuffer != null) {
        globalOutBuffer?.append(str)?.append('\n')
    } else {
        System.out.println(str)
    }
}
