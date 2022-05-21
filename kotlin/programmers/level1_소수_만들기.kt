class Solution {
    fun solution(nums: IntArray): Int {
        var result = 0
        val answer = mutableListOf<List<Int>>() // 이중 리스트로 ?C3의 조합을 하나씩 저장
        var arr : List<Int> = nums.toList() // 매개변수의 Array를 List로 변경

        combination(answer, arr, Array<Boolean>(arr.size) { false }, 0,  3)

        for (i in 0 until answer.size) {
            var sum = 0
            for (j in 0 until 3) {
                sum += answer[i][j]
            }
            if(isPrime(sum)) result++
        }
        return result
    } //                             가능한 모든 조합의 리스트     주어진 숫자       선택 여부        시작인덱스   뽑는 숫자 갯수
    private fun <T> combination(answer: MutableList<List<T>>, el: List<T>, ck: Array<Boolean>, start: Int, target: Int) {
        if(target == 0) {
            answer.addAll( listOf(el.filterIndexed { index, t -> ck[index] }) )
        } else {
            for(i in start until el.size) {
                ck[i] = true
                combination(answer, el, ck, i + 1, target - 1)
                ck[i] = false
            }
        }
    }
    private fun isPrime(sum : Int) : Boolean { // 소수 판별 함수
        for (i in 2 until sum) {
            if (sum % i == 0)
                return false
        }
        return true
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    var arr = intArrayOf(1, 2, 7 ,6 ,4)
    var answer = sol.solution(arr)

    print(answer)
}