import java.io.File
class Two{
    /*fun run() {//part 1
        var tot=0;
        File("src/main/resources/2.txt").forEachLine {
            println(it)
            val min = it.split("-")[0].toInt()
            val max = it.split(" ")[0].split("-")[1].toInt()
            val letter = it.split(" ")[1][0]
            val pass = it.split(" ")[2]
            val count = pass.filter { x-> x==letter }.count()
            if(count in min..max){
                tot++
            }
        }
        println(tot)
    }*/

    /*fun run() {//part 2
        var tot=0;
        File("src/main/resources/2.txt").forEachLine {
            println(it)
            val splitten = it.split(" ")
            val min = splitten[0].split("-")[0].toInt()
            val max = splitten[0].split("-")[1].toInt()
            val letter = splitten[1][0]
            val pass = splitten[2]
            val a=pass[min-1];
            val b=pass[max-1]
            if((a==letter || b==letter) && (a!=b))
                tot++
        }
        println(tot)
    }*/

}

