/*
4*4 の2Dmapをつくる。
ピリオドとシャープを使用。
wasd でシャープを移動させる。
スタート地点は左上(0,0)
行き止まりでは進めない。
pで終了。
表示は文字列。

参考
....
....
.#..
....

追加内容
歩いた歩数を表示

    val map = arrayOf(
        charArrayOf('#', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.')
    )
 */

fun main(args: Array<String>) {
    val map = arrayOf(
        charArrayOf('#', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.')
    )

    var playerX = 0
    var playerY = 0
    var step = 0

    while (true) {

        // プレイヤーの位置を表示
        map[playerY][playerX] = '#'
        for (row in map) {
            println(row.joinToString(""))
        }
        map[playerY][playerX] = '.'

        // 入力を受け取る
        print("Move (w/a/s/d): ")
        val input = readLine() ?: ""
        val direction = input.toLowerCase().trim()
        step++
        println("step : $step")

        // プレイヤーの移動
        when (direction) {
            "w" -> if (playerY > 0 && map[playerY - 1][playerX] != '#') playerY--
            "a" -> if (playerX > 0 && map[playerY][playerX - 1] != '#') playerX--
            "s" -> if (playerY < 3 && map[playerY + 1][playerX] != '#') playerY++
            "d" -> if (playerX < 3 && map[playerY][playerX + 1] != '#') playerX++
            "p" -> return
            else -> println("Invalid input")

        }
    }
}
