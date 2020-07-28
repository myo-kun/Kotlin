class Rational(n: Int, d: Int){
    // 分母が0にならないように
    init {
        require(d != 0, {"denominator must not be null"})
    }
    private val g by lazy { gcd(Math.abs(n), Math.abs(d)) }
    val numerator: Int by lazy { n / g }
    val denominator: Int by lazy { d / g }
    // 足し算を定義
    operator fun plus(that: Rational): Rational =
            Rational(
                    numerator * that.denominator + that.numerator * denominator,
                    denominator * that.denominator
            )
    // Intに拡張
    operator fun plus(n: Int): Rational =
            Rational(numerator + n * denominator, denominator)
    override fun toString(): String = "${numerator}/${denominator}"
    tailrec private fun gcd(a: Int, b: Int): Int =
        if (b == 0) a
        else gcd(b, a % b)
}

operator fun Int.plus(r: Rational): Rational = r + this