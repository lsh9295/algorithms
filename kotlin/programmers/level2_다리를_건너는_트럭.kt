import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var sec = 0
        var queue: Queue<Int> = LinkedList() // 다리를 건너는 중인 트럭
        var stack = Stack<Int>()
        var truckList = truck_weights.toMutableList()
        var totalWeight = 0
        var t: Int = 0
        var buf: Int = 0

        for (i in 0 until bridge_length) {
            queue.offer(0)
        }
        while (stack.size != truck_weights.size) { // 한 번 반복할때를 1초로 생각.
            buf = queue.poll()
            totalWeight -= buf
            if (buf != 0) {
                stack.push(buf)
            }
            if (truckList.isNotEmpty()) {
                if (totalWeight + truckList.get(0) <= weight && bridge_length >= queue.size)
                    t = truckList.removeAt(0)
            }
            if (totalWeight + t <= weight && bridge_length >= queue.size) {
                queue.offer(t)
                totalWeight += t
            }
            t = 0
            sec++
        }
        return sec
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val bridge_length = 2
    val weight = 10
    val truck_weights = intArrayOf(7, 4, 5, 6)
    var answer = sol.solution(bridge_length, weight, truck_weights)

    print(answer)
}
