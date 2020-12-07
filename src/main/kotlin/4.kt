import java.io.File
class Four{
    /* fun run() {//part 1

        var byr =false//(Birth Year)
        var iyr =false//(Issue Year)
        var eyr =false//(Expiration Year)
        var hgt =false//(Height)
        var hcl =false//(Hair Color)
        var ecl =false//(Eye Color)
        var pid =false//(Passport ID)
        var cid =false//(Country ID)
        var countValid=0
        File("src/main/resources/4.txt").forEachLine {
            if(it.contains("byr:"))
                byr = true
            if(it.contains("iyr"))
                iyr=true
            if(it.contains("eyr"))
                eyr=true
            if(it.contains("hgt"))
                hgt=true
            if(it.contains("hcl"))
                hcl=true
            if(it.contains("ecl"))
                ecl=true
            if(it.contains("pid"))
                pid=true
            if(it.contains("cid"))
                cid=true
            if(it.isEmpty()){
                if((byr && iyr && eyr && hgt && hcl && ecl && pid))
                    countValid++
                byr =false
                iyr =false
                eyr =false
                hgt =false
                hcl =false
                ecl =false
                pid =false
                cid =false
            }
        }
        println(countValid)
    }*/
    fun run() { //part 2
        var byr =false//(Birth Year)
        var iyr =false//(Issue Year)
        var eyr =false//(Expiration Year)
        var hgt =false//(Height)
        var hcl =false//(Hair Color)
        var ecl =false//(Eye Color)
        var pid =false//(Passport ID)
        var cid =false//(Country ID)
        var countValid=0
        File("src/main/resources/4.txt").forEachLine {
            if(it.contains("byr:")) {
                val regexMatch = """byr:(\d{4})\b""".toRegex().find((it))
                if(regexMatch!!.groupValues[1].toInt() in 1920..2002)
                    byr = true
            }
            if(it.contains("iyr:")){
                val regexMatch = """iyr:(\d{4})\b""".toRegex().find((it))
                if(regexMatch!!.groupValues[1].toInt() in 2010..2020)
                    iyr=true
            }
            if(it.contains("eyr:")) {
                val regexMatch = """eyr:(\d{4})\b""".toRegex().find((it))
                if(regexMatch!!.groupValues[1].toInt() in 2020..2030)
                    eyr = true
            }
            if(it.contains("hgt:")) {
                val regexMatch = """hgt:(\d*)(cm)*(in)*\b""".toRegex().find(it)
                if(regexMatch!!.groups.count{x->x!=null}==3) {
                    if ((regexMatch!!.groupValues[2]=="cm" && regexMatch!!.groupValues[1].toInt() in 150..193)
                        || (regexMatch!!.groupValues[3]=="in" && regexMatch!!.groupValues[1].toInt() in 59..76)){
                        hgt = true
                    }
                }
            }
            if(it.contains("hcl:")) {
                val regexMatch = """hcl:#([0-9a-f]{6})\b""".toRegex().find((it))
                if(regexMatch?.groups?.count{x->x!=null}==2)
                    hcl = true
            }
            if(it.contains("ecl:")) {
                val regexMatch = """ecl:(amb|blu|brn|gry|grn|hzl|oth)\b""".toRegex().find((it))
                if(regexMatch?.groups?.count{x->x!=null}==2)
                    ecl = true
            }
            if(it.contains("pid:")) {
                val regexMatch = """pid:(\d{9})\b""".toRegex().find((it))
                if(regexMatch?.groups?.count{x->x!=null}==2)
                    pid = true
            }
            if(it.isEmpty()){
                if((byr && iyr && eyr && hgt && hcl && ecl && pid))
                    countValid++
                byr =false
                iyr =false
                eyr =false
                hgt =false
                hcl =false
                ecl =false
                pid =false
                cid =false
            }
        }
        println(countValid)
    }
}

