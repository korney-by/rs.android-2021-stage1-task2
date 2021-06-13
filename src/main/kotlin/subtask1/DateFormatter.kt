package subtask1

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


fun main() {
    val dateFormatter = DateFormatter()
    print(
        dateFormatter.toTextDay("14", "2", "2020")
    )
}

class DateFormatter {
    private lateinit var dateStringForParse: String
    private lateinit var date: Date

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        //throw NotImplementedError("Not implemented")
        dateStringForParse = "$day,$month,$year"

        return if (isDateExist0()) {
            getShowDate()
        } else {
            "Такого дня не существует"
        }
    }

    @Throws(ParseException::class)
    fun isDateExist0(): Boolean {
        val formatter = SimpleDateFormat("d,M,y")
        return try {
            formatter.isLenient = false
            date = formatter.parse(dateStringForParse)
            true
        } catch (e: ParseException) {
            false
        }
    }

    private fun getShowDate(): String {
        val formatter = SimpleDateFormat("d MMMM, EEEE", Locale("ru", "RU"))
        return formatter.format(date)
    }
}
