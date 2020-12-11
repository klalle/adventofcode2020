import java.io.File

class Eleven{
    fun run() { //Part 1

        var curList = File("src/main/resources/11.txt").readLines().map{it.toMutableList()}.toMutableList()
        var nextList = curList.map { it.toMutableList() }.toMutableList()
        nextList[0][0]='k'
        val maxRow=curList.size
        val maxCol=curList[0].size
        var i=0
        var changed=true
        while (changed) {
            changed=false
            for (r in 0 until maxRow) {
                for (c in 0 until maxCol) {
                    if (curList[r][c] == '.')
                        continue
                    var antalUpptagna = 0
                    //var antalLediga = 0
                    for (rr in r - 1..r + 1) {//box runt r,c == rr,cc
                        if (rr < 0 || rr == maxRow)
                            continue
                        for (cc in c - 1..c + 1) {
                            if (cc < 0 || (rr == r && cc == c) || cc == maxCol)
                                continue
                            if (curList[rr][cc] == '#')
                                antalUpptagna++
                            /*else if (input[rr][cc] == 'L' || (input[rr][cc] == '#' && changedIndexesOnPrevRow.contains(cc)))
                                antalLediga++*/
                        }
                    }
                    if (curList[r][c] == 'L' && antalUpptagna == 0) {
                        nextList[r][c] = '#'
                        changed=true
                    }
                    if (curList[r][c] == '#' && antalUpptagna >= 4) {
                        nextList[r][c] = 'L'
                        changed=true
                    }
                }
             }
            curList=nextList.map { it.toMutableList() }.toMutableList()
            i++
        }
        println("antal: $i L:${curList.sumOf{it.count {c->c=='#'}}}")
    }

    fun run2() { //Part 2

    }

}

