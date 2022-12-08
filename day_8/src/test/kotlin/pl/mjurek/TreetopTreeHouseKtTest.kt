package pl.mjurek

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class TreetopTreeHouseKtTest {
    private val input = arrayOf(
        intArrayOf(3, 0, 3, 7, 3),
        intArrayOf(2, 5, 5, 1, 2),
        intArrayOf(6, 5, 3, 3, 2),
        intArrayOf(3, 3, 5, 4, 9),
        intArrayOf(3, 5, 3, 9, 0)
    )

    @Test
    fun `Day 8 described sample`() {
        val result = howManyTreesAreVisibleFromOutsideTheGrid(input)

        Assertions.assertEquals(result, 21)
    }


    @Test
    fun `Should return elements in appropriate direction`() {
        var result = getNextElementsInDirection(
            input, Direction.LEFT, 1, 3
        )
        assertThat(result).isEqualTo(arrayListOf(5, 5, 2))

        result = getNextElementsInDirection(
            input, Direction.BOTTOM, 1, 3
        )
        assertThat(result).isEqualTo(arrayListOf(3, 4, 9))

        result = getNextElementsInDirection(
            input, Direction.TOP, 1, 3
        )
        assertThat(result).isEqualTo(arrayListOf(7))

        result = getNextElementsInDirection(
            input, Direction.TOP, 1, 3
        )
        assertThat(result).isEqualTo(arrayListOf(7))
    }

    @Test
    fun `Visible from side`() {
        var result = checkVisibleFromSize(Direction.RIGHT, input, 3, 3)
        assertThat(result).isFalse()

        result = checkVisibleFromSize(Direction.LEFT, input, 3, 3)
        assertThat(result).isFalse()

        result = checkVisibleFromSize(Direction.TOP, input, 3, 3)
        assertThat(result).isFalse()

        result = checkVisibleFromSize(Direction.BOTTOM, input, 3, 3)
        assertThat(result).isFalse()
    }
}
