package objectbuilder

import kotlin.math.ceil

object NumberBuilder {
    fun Double.roundDownToMultipleOf(base: Double): Double = base * ceil(this / base)
}