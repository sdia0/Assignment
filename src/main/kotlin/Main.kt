import java.lang.Math.pow
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sin
import kotlin.math.sqrt

class Triangle(_x1: Double, _y1: Double, _x2: Double, _y2: Double, _x3: Double, _y3: Double) {
    private var x1: Double = 0.0
    private var y1: Double = 0.0

    private var x2: Double = 0.0
    private var y2: Double = 0.0

    private var x3: Double = 0.0
    private var y3: Double = 0.0

    init {
        val S: Double = (_x1 * _y2 + _x2 * _y3 + _x3 * _y1 - (_x2 * _y1 + _x3 * _y2 + _x1 * _y3)) * 0.5
        if (S != 0.0) {
            x1 = _x1
            y1 = _y1

            x2 = _x2
            y2 = _y2

            x3 = _x3
            y3 = _y3
        }
        else println("Точки лежат на одной прямой")
    }

    fun print() {
        println("Треугольник с вершинами: ($x1; $y1) ($x2; $y2) ($x3; $y3)")
        println("Сторона1: ${lengthOfSide(x1, y1, x2, y2)}")
        println("Сторона2: ${lengthOfSide(x2, y2, x3, y3)}")
        println("Сторона3: ${lengthOfSide(x3, y3, x1, y1)}")
    }

    private fun lengthOfSide(x1: Double, y1: Double, x2: Double, y2: Double): Double =
        round(sqrt(pow(x2 - x1, 2.0) + pow(y2 - y1, 2.0)) * 100) / 100

    fun perimeter() = println(lengthOfSide(x1, y1, x2, y2) + lengthOfSide(x2, y2, x3, y3) + lengthOfSide(x3, y3, x1, y1))

    fun square() = println(((x1 - x3) * (y2 - y3) - (y1 - y3) * (x2 - x3)) * 0.5)

    fun rotate(angle: Double) {
        val rad = Math.toRadians(angle)
        val centerX = (x1 + x2 + x3) / 3
        val centerY = (y1 + y2 + y3) / 3

        fun rotatePoint(x: Double, y: Double): Pair<Double, Double> {
            val newX = centerX + (x - centerX) * cos(rad) - (y - centerY) * sin(rad)
            val newY = centerY + (x - centerX) * sin(rad) + (y - centerY) * cos(rad)
            return Pair(round(newX), round(newY))
        }

        val (newX1, newY1) = rotatePoint(x1, y1)
        val (newX2, newY2) = rotatePoint(x2, y2)
        val (newX3, newY3) = rotatePoint(x3, y3)

        x1 = newX1; y1 = newY1
        x2 = newX2; y2 = newY2
        x3 = newX3; y3 = newY3

        print()
    }
}

fun main(args: Array<String>){
    val t1 = Triangle(1.0, 2.0, 3.0, -1.0, 5.0, 5.0)
    t1.print()
    t1.perimeter()
    t1.square()
    t1.rotate(90.0)
}
