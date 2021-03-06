package com.marcuschiu.testframeworkexampleboot221.junit.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5Test {

    // @ValueSource: we can use this with an array of values of type Short, Byte, Int, Long, Float, Double, Char, and String
    @ParameterizedTest
    @ValueSource(strings = { "Hello", "World" })
    void givenString_TestNullOrNot(String word) {
        assertNotNull(word);
    }

    // @EnumSource – passes Enum constants as parameters to the test method
    @ParameterizedTest
    @EnumSource(value = Level.class, names = {"HIGH", "MEDIUM", "LOW"})
    void givenEnum_TestContainsOrNot(Level level) {
        assertTrue(EnumSet.of(Level.HIGH, Level.MEDIUM, Level.LOW).contains(level));
    }

    // @MethodSource – passes external methods generating streams
    @ParameterizedTest
    @MethodSource("wordDataProvider")
    void givenMethodSource_TestInputStream(String argument) {
        assertNotNull(argument);
    }
    static Stream<String> wordDataProvider() {
        return Stream.of("foo", "bar");
    }

    // @CsvSource – uses CSV values as a source for the parameters
    @ParameterizedTest
    @CsvSource({ "1, Car", "2, House", "3, Train" })
    void givenCSVSource_TestContent(Integer id, String word) {
        assertNotNull(id);
        assertNotNull(word);
    }

    // @CsvFileSource if we need to read a CSV file from classpath
    @ParameterizedTest
    @CsvFileSource(resources = "/static/test.csv")
    void givenCsvFileSource_TestContent(Integer id, String word) {
        assertNotNull(id);
        assertNotNull(word);
    }

    // @ArgumentSource to specify a custom, reusable ArgumentsProvider
}
