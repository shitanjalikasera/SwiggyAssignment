package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 5);

        Arena arena = new Arena();
        arena.fight(playerA, playerB);
    }
}
