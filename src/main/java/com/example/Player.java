package com.example;

import java.util.Random;

class Player {
    private String name;
    private int health;
    private int strength;
    private int attack;

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getStrength() { return strength; }
    public int getAttack() { return attack; }
    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1; // Roll a die (1-6)
    }

    public int calculateAttackDamage(int diceRoll) {
        return attack * diceRoll;
    }

    public int calculateDefenseDamage(int diceRoll) {
        return strength * diceRoll;
    }
}