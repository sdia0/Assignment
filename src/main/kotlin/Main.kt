fun Int.pow(n: Int): Int {
    var result = this
    repeat(n - 1) {
        result *= this
    }
    return result
}

fun Int.powWithLambda(n: Int, f: (Int, Int) -> Int): Int {
    return f(this, n)
}

sealed class DataType {
    class DoubleType(val value: Double): DataType() {
        override fun toString(): String {
            return value.toString()
        }
    }
    class UnitType(): DataType()
}

fun <T> T.displayTypeInfo() {
    when (this) {
        is String -> println("Это String")
        is Int -> println("Это Int")
        is DataType.UnitType -> println("Это Unit")
        is DataType.DoubleType -> println("Это DoubleType со значением $this")
        else -> println("Тип у $this неизвестен")
    }
}

fun main() {
    println(3.pow(4))

    println(3.powWithLambda(4) { a, n ->
        var result = a
        repeat(n - 1) {
            result *= a
        }
        result
    })

    "".displayTypeInfo()
    1.displayTypeInfo()
    1.0.displayTypeInfo()

    DataType.UnitType().displayTypeInfo()
    DataType.DoubleType(1.0).displayTypeInfo()
}
