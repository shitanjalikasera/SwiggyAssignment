package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArenaTest {
    @Test
    public void testFightLogic() {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 5);

        Arena arena = new Arena();
        arena.fight(playerA, playerB);

        // After the fight, one player should have 0 health
        assertTrue(playerA.getHealth() == 0 || playerB.getHealth() == 0);
        assertTrue(playerA.getHealth() > 0 || playerB.getHealth() > 0);
    }

    @Test
    public void testFightWinner() {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 20, 10, 5);

        Arena arena = new Arena();
        arena.fight(playerA, playerB);

        // Check the winner based on final health
        if (playerA.getHealth() > 0) {
            assertEquals(0, playerB.getHealth());
        } else {
            assertEquals(0, playerA.getHealth());
        }
    }

    @Test
    public void testEqualHealthPlayers() {
        // Both players start with equal health
        TestPlayer playerA = new TestPlayer("Player A", 100, 10, 15, new int[]{4, 3});
        TestPlayer playerB = new TestPlayer("Player B", 100, 12, 10, new int[]{2, 5});
        Arena arena = new Arena();

        arena.fight(playerA, playerB);

        // Validate that one player wins
        assertTrue(playerA.getHealth() == 0 || playerB.getHealth() == 0);
        assertFalse(playerA.getHealth() == 0 && playerB.getHealth() == 0); // Both cannot die simultaneously
    }

    @Test
    public void testHighDamageVsLowDefense() {
        // Player A has a high attack roll, Player B has a low defense roll
        TestPlayer playerA = new TestPlayer("Player A", 100, 5, 20, new int[]{6}); // Max attack roll
        TestPlayer playerB = new TestPlayer("Player B", 100, 2, 10, new int[]{1}); // Min defense roll
        Arena arena = new Arena();

        arena.fight(playerA, playerB);

        // Validate that Player B loses significant health
        assertTrue(playerA.getHealth() > 0);
        assertTrue(playerB.getHealth() < 100); // Player B takes damage
    }
}
