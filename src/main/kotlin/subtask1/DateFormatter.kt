package subtask1

import java.text.ParseException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


fun main() {
    val dateFormatter = DateFormatter()
    print(
        dateFormatter.toTextDay("35", "02", "2021")
    )
}

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        //throw NotImplementedError("Not implemented")
        if (isDateExist(day, month, year)) {
            return "$day ${getMonthName(month)}, ${getDayNameOfWeek(day, month, year)}"
        } else {
            return "Такого дня не существует"
        }
    }

    @Throws(ParseException::class)
    fun isDateExist(day: String, month: String, year: String): Boolean {
        val dateStringForParse =
            addZerroLeft(day, 2) + addZerroLeft(month, 2) + addZerroLeft(year, 4)
        val formatter = DateTimeFormatter.ofPattern("ddMMyyyy")
        try {
            val date = formatter.parse(dateStringForParse)
            return dateStringForParse.equals(formatter.format(date))
        } catch (e: DateTimeParseException) {
            return false
        }
    }

    fun addZerroLeft(value: String, length: Int): String {
        return "0".repeat(length - value.length) + value
    }

    fun getMonthName(mothNumber: String): String {
        return ARR_MONTH_NAME[mothNumber.toInt() - 1]
    }

    fun getDayNameOfWeek(day: String, month: String, year: String):String {
        val dateStringForParse =
            addZerroLeft(day, 2) + addZerroLeft(month, 2) + addZerroLeft(year, 4)
        val formatter = DateTimeFormatter.ofPattern("ddMMyyyy")
        val date = LocalDate.parse(dateStringForParse, formatter)
        return ARR_DAY_NAME[ date.dayOfWeek.value - 1]
    }


    companion object {
        val ARR_MONTH_NAME = arrayOf(
            "января",
            "февраля",
            "марта",
            "апреля",
            "мая",
            "июня",
            "июля",
            "августа",
            "сентября",
            "октября",
            "ноября",
            "декабря"
        )
        val ARR_DAY_NAME = arrayOf(
            "понедельник",
            "вторник",
            "среда",
            "четверг",
            "пятница",
            "суббота",
            "воскресенье"
        )
    }
}
