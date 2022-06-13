package Calendar

import java.math.BigInteger
import java.util.Arrays
import javax.xml.stream.events.Characters

class DayThree {
    private var fileData = ReadFromFile.readFromFile("C:\\Users\\max-t\\Desktop\\AdeventOfCode\\src\\main\\resources\\taskThree.txt")

    fun partOne(){
        var result:Int = 0
        var mostCommonBit :String = ""
        var mostLeastCommonBit :String = ""
        var countMostCommonBit = Array<Int>(fileData[0].length){0}
        for (element in fileData){
            for (i in 0 until element.length){
                if (element[i].equals('1')){
                    countMostCommonBit[i]++
                }
                else{
                    countMostCommonBit[i]--
                }
            }
        }
        for (i in 0 until  countMostCommonBit.size){
            if (countMostCommonBit[i] > 0){
                mostCommonBit += '1'
                mostLeastCommonBit += '0'
            }
            else{
                mostLeastCommonBit += '1'
                mostCommonBit += '0'
            }
        }
        result = mostCommonBit.toInt(2) * mostLeastCommonBit.toInt(2)
        println("Part one $result")
    }

    fun partTwo(){
        var result:Int = 0
        var dataOxygen = fileData
        var dataCarbon = fileData
        var iterator: Int = 0

        while (1 < dataOxygen.size){
            var numberOfOnes:Int = dataOxygen.count { it[iterator] == '1' }
            var numberOfZeros:Int = dataOxygen.count { it[iterator] == '0' }
            if (numberOfOnes >= numberOfZeros){
                dataOxygen = dataOxygen.stream().filter{ it[iterator] == '1' }.toList()
            }
            else{
                dataOxygen = dataOxygen.stream().filter{ it[iterator] == '0' }.toList()
            }
            iterator++
        }

        iterator = 0

        while (1 < dataCarbon.size){
            var numberOfOnes:Int = dataCarbon.count { it[iterator] == '1' }
            var numberOfZeros:Int = dataCarbon.count { it[iterator] == '0' }
            if (numberOfOnes < numberOfZeros){
                dataCarbon = dataCarbon.stream().filter{ it[iterator] == '1' }.toList()
            }
            else{
                dataCarbon = dataCarbon.stream().filter{ it[iterator] == '0' }.toList()
            }
            iterator++
        }

        result = dataOxygen[0].toInt(2) * dataCarbon[0].toInt(2)

        println("Part two $result")
    }
}