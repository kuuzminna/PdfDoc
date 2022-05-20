open class FullAddress : Town() {
    var index = (100000..999999).random()
    var country = "Россия"
    var region = regions.random()
    var street = streets.random()
    var house = (1..300).random()
    var apartment = (1..300).random()
}

val streets = arrayOf("Ленина", "Сутырина", "Советская", "Молодежная", "Школьная", "Лесная",
        "Садовая", "Новая", "Набережная", "Заречная", "Зеленая")
val regions = arrayOf("Орловская", "Костромская", "Ростовская", "Магаданская",
        "Пермская", "Белгородская", "Томская", "Тульская", "Тверская", "Тамбовская", "Иркутская")
