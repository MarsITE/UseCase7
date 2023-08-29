package com.softserveinc.application.student;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StudentConverterTest {
    private final StudentConverter converter = new StudentConverter();
    private List<Student> students;
    private List<Student> convertedStudents;

    @ParameterizedTest
    @MethodSource("highAchieverTestData")
    void testHighAchiever(Student student) {
        students = List.of(student);

        convertedStudents = converter.convertStudents(students);

        assertTrue(convertedStudents.get(0).isHonorRoll());
    }

    private static Stream<Arguments> highAchieverTestData() {
        return Stream.of(
                arguments(createStudent(25, 91)),
                arguments(createStudent(21, 92))
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionalYoungHighAchieverTestData")
    void testExceptionalYoungHighAchiever(Student student) {
        students = List.of(student);

        convertedStudents = converter.convertStudents(students);

        assertTrue(convertedStudents.get(0).isExceptional());
    }

    private static Stream<Arguments> exceptionalYoungHighAchieverTestData() {
        return Stream.of(
                arguments(createStudent(20, 91)),
                arguments(createStudent(18, 92))
        );
    }

    @ParameterizedTest
    @MethodSource("passedStudentTestData")
    void testPassedStudent(Student student) {
        students = List.of(student);

        convertedStudents = converter.convertStudents(students);

        assertTrue(convertedStudents.get(0).isPassed());
    }

    private static Stream<Arguments> passedStudentTestData() {
        return Stream.of(
                arguments(createStudent(20, 71)),
                arguments(createStudent(18, 89))
        );
    }

    @ParameterizedTest
    @MethodSource("failedStudentTestData")
    void testFailedStudent(Student student) {
        students = List.of(student);

        convertedStudents = converter.convertStudents(students);

        assertFalse(convertedStudents.get(0).isPassed());
    }

    private static Stream<Arguments> failedStudentTestData() {
        return Stream.of(
                arguments(createStudent(20, 70)),
                arguments(createStudent(18, 69))
        );
    }

    @Test
    void testEmptyArray() {
        students = new ArrayList<>();

        convertedStudents = converter.convertStudents(students);

        assertTrue(convertedStudents.isEmpty());
    }

    @Test
    void testInputIsNull() {
        assertThrows(NullPointerException.class, () -> converter.convertStudents(students));
    }

    private static Student createStudent(int age, int grade) {
        Student student = new Student();
        student.setAge(age);
        student.setGrade(grade);
        return student;
    }
}
