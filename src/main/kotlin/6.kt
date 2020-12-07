import java.io.File
class Six{
    /*fun run() {//part 1
        var listOfChars = mutableListOf<Char>()
        var tot=0
        File("src/main/resources/6.txt").forEachLine {
            it.forEach {c->
                if(!listOfChars.contains(c))
                    listOfChars.add(c)
            }
            if(it.isEmpty()) {
                tot += listOfChars.size
                listOfChars.clear()
            }
        }
        tot += listOfChars.size //add last group (File is trimming empty lines)
        println(tot) //6430
    }*/
    fun run() {//part 2
        var listOfChars = mutableListOf<Char>()
        var tot=0
        var first=true
        File("src/main/resources/6.txt").forEachLine {
            if (first)
                it.forEach {x->listOfChars.add(x)}

            if(it.isEmpty()) {
                tot += listOfChars.size
                listOfChars.clear()
                first=true
            } else{
                var i=0;
                while(i<listOfChars.size){
                    if(!it.contains(listOfChars[i]))
                        listOfChars.removeAt(i)
                    else
                        i++
                }
                first = false
            }
        }
        tot += listOfChars.size
        println(tot) //3125

    }
}

