import java.util.Date

class RandomPerson {
    var name: Fio = Fio()
    var gender = if ((0..1).random() == 0) "МУЖ" else "ЖЕН"
    var dataOfBirth: DataOfBirth = DataOfBirth()
    var residentialAddress: FullAddress = FullAddress()
    var placeOfBirth: Town = Town()

    fun create() {
        name.settingFirstName(gender)
        name.settingLastName(gender)
        name.settingPatronymic(gender)
    }

    fun gettingAge(dataOfBirth: DataOfBirth) : Int {
        val now = Date()
        val nowMonth: Int = now.month + 1
        val nowYear: Int = now.year + 1900
        var age = nowYear - dataOfBirth.year

        if (dataOfBirth.month > nowMonth) {
            age--
        } else if (dataOfBirth.month === nowMonth) {
            val nowDay: Int = now.date
            if (dataOfBirth.day > nowDay) {
                age--
            }
        }
        return age
    }
}