
/*
ლექციაზე გაკეთებულ Fraction კლასს დაუმატეთ 3 მეთოდი : 🧑‍🏫👩‍🏫
წილადის შეკვეცის 👇
შეკრების ან გამოკლების * 💪
გაყოფის ან გამრავლების * 🧠

* მეთოდმა პარამეტრად უნდა მიიიღოს Fraction კლასის ობიექტი 👀 და ოპერაციის შემდეგ უნდა დააბრუნოს ახალი წილადი. 🐸 🐷
*/

fun main() {

    //წილადები
    val fraction1 = Fraction(18,36)
    val fraction2 = Fraction(3,9)

    //მიმატება
    println(fraction1 + 3)
    println(fraction1 + fraction2)
    println("______")

    //გამოკლება
    println(fraction1 - 6)
    println(fraction1 - fraction2)
    println("______")

    //გამრავლება
    println(fraction1 * 4)
    println(fraction1 * fraction2)
    println("______")

    //გაყოფა
    println(fraction1 / 3)
    println(fraction1 / fraction2)
    println("______")

    //შეკვეცა
    println(truncateFraction(fraction1))
    println(truncateFraction(fraction2))

}

class Fraction(numerator: Int, denominator: Int) {

    //მნიშვნელი & მრიცხველი
    var n = numerator
    var d = denominator

    override fun toString(): String {
        return "$n / $d"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Fraction && other.n * d == other.d * n){
            return true
        }
        return false
    }

    //წილადების მიმატება (აბრუნებს შეკვეცილ პასუხს)
    operator fun plus(other: Fraction): Fraction {

        return if (d == other.d){
            truncateFraction(Fraction(n + other.n, d))
        } else{
            return truncateFraction(Fraction(n * other.d + other.n * d,d * other.d))
        }

    }

    //წილადის და რიცხვის მიმატება (აბრუნებს შეკვეცილ პასუხს)
    operator fun plus(num: Int): Fraction {
        return truncateFraction(Fraction(n + d * num,d))
    }

    //წილადების გამოკლება (აბრუნებს შეკვეცილ პასუხს)
    operator fun minus(other: Fraction): Fraction {
        return if (d == other.d){
            truncateFraction(Fraction(n - other.n, d))
        } else{
            return truncateFraction(Fraction(n * other.d - other.n * d,d * other.d))
        }
    }

    //წილადის და რიცხვის გამოკლება
    operator fun minus(num: Int): Fraction {
        return truncateFraction(Fraction(n - num * d, d))
    }

    //წილადის წილადზე გამრავლება (აბრუნებს შეკვეცილ პასუხს)
    operator fun times(other: Fraction): Fraction {
        return truncateFraction(Fraction(n * other.n,d * other.d))
    }

    //წილადის რიცხვზე გამრავლება (აბრუნებს შეკვეცილ პასუხს)
    operator fun times(num: Int): Fraction {
        return truncateFraction(Fraction(n * num,d))
    }

    //წილადის წილადზე გაყოფა (აბრუნებს შეკვეცილ პასუხს)
    //*შებრუნებულზე გამრავლება
    operator fun div(other: Fraction): Fraction{
        val d = other * Fraction(d,n)
        return truncateFraction(Fraction(d.d,d.n))
    }

    //წილადის რიცხვზე გაყოფა (აბრუნებს შეკვეცილ პასუხს)
    operator fun div(num: Int): Fraction{
        return truncateFraction(Fraction(n,num * d))
    }

    //
    override fun hashCode(): Int {
        var result = n
        result = 31 * result + d
        return result
    }
}

//truncateFraction არის ფუნქცია რომელიც კვეცავს წილადს
fun truncateFraction(fraction: Fraction): Fraction{
    val k = gcd(fraction.n,fraction.d)
    return Fraction(fraction.n / k,fraction.d / k)
}

//gcd იგივე უსგ, ფუნქცია პოულობს 2 რიცხვის უდიდეს საერთო გამყოფს
//numerator - a
fun gcd(numerator: Int,denominator: Int): Int {

    return if (denominator == 0){
        numerator
    }
    else{
        gcd(denominator, numerator % denominator)
    }

}
