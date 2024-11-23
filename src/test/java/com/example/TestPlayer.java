package com.example;

class TestPlayer extends Player {
    private int[] diceRolls;
    private int rollIndex = 0;

    public TestPlayer(String name, int health, int strength, int attack, int[] diceRolls) {
        super(name, health, strength, attack);
        this.diceRolls = diceRolls;
    }

    @Override
    public int rollDice() {
        int roll = diceRolls[rollIndex];
        rollIndex = (rollIndex + 1) % diceRolls.length; // Loop through the rolls
        return roll;
    }
}
