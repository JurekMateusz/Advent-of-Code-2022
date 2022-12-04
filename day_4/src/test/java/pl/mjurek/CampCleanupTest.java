package pl.mjurek;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CampCleanupTest {

    @Test
    void howManyAssignmentPairsDoesOneRangeFullyContainTheOther() throws IOException {
        Stream<String> stream = Files.lines(Path.of("src/test/resources/test-input.txt"))
                .filter(line -> !line.isBlank())
                .map(line -> line.split("\\s+"))
                .map(it -> it[1]);
        Stream<String> inputStream = io.vavr.collection.Stream.ofAll(stream)
                .grouped(2)
                .map(str -> str.toJavaStream()
                        .collect(Collectors.joining(",")))
                .toJavaStream();


        long result = CampCleanup.howManyAssignmentPairsDoesOneRangeFullyContainTheOther(inputStream);

        Assertions.assertEquals(2, result);
    }
}
