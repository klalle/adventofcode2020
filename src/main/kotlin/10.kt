import java.io.File

class Ten{
    fun run() { //Part 1
        var lastVal=0L
        var diffOne=0
        var diffThree=0
        File("src/main/resources/10.txt").readLines()
            .map{it.toLong()}.sorted()
            .forEach{
                if(it-lastVal==1L)
                    diffOne++
                else if(it-lastVal==3L)
                    diffThree++
                lastVal=it
            }
        diffThree++ //last
        println("1:$diffOne 3:$diffThree mult: ${diffOne*diffThree}")
    }

    fun run2() { //Part 2
        val input = File("src/main/resources/10.txt").readLines().map{it.toLong()}.sorted().distinct()
        var nrOfSkippedAtIndex = MutableList(input.size){0L}

        var i=0
        var nrOfCombinations=1L

        //eftersom vi börjar på i-1 egentligen = 0
        if (input[2] == 3L) {
            val rowsToAdd=(nrOfCombinations-nrOfSkippedAtIndex[i])*2
            nrOfCombinations += rowsToAdd
            nrOfSkippedAtIndex[0]+=rowsToAdd
            nrOfSkippedAtIndex[1]+=rowsToAdd/2
        }else if (input[1]==3L) {
            val rowsToAdd=nrOfCombinations-nrOfSkippedAtIndex[i]
            nrOfCombinations += rowsToAdd
            nrOfSkippedAtIndex[0]+=rowsToAdd
        }

        while(i<input.size){
            if (i + 3 < input.size && input[i + 3] == input[i] + 3) {
                val rowsToAdd=(nrOfCombinations-nrOfSkippedAtIndex[i])*2
                nrOfCombinations += rowsToAdd
                nrOfSkippedAtIndex[i+1]+=rowsToAdd
                nrOfSkippedAtIndex[i+2]+=rowsToAdd/2
            }else if (i + 2 < input.size && input[i + 2] <= input[i] + 3) {
                val rowsToAdd=nrOfCombinations-nrOfSkippedAtIndex[i]
                nrOfCombinations += rowsToAdd
                nrOfSkippedAtIndex[i+1]+=rowsToAdd
            }
            i++
        }
        val b = 19208-10976 //8232
        println("$nrOfCombinations") //296196766695424
    }

}

