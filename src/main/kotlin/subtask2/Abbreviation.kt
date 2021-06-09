package subtask2

fun main(){
    val converter = Abbreviation()
    print(converter.abbreviationFromA("daBcd", "ABC"))
}

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String):String {
        //throw NotImplementedError("Not implemented")

        var lastFindNumber: Int = -1
        var currFindNumber: Int
        for (i in 0 until b.length) {
            currFindNumber = a.indexOf(b[i], 0, true)
            if (currFindNumber <= lastFindNumber) {
                return ANSWER_NO
            }
            lastFindNumber=currFindNumber
        }
        return ANSWER_YES
    }

    companion object{
        val ANSWER_YES="YES"
        val ANSWER_NO="NO"
    }
}
