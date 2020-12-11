import java.io.File
class Nine{
    private val preambleLen=25
    fun run() { //Part 1
        val input = File("src/main/resources/9.txt").readLines().map{it.toLong()}
        var preambleList= mutableListOf<Long>()
        (0..preambleLen).map{preambleList.add(input[it])}
        var i = preambleLen
        while(i<input.size)
        {
            if(!One().run(preambleList,input[i])) {
                println(input[i]) //466456641
                return
            }
            preambleList.removeAt(0)
            preambleList.add(input[i])
            i++
        }
    }

    fun run2() { //Part 2
        val input = File("src/main/resources/9.txt").readLines().map{it.toLong()}
        var i = 0
        val target = 466456641L
        while(i<input.size)
        {
            var j=i
            var sum=0L
            while(j<input.size && sum<466456641)
                sum+=input[j++]

            if(sum==target)
            {
                val min = (i..j).map{input[it]}.minOrNull()
                val max = (i..j).map{input[it]}.maxOrNull()
                println("Found! start: $i, end: $j, sum: ${min!!+max!!}") //55732936
                return
            }

            i++
        }
    }

}

