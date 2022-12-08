package pl.mjurek


fun howManyTreesAreVisibleFromOutsideTheGrid(input: Array<IntArray>): Int {
    var notVisibleCnt = 0
    for (i in 1 until input.size - 1) {
        val line = input[i]
        for (j in 1 until line.size - 1) {
            val left = !checkVisibleFromSize(Direction.LEFT, input, i, j)
            val right = !checkVisibleFromSize(Direction.RIGHT, input, i, j)
            val top = !checkVisibleFromSize(Direction.TOP, input, i, j)
            val bottom = !checkVisibleFromSize(Direction.BOTTOM, input, i, j)
            if (left && right && top && bottom) {
                notVisibleCnt += 1
            }
        }
    }
    return (input.size * input[0].size) - notVisibleCnt
}

fun checkVisibleFromSize(direction: Direction, input: Array<IntArray>, i: Int, j: Int): Boolean {
    val current = input[i][j]
    val elementsInDirection = getNextElementsInDirection(input, direction, i, j)
    for (el in elementsInDirection) {
        if (current <= el) {
            return false
        }
    }
    return true
}

fun getNextElementsInDirection(input: Array<IntArray>, direction: Direction, y: Int, x: Int): ArrayList<Int> {
    val result = ArrayList<Int>()
    when (direction) {
        Direction.LEFT -> {
            for (i in x - 1 downTo 0) {
                result.add(input[y][i])
            }
        }
        Direction.RIGHT -> {
            for (i in x + 1 until input[y].size) {
                result.add(input[y][i])
            }
        }
        Direction.TOP -> {
            for (i in y - 1 downTo 0) {
                result.add(input[i][x])
            }
        }
        Direction.BOTTOM -> {
            for (i in y + 1 until input.size) {
                result.add(input[i][x])
            }
        }
    }
    return result
}

enum class Direction {
    LEFT, TOP, BOTTOM, RIGHT
}
