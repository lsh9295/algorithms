class Solution {
    fun solution(a: Int, b: Int): String {
        val day = arrayOf("FRI","SAT","SUN","MON","TUE","WED","THU")
        var sum = 0
        var i = a
        var answer : String
        if (a == 1)
            sum += b - 1
        else
            sum += b - 1
        while (i != 0) {
            when(i) {
                2 -> sum += 31
                3 -> sum += 29
                4 -> sum += 31
                5 -> sum += 30
                6 -> sum += 31
                7 -> sum += 30
                8 -> sum += 31
                9 -> sum += 31
                10 -> sum += 30
                11 -> sum += 31
                12 -> sum += 30
            }
            i--
        }
        answer = day[sum % 7]
        return answer
    }
}