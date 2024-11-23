package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlayerTest {
    @Test
    public void testPlayerInitialization() {
        Player player = new Player("Player A", 100, 10, 5);
        assertEquals("Player A", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getStrength());
        assertEquals(5, player.getAttack());
    }

    @Test
    public void testTakeDamage() {
        Player player = new Player("Player A", 100, 10, 5);
        player.takeDamage(30);
        assertEquals(70, player.getHealth());

        // Health cannot go below zero
        player.takeDamage(100);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testDiceRoll() {
        Player player = new Player("Player A", 100, 10, 5);
        for (int i = 0; i < 100; i++) {
            int roll = player.rollDice();
            assertTrue("Dice roll out of range: " + roll,roll >= 1 && roll <= 6);
        }
    }

    @Test
    public void testCalculateAttackDamage() {
        Player player = new Player("Player A", 100, 10, 5);
        int damage = player.calculateAttackDamage(6);
        assertEquals(30, damage); // attack = 5 * 6
    }

    @Test
    public void testCalculateDefenseDamage() {
        Player player = new Player("Player A", 100, 10, 5);
        int defense = player.calculateDefenseDamage(4);
        assertEquals(40, defense); // strength = 10 * 4
    }
}
