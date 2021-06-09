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
        for (element in b) {
            currFindNumber = a.indexOf(element, 0, true)
            if (currFindNumber <= lastFindNumber) {
                return ANSWER_NO
            }
            lastFindNumber=currFindNumber
        }
        return ANSWER_YES
    }

    companion object{
        const val ANSWER_YES="YES"
        const val ANSWER_NO="NO"
    }
}
