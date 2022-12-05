import io.vavr.collection.Stream
import pl.mjurek.Crate
import pl.mjurek.Rearrangement
import java.util.*


class Stacks(val stack: List<Stack<Crate>>) {

    companion object {
        fun of(stackInInputStream: Stream<String>): Stacks {
            return Stacks(createStacks(stackInInputStream))
        }

        fun createStacks(stream: Stream<String>): List<Stack<Crate>> {
            val stack = stream.takeWhile {
                it.isNotBlank()
            }.toList()
            val last: String = stack.get(stack.size() - 1);
            val numberOfStacks: List<Int> = getNumOfStack(last)
            val nextIndexes: List<Int> = getIndexes(last)
            val result: ArrayList<Stack<Crate>> = createEmptyStacks(numberOfStacks)
            for (i in numberOfStacks.size - 2 downTo 0) {
                val line = stack[i]
                for (j in nextIndexes.indices) {
                    val index = nextIndexes[j]
                    if (line.length <= index) {
                        break
                    }
                    if (line[index] == ' ') {
                        continue
                    }
                    result[j].push(Crate(line[index]))
                }
            }
            return result
        }

        fun getNumOfStack(numberOfStacks: String) = numberOfStacks
            .split("\\s+".toRegex())
            .filter { it.isNotBlank() }
            .map(String::toInt)

        fun createEmptyStacks(numberOfStacks: List<Int>): ArrayList<Stack<Crate>> {
            val result = arrayListOf<Stack<Crate>>()
            numberOfStacks.forEach { _ -> result.add(Stack()) }
            return result
        }

        fun getIndexes(last: String): List<Int> {
            val result: ArrayList<Int> = ArrayList()
            var index = 0;
            for (char in last) {
                if (char != ' ') {
                    result.add(index)
                }
                index++
            }
            return result
        }
    }

    fun performRearrangement(rearrangement: Rearrangement) {
        val from = stack.get(rearrangement.from - 1)
        val to = stack.get(rearrangement.to - 1)
        to.push(from.pop())
    }

    fun getFinalAnswer(): String {
        return stack.map { it.pop() }.map { it.name }.joinToString(separator = "")
    }
}
