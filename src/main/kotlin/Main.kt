import com.itextpdf.kernel.font.PdfFont
import com.itextpdf.kernel.color.Color
import com.itextpdf.kernel.font.PdfFontFactory
import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Cell
import com.itextpdf.layout.element.Table
import java.nio.file.Paths

fun main(){
	print("Введите n (от 1 до 30): ")
	val n : Int = readLine()!!.toString().toInt()
	if (n !in 1..30) throw Exception("Значение должно быть в пределах от 1 до 30: $n")

	val namePdfFile = "OutputFile.pdf"
	val writer = PdfWriter(namePdfFile)
	val pdfDoc = PdfDocument(writer)
	for (i in 1..n/15+ 1)
		pdfDoc.addNewPage(PageSize.A4.rotate())
	val document = Document(pdfDoc)
	val pointColumnWidths = floatArrayOf(60f, 70f,70f, 60f, 35f, 70f, 70f, 60f, 60f, 60f, 60f, 60f,40f, 30f)
	val table = Table(pointColumnWidths)
	generateTable(table, n)
	document.add(table)
	document.close()

	val workingDirectory = Paths.get("").toAbsolutePath().toString()
	println("Путь к файлу - $workingDirectory/$namePdfFile")
}

const val FONTT = "./src/main/resources/fonts/KyivTypeSans-VarGX.ttf"
val font: PdfFont = PdfFontFactory.createFont(FONTT, "Identity-H", true)

fun generateTable(table: Table, n: Int){
	val headers = arrayOf("Имя", "Фамилия", "Отчество", "Возраст",
		"Пол", "Дата рождения", "Место рождения", "Индекс", "Страна", "Область", "Город", "Улица", "Дом", "Кв")

	for(i in headers.indices)
		table.addCell(Cell().add(headers[i]).setFont(font).setFontSize(12f).setBold().setFontColor(Color.BLUE))
	for (k in 1..n)
	{
		val person = RandomPerson()
		person.create()
		val dataRandomPerson = arrayOf(person.name.firstName, person.name.lastName, person.name.patronymic, person.gettingAge(person.dataOfBirth).toString(),
			person.gender, person.dataOfBirth.dataToString(), person.placeOfBirth.city, person.residentialAddress.index.toString(),
			person.residentialAddress.country, person.residentialAddress.region, person.placeOfBirth.city, person.residentialAddress.street,
			person.residentialAddress.house.toString(), person.residentialAddress.apartment.toString())

		for(j in dataRandomPerson.indices)
			table.addCell(Cell().add(dataRandomPerson[j]).setFont(font).setFontSize(9f))
	}
}
