package pl.mjurek

import Stacks
import io.vavr.collection.Stream
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors
import java.util.stream.IntStream

val getStream = { path: String -> Stream.ofAll(Files.lines(Path.of(path))) }

const val INPUT = "src/main/resources/input.txt"
fun main() {
    val stacks = Stacks.of(getStream(INPUT))
    val toList = getStream(INPUT)
        .dropWhile { it.startsWith("[") }
        .drop(2)
        .filter { it.isNotEmpty() }
        .map { it.replace("[^0-9]".toRegex(), "") }
        .flatMap { mapToRearrangement(it) }
//        .forEach { println(it) }
        .forEach { stacks.performRearrangement(it) }
    println(stacks.getFinalAnswer())
}

fun mapToRearrangement(command: String): List<Rearrangement> {
    val funn = { index: Int -> Character.getNumericValue(command[index]) }
    var tempxd = 0
    val moves = if (command.length > 3) {
        tempxd++
        "${command[0]}${command[1]}".toInt()
    } else funn(0)
    return IntStream.rangeClosed(1, moves)
        .mapToObj { _ -> Rearrangement(funn(1 + tempxd), funn(2 + tempxd)) }
        .collect(Collectors.toList())
}




