package Calendar

import ReadFromFile

class DayOne {

    var fileData = ReadFromFile.readFromFile("C:\\Users\\max-t\\Desktop\\AdeventOfCode\\src\\main\\resources\\taskOne.txt")

    fun partOne(){
        var number:Int = fileData[0].toInt()
        var result:Int = 0

        for (i in 1 until fileData.size){
            if (number < fileData[i].toInt()){
                result++
            }
            number = fileData[i].toInt()
        }
        println("Part one $result")
    }

    fun partTwo(){
        var result:Int = 0

        for (i in 3 until fileData.size){
            if(fileData[i-3].toInt() < fileData[i].toInt()){
                result++
            }
        }
        println("Part two $result")
    }

}