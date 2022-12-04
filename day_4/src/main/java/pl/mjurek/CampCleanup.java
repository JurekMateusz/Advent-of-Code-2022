package pl.mjurek;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CampCleanup {
    public static long howManyAssignmentPairsDoesOneRangeFullyContainTheOther(Stream<String> data) {
        return data.map(String::trim)
                .map(it -> it.split(","))
                .map(it -> Tuple.of(it[0], it[1]))
                .filter(CampCleanup::oneRangeFullyContainTheOther)
                .count();
    }

    private static boolean oneRangeFullyContainTheOther(Tuple2<String, String> pair) {
        var oneSection = getNumberOfSections(pair._1);
        var secSection = getNumberOfSections(pair._2);
//        return oneSection.contains(secSection) || secSection.contains(oneSection); part 1
        return oneSection.stream() // part 2
                .anyMatch(secSection::contains);
    }

    private static Set<Integer> getNumberOfSections(String sections) {
        List<Integer> range = Arrays.stream(sections.split("-"))
                .map(Integer::parseInt)
                .toList();
        if (range.size() != 2) {
            throw new IllegalArgumentException();
        }
        return IntStream.rangeClosed(range.get(0), range.get(1))
                .boxed()
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) throws IOException {
        Path path = Files.walk(Path.of("day_4"))
                .filter(file -> file.getFileName().endsWith("input.txt")).findFirst().orElseThrow();
        Stream<String> input = Files.lines(path);
        System.out.println(howManyAssignmentPairsDoesOneRangeFullyContainTheOther(input));
    }
}
