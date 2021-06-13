package subtask2

fun main() {
    val converter = Abbreviation()
    println(converter.abbreviationFromA("dacBd", "ABC"))
    println(converter.abbreviationFromA2("dacBacd", "ABC"))
}

class Abbreviation {

    // TODO: Complete the following function

    fun abbreviationFromA2(a: String, b: String): String {
        var lastPosition = -1
        return if (b.filter {
                lastPosition = a.indexOf(it, lastPosition + 1, true)
                lastPosition >= 0
            }.contains(b)) {
            ANSWER_YES
        } else {
            ANSWER_NO
        }
    }

    fun abbreviationFromA(a: String, b: String): String {
        //throw NotImplementedError("Not implemented")

        var lastFindNumber: Int = -1
        for (element in b) {
            lastFindNumber = a.indexOf(element, lastFindNumber + 1, true)
            if (lastFindNumber == -1) {
                return ANSWER_NO
            }
        }
        return ANSWER_YES
    }

    companion object {
        const val ANSWER_YES = "YES"
        const val ANSWER_NO = "NO"
    }
}
