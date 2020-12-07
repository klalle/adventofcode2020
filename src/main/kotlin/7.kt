import java.io.File
class Seven{
    var totNrOfBags=0
    fun run() {
        FindChildBags("shiny gold",1)
        //listOfBags.sort()

        println(totNrOfBags)//58175
    }

    fun FindChildBags(bag: String, antalParent: Int)
    {
        File("src/main/resources/7.txt").forEachLine {
            val regexMatch = """$bag bags contain (\d .*)*.""".toRegex().find(it)
            if(regexMatch!=null && regexMatch.groupValues[1]!=null) {
                val childs = regexMatch.groupValues[1].split(", ")
                childs.forEach{b->
                    if(b!=""){
                        val antal = b.split(" ")[0].toInt()
                        val ba = b.replace(" bags", "").replace(" bag", "").replace("""\d """.toRegex(),"")
                        totNrOfBags+=antal*antalParent
                        FindChildBags(ba,antalParent*antal)
                    }
                }
            }

        }
    }



    /*var listOfBags = mutableListOf<String>()

    fun run() {
        FindParentBag("shiny gold")
        listOfBags.sort()

        println(listOfBags.size) //!47 !46 !48
    }

    fun FindParentBag(bag: String)
    {
        File("src/main/resources/7.txt").forEachLine {
            val regexMatch = """(.*) bags contain (\d .*)*\d $bag""".toRegex().find(it)
            if(regexMatch != null) {
                val parent = regexMatch.groupValues[1]
                if(!listOfBags.contains(parent))
                    listOfBags.add(parent)
                FindParentBag(parent)
            }

        }
    }*/
}

