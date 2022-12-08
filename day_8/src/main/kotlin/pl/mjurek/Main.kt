package pl.mjurek

import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import java.util.stream.Collectors

fun main() {
    val toArray = Files.lines(Path.of("src/main/resources/input.txt"))
        .map { it.trim() }
        .map { it.split("") }
        .map {
            it.filter { it.isNotEmpty() }
                .map { tree -> tree.toInt() }
        }
        .map { it.toIntArray() }
        .collect(Collectors.toList())
    println(howManyTreesAreVisibleFromOutsideTheGrid(toArray.toTypedArray()))
}
