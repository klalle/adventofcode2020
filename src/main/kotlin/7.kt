import java.io.File
class Seven{
    var listOfBags = mutableListOf<String>()
    private val input = File("src/main/resources/7.txt").readLines()
    fun run() { //Part 1
        findParentBag("shiny gold")
        listOfBags.sort()
        println(listOfBags.size)
    }

    private fun findParentBag(bag: String)
    {
        val regex = """(.*) bags contain (\d .*)*\d $bag""".toRegex()
        input.forEach() {
            val regexMatch = regex.find(it)
            if(regexMatch != null) {
                val parent = regexMatch.groupValues[1]
                if(!listOfBags.contains(parent)) {
                    listOfBags.add(parent)
                    findParentBag(parent)
                }
            }
        }
    }

    var totNrOfBags=0
    fun run2() { //Part 2
        findChildBags("shiny gold",1)
        println(totNrOfBags)//58175
    }

    private fun findChildBags(bag: String, antalParent: Int)
    {
        val regex="""$bag bags contain (\d .*)*.""".toRegex()
        input.forEach() {
            val regexMatch = regex.find(it)
            if(regexMatch!=null && regexMatch.groupValues[1]!=null) {
                regexMatch.groupValues[1].split(", ").forEach{ b->
                    if(b!=""){
                        val antal = b.split(" ")[0].toInt()
                        val ba = b.replace(" bags", "").replace(" bag", "").replace("""\d """.toRegex(),"")
                        totNrOfBags+=antal*antalParent
                        findChildBags(ba,antalParent*antal)
                    }
                }
            }
        }
    }
}

