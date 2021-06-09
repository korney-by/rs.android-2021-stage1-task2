package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

fun main() {
    val robotPaphnutiy = Blocks()
//    val blockA = arrayOf(1, "4", 12, "3")
//    print(robotPaphnutiy.getData(blockA, Int::class))

    val date1 = LocalDate.parse("2019-12-31")
    val date2 = LocalDate.parse("1986-04-13")
    val date3 = LocalDate.parse("2019-12-30")
    val blockA = arrayOf(1, "4", date1, 2, "3", date2, date3)
    print(robotPaphnutiy.getData(blockA, LocalDate::class))
}

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        //throw NotImplementedError("Not implemented")
        when (blockB) {
            String::class -> {
                return getStringFromBlockA(blockA)
            }
            Int::class -> {
                return getIntFromBlockA(blockA)
            }
            LocalDate::class -> {
                return getDateFromBlockA(blockA)
            }
        }
        return ""
    }

    private fun getStringFromBlockA(blockA: Array<*>): String {
        var result = ""
        for (e in blockA) {
            if (e is String) {
                result += e
            }
        }
        return result
    }


    private fun getIntFromBlockA(blockA: Array<*>): Int {
        var result = 0
        for (e in blockA) {
            if (e is Int) {
                result += e
            }
        }
        return result
    }

    private fun getDateFromBlockA(blockA: Array<*>): String {
        var result: LocalDate = LocalDate.MIN
        for (e in blockA) {
            if (e is LocalDate && e > result) {
                result = e
            }
        }
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return result.format(formatter)
    }
}