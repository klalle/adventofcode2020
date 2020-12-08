import java.io.File
class Eight{
     var listOfCommandIndex = mutableListOf<Int>()

    /*fun run() { //Part 1
        val input = File("src/main/resources/8.txt").readLines()
        var i = 0
        var acc=0
        while(i<input.size)
        {
            if(listOfCommandIndex.contains(i)) {
                println("Found at index $i, acc: $acc") //1451
                return
            }
            listOfCommandIndex.add(i)

            val strPart = input[i].split(" ")[0];
            val intPart = input[i].split(" ")[1].toInt();
            if(strPart=="acc")
                acc += intPart
            else if(strPart=="jmp")
                i+=intPart-1 //adds one next

            i++
        }
    }*/
    fun run() { //Part 2
        val input = File("src/main/resources/8.txt").readLines()
        var i = 0
        var acc=0
        var changeIndex=input.size-1
        while(i<input.size)
        {
            if(listOfCommandIndex.contains(i)) {
                println("$changeIndex not the one, trying to change next...")
                do{
                    changeIndex--
                } while (changeIndex>0 && input[changeIndex].contains("acc"))
                i=0
                acc=0
                listOfCommandIndex.clear()

            }else {
                listOfCommandIndex.add(i)

                val strPart = input[i].split(" ")[0];
                val intPart = input[i].split(" ")[1].toInt();
                if (strPart == "acc")
                    acc += intPart
                else if ((strPart == "jmp" && i!=changeIndex) || (strPart == "nop" && i==changeIndex))
                    i += intPart - 1 //adds one next

                i++
            }
        } //!1160
        println("Done with changeindex $changeIndex and acc: $acc")

    }


}

