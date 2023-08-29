package com.softserveinc.application.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PlayerAnalyzerTest {

    private final PlayerAnalyzer analyzer = new PlayerAnalyzer();
    List<Player> players;

    @ParameterizedTest
    @MethodSource("normalPlayerTestData")
    void testNormalPlayer(Player player, double score) {
        players = List.of(player);

        double calculateScore = analyzer.calculateScore(players);

        assertEquals(score, calculateScore);

    }

    private static Stream<Arguments> normalPlayerTestData() {
        return Stream.of(
                arguments(createPlayer(25, 5, List.of(2, 2, 2)), 250.0)
        );
    }

    @ParameterizedTest
    @MethodSource("juniorPlayerTestData")
    void testJuniorPlayer(Player player, double score) {
        players = List.of(player);

        double calculateScore = analyzer.calculateScore(players);

        assertEquals(score, calculateScore);

    }

    private static Stream<Arguments> juniorPlayerTestData() {
        return Stream.of(
                arguments(createPlayer(15, 3, List.of(3, 3, 3)), 67.5)
        );
    }

    @ParameterizedTest
    @MethodSource("seniorPlayerTestData")
    void testSeniorPlayer(Player player, double score) {
        players = List.of(player);

        double calculateScore = analyzer.calculateScore(players);

        assertEquals(score, calculateScore);

    }

    private static Stream<Arguments> seniorPlayerTestData() {
        return Stream.of(
                arguments(createPlayer(35, 15, List.of(4, 4, 4)), 2520.0)
        );
    }

    @ParameterizedTest
    @MethodSource("multiplePlayersTestData")
    void testMultiplePlayers(Player player1, Player player2, Player player3, double scoreSum) {
        players = List.of(player1, player2, player3);

        double calculateScore = analyzer.calculateScore(players);

        assertEquals(scoreSum, calculateScore);
    }

    private static Stream<Arguments> multiplePlayersTestData() {
        return Stream.of(
                arguments(createPlayer(15, 3, List.of(3, 3, 3)),
                        createPlayer(25, 5, List.of(2, 2, 2)),
                        createPlayer(35, 15, List.of(4, 4, 4)),
                        2837.5)
        );
    }

    @ParameterizedTest
    @MethodSource("skillsIsNullTestData")
    void testSkillsIsNull(Player player) {
        players = List.of(player);

        assertThrows(NullPointerException.class, () -> analyzer.calculateScore(players));
    }

    private static Stream<Arguments> skillsIsNullTestData() {
        return Stream.of(
                arguments(createPlayer(35, 15, null))
        );
    }

    @Test
    void testEmptyArray() {
        players = new ArrayList<>();

        double calculateScore = analyzer.calculateScore(players);

        assertEquals(0, calculateScore);
    }

    private static Player createPlayer(int age, int experience, List<Integer> skills) {
        Player player = new Player();
        player.setAge(age);
        player.setExperience(experience);
        player.setSkills(skills);
        return player;
    }
}