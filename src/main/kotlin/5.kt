import java.io.File
class Five{
    /*fun run() { //part 1
        var highestId=0
        File("src/main/resources/5.txt").forEachLine {
            var rMin = 0
            var rMax = 127
            var cMin=0
            var cMax=7
            it.forEach {c->
                when (c) {
                    'B' -> rMin+=(rMax-rMin)/2+1
                    'F' -> rMax-=(rMax-rMin)/2+1
                    'R' -> cMin+=(cMax-cMin)/2+1
                    else -> cMax-=(cMax-cMin)/2+1
                }
            }
            val id=rMin*8+cMin
            if(id>highestId)
                highestId=id
        }
        println(highestId)
    }*/
    fun run() { //part 2
        var highestId=0
        var listOfIds = mutableListOf<Int>()
        File("src/main/resources/5.txt").forEachLine {
            var rMin = 0
            var rMax = 127
            var cMin=0
            var cMax=7
            it.forEach {c->
                when (c) {
                    'B' -> rMin+=(rMax-rMin)/2+1
                    'F' -> rMax-=(rMax-rMin)/2+1
                    'R' -> cMin+=(cMax-cMin)/2+1
                    else -> cMax-=(cMax-cMin)/2+1
                }
            }
            val id=rMin*8+cMin
            listOfIds.add(id);
            if(id>highestId)
                highestId=id
        }
        listOfIds.sort()
        var lastId=0
        var myID=0
        listOfIds.forEach{
            if(it!=lastId+1)
                myID=lastId+1
            if(it==myID+1) {
                println(myID)
                return
            }
            lastId=it
        }
    }
}

