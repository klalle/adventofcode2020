import java.io.File
import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.atan
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.math.sqrt

class Twelve{
    fun run() { //Part 1
        var north=0
        var east=0
        var x=1 //east
        var y=0 //north
        var direction=90
        File("src/main/resources/12.txt").readLines().forEach{
            var intPart = it.substring(1).toInt()
            when (it[0]){
                'L' -> {
                    direction-=intPart
                    if(direction<0)
                        direction+=360
                }
                'R' -> {
                    direction+=intPart
                    if(direction>=360)
                        direction-=360
                }
                'E' -> {
                    east+=intPart
                }
                'W' -> {
                    east-=intPart
                }
                'N' -> {
                    north+=intPart
                }
                'S' -> {
                    north-=intPart
                }
                'F' -> {
                    when(direction){
                        0 -> { north+=intPart }
                        90 -> { east +=intPart }
                        180 -> { north-=intPart }
                        270 -> { east-=intPart }
                    }
                }
            }
        }
        println("${abs(north)+abs(east)}") //!1489
    }

    fun run2() { //Part 2
        var north=0
        var east=0
        var wpN=1
        var wpE=10
        var direction=0
        File("src/main/resources/12.txt").readLines().forEach{
            var intPart = it.substring(1).toInt()
            when (it[0]){
                'L' -> {
                    direction-=intPart
                    if(direction<0)
                        direction+=360
                    val len = sqrt(wpE.toDouble().pow(2.0) + wpN.toDouble().pow(2.0))
                    val curAngle = atan2(wpN.toDouble(), wpE.toDouble())
                    wpE = (len*cos(curAngle+intPart * Math.PI / 180.0)).roundToInt()
                    wpN = (len*sin(curAngle+intPart * Math.PI / 180.0)).roundToInt()
                    println("")
                }
                'R' -> {
                    direction+=intPart
                    if(direction>=360)
                        direction-=360
                    val len = sqrt(wpE.toDouble().pow(2.0) + wpN.toDouble().pow(2.0))
                    val curAngle = atan2(wpN.toDouble(), wpE.toDouble())
                    wpE = (len*cos(curAngle-intPart * Math.PI / 180.0)).roundToInt()
                    wpN = (len*sin(curAngle-intPart * Math.PI / 180.0)).roundToInt()
                }
                'E' -> {
                    wpE+=intPart
                }
                'W' -> {
                    wpE-=intPart
                }
                'N' -> {
                    wpN+=intPart
                }
                'S' -> {
                    wpN-=intPart
                }
                'F' -> {
                    north+= wpN*intPart
                    east+=wpE*intPart
                }
            }
        }
        println("${abs(north)+abs(east)}") //!121257 !23873
    }
}

