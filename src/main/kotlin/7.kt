import java.io.File
class Seven{
    var totNrOfBags=0
    fun run() {
        findChildBags("shiny gold",1)
        println(totNrOfBags)//58175
    }

    fun findChildBags(bag: String, antalParent: Int)
    {
        File("src/main/resources/7.txt").forEachLine {
            val regexMatch = """$bag bags contain (\d .*)*.""".toRegex().find(it)
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



    /*var listOfBags = mutableListOf<String>()

    fun run() {
        findParentBag("shiny gold")
        listOfBags.sort()

        println(listOfBags.size) //!47 !46 !48
    }

    fun findParentBag(bag: String)
    {
        File("src/main/resources/7.txt").forEachLine {
            val regexMatch = """(.*) bags contain (\d .*)*\d $bag""".toRegex().find(it)
            if(regexMatch != null) {
                val parent = regexMatch.groupValues[1]
                if(!listOfBags.contains(parent))
                    listOfBags.add(parent)
                findParentBag(parent)
            }

        }
    }*/
}

