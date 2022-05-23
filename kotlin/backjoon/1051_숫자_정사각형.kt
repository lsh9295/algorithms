import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val input = br.readLine()!!.split(" ")
    var n = input[0].toInt()
    var m = input[1].toInt()

    var minSize = if (n > m) m else n
    var size = 1
    val board = Array(n) { IntArray(m) { _ -> 0 } }

    for (i in 0 until n) { // board 초기화
        var buf = br.readLine()!!.split("") as MutableList<String>
        buf.removeAll(listOf(""))
        for (j in 0 until m) {
            board[i][j] = buf[j].toInt()
        }
    }

    for (i in 1 until minSize) {   // 정사각형 크기 1*1 2*2 ... min*min
        for (j in 0 until n - 1) {     // 한 바퀴 돌 때마다 n - 1
            for (k in 0 until m - 1) { // 한 바퀴 돌 때마다 m - 1
                if (board[j][k] == board[j][k + i] && board[j][k] == board[j + i][k] &&
                    board[j][k] == board[j + i][k + i]
                ) {
                    size = (i + 1) * (i + 1)
                }
            }
        }
        n -= 1
        m -= 1
    }
    print(size)
}