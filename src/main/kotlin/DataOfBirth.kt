open class DataOfBirth {
    var day: Int = (1..31).random()
    var month: Int = (1..12).random()
    var year: Int = (1950..2021).random()

    fun dataToString(): String {
        var str= ""

        if (day < 10)
            str += "0"
        str += "$day-"
        if (month < 10)
            str += "0"
        str += "$month-$year"
        return str
    }
}