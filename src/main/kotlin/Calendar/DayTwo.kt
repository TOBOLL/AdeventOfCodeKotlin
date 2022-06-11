package Calendar

class DayTwo {

    var fileData = ReadFromFile.readFromFile("C:\\Users\\max-t\\Desktop\\AdeventOfCode\\src\\main\\resources\\taskTwo.txt")
    private var listOfDirection = mutableListOf<String>()
    private var listOfUnits = mutableListOf<Int>()

    init {
        splitString()
    }

    fun partOne(){
        val result: Int
        var depth: Int = 0
        var horizontal: Int = 0

        for (i in 0 until listOfDirection.size){

            if (listOfDirection[i] == "forward"){
                horizontal += listOfUnits[i]
            }
            else if (listOfDirection[i] == "down"){
                depth += listOfUnits[i]
            }
            else{
                depth -= listOfUnits[i]
            }
        }
        result = depth * horizontal
        println("Part one: $result")
    }

    fun partTwo(){
        val result: Int
        var aim: Int = 0
        var depth: Int = 0
        var horizontal: Int = 0

        for (i in 0 until listOfDirection.size){

            if (listOfDirection[i] == "forward"){
                horizontal += listOfUnits[i]
                depth += aim * listOfUnits[i]
            }
            else if (listOfDirection[i] == "down"){
                aim += listOfUnits[i]
            }
            else{
                aim -= listOfUnits[i]
            }
        }
        result = depth * horizontal
        println("Part two: $result")
    }

    fun splitString(){
        for (line in fileData){
            val temp = line.split(" ")
            listOfDirection.add(temp[0])
            listOfUnits.add(temp[1].toInt())
        }
    }
}