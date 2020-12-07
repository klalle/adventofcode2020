import java.io.File
class Three{
    fun run() {//part 1
        var trees=0;
        var pos = 0
        var first=true
        File("src/main/resources/3.txt").forEachLine {
            if(pos>=it.length)
                pos -= it.length
            if(it[pos]=='#' && !first)
                trees++
            first=false
            pos+=3
        }
        println(trees)
    }

    /*fun run() {//part 2
        var trees=0;
        var pos=0
        var first=true
        var row=0
        File("src/main/resources/3.txt").forEachLine {
            if (row % 2 == 0) {
                if (pos >= it.length)
                    pos -= it.length
                if (it[pos] == '#' && !first)
                    trees++
                first = false
                pos += 1
            }
            row++
        }
        println(trees)
    }*/
}

