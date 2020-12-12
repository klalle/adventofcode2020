import java.io.File
import kotlin.math.abs

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
}

