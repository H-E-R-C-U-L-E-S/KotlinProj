import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

/*
შექმენით კლასი Point რომელსაც ექნება 2 ველი, შესაბამისად x და y კოორდინატის შესანახად 💾
(საწყისი მნიშვნელობები გადმოაწოდეთ კონსტრუქტორში).
კლასს უნდა ჰქონდეს შემდეგი ფუნქციონალი: 🧑🏼‍💻
toString მეთოდი - რომელიც უნდა აბრუნებდეს კლასის ველებს String ფორმატში 👈
equals მეთოდი - უნდა იძლეოდეს საშუალებას შევადაროთ 2 point კლასის ობიექტი 🤗
მეთოდი, რომელებიც სათავის მიმართ სიმეტრიულად გადაიტანს წერტილს  👌🏻
მეთოდი, რომელსაც ჩაეწოდება სხვა Point კლასის ობიექტი და დააბრუნებს მანძილს ამ ორ წერტილს შორის 🗺️ (optional)
 */

fun main(args: Array<String>) {

    //წერტილებს საწყის კოორდინატებს გადავცემთ კონსტრუქტორში
    var point1 = Point(5.1,-3.23);
    var point2 = Point(2.2,1.32);
    var point3 = Point(2.2,1.32);

    //წერტილების საწყისი კოორდინატები იბეჭდება toString -ის გამოყენებით
    println(point1.toString())
    println(point2.toString())
    println(point3.toString())

    //equals(==) -ის გამოყენებით შეგვიძლია შევადაროთ 2 Point კლასის ობიექტი
    println("______")
    println(point1.equals(point2))
    println(point2 == point3)

    /*
    ფუნქცია moveSymmetrically -ს უნდა გადასცეთ x,y ან o
    x - აბცისათა ღერძის მიმართ
    y - ორდინატთა ღერძი მიმართ
    o - სათავის მიმართ
    */

    //სიმეტრიულად გადაგვაქვს წერტილები
    //თუ axis არ არის არც x და არც y მაშინ ფუნქციას წერტილი გადააქვს სათავის მიმართ სიმეტრიულად
    println("______")
    point1.moveSymmetrically("O")
    point2.moveSymmetrically("X")
    point3.moveSymmetrically("Y")

    //წერტილები სიმეტრიულად გადატანის შმდეგ
    println(point1.toString())
    println(point2.toString())
    println(point3.toString())

    // calculateDistance ფუნქცია გამოთვლის და აბრუნებს ორ წერტილს შორის მანძილს
    println("______")
    println("Distance: " + point1.calculateDistance(point2))

    //მეორე დავალება Main2 ფაილშია!

}


class Point(x : Double , y : Double ) {

    //წერტილის კოორდინატები
    private var xCoordinate : Double = x
    private var yCoordinate : Double = y

    override fun toString(): String {
        return "Coordinates: X($xCoordinate) Y($yCoordinate)"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Point && other.xCoordinate == xCoordinate && other.yCoordinate == yCoordinate){
            return true
        }
        return false
    }

    //ფუნქცია წერტილის სიმეტრიული გადაადგილებისთვის
    fun moveSymmetrically(axis: String){
        //თუ axis არ არის არც x და არც y ფუნქციას წერტილი გადააქვს სათავის მიმართ სიმეტრიულად
        when (axis) {
            "X" -> {
                // x ღერძის მიმართ y იცვლის ნიშანს
                yCoordinate *= -1
            }
            "Y" -> {
                // y ღერძის მიმართ x იცვლის ნიშანს
                xCoordinate *= -1
            }
            else -> {
                // o სათვის მიმართ x და y იცვლის ნიშნებს
                xCoordinate *= -1
                yCoordinate *= -1
            }
        }
    }

    //წერტილებს შორის მანძილის გამოსათვლელი ფუნქცია
    fun calculateDistance(p: Point): Double {
        // distance = √( (x2 – x1)² + (y2 – y1)² ) -ფორმულით ვითვლით დისტანციას და ვამრგვალებთ მეათედზე
        return (sqrt(((p.xCoordinate - xCoordinate).pow(2.0)) + (p.yCoordinate - yCoordinate).pow(2.0)) * 10.0).roundToInt() / 10.00
    }

    //როდესაც equal -ს ვაოუვერრაიდებთ ჰეშკოდის ოუვერაიდიც საჭიროა
    override fun hashCode(): Int {
        var result = xCoordinate.hashCode()
        result = 31 * result + yCoordinate.hashCode()
        return result
    }
}

//მეორე დავალება Main2 ფაილშია!

