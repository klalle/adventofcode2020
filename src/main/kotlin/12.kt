import java.io.File

class Eleven{
    fun run() { //Part 1
        var curList = File("src/main/resources/11.txt").readLines().map{it.toMutableList()}.toMutableList()

        }
        println("antal: $i L:${curList.sumOf{it.count {c->c=='#'}}}")
    }

   

}

