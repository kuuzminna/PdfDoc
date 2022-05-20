open class Fio {
    var firstName = ""
    var lastName = ""
    var patronymic = ""

    fun settingFirstName(gender: String) {
        when (gender) {
            "МУЖ" -> firstName = firstNameMale.random()
            "ЖЕН" -> firstName = firstNameFemale.random()
        }
    }

    fun settingLastName(gender: String) {
        when (gender) {
            "МУЖ" -> lastName = lastNameMale.random()
            "ЖЕН" -> lastName = lastNameFemale.random()
        }
    }

    fun settingPatronymic(gender: String) {
        when (gender) {
            "МУЖ" -> patronymic = patronymicMale.random()
            "ЖЕН" -> patronymic = patronymicFemale.random()
        }
    }
}

val firstNameMale = arrayOf("Костя", "Антон", "Ярослав", "Коля",
        "Паша")
val lastNameMale = arrayOf("Соловьев", "Малыгин", "Мальков", "Семкин",
        "Хоткин")
val patronymicMale = arrayOf("Тимофеевич", "Егорович", "Владиславович", "Николаевич",
        "Робертович")

val firstNameFemale = arrayOf("Алина", "Катя", "Соня", "Саша",
        "Настя")
val lastNameFemale = arrayOf("Смиронова", "Горева", "Миронова", "Илюхина",
    "Кошелева")
val patronymicFemale = arrayOf("Александрова", "Олеговна", "Филипповна", "Алексеевна",
        "Яковлевна")

