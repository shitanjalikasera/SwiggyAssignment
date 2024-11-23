package com.example;

public class Arena {
    public void fight(Player player1, Player player2) {
        System.out.println("Fight starts between " + player1.getName() + " and " + player2.getName());

        // Determine who starts based on lower health
        Player currentAttacker = (player1.getHealth() <= player2.getHealth()) ? player1 : player2;
        Player currentDefender = (currentAttacker == player1) ? player2 : player1;

        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            // Attacker rolls the dice
            int attackRoll = currentAttacker.rollDice();
            int attackDamage = currentAttacker.calculateAttackDamage(attackRoll);

            // Defender rolls the dice
            int defenseRoll = currentDefender.rollDice();
            int defenseDamage = currentDefender.calculateDefenseDamage(defenseRoll);

            // Calculate damage to the defender
            int damageToDefender = Math.max(0, attackDamage - defenseDamage);
            currentDefender.takeDamage(damageToDefender);

            // Print fight details
            System.out.printf("%s attacks! Attack Roll: %d, Damage: %d\n", currentAttacker.getName(), attackRoll, attackDamage);
            System.out.printf("%s defends! Defense Roll: %d, Damage Blocked: %d\n", currentDefender.getName(), defenseRoll, defenseDamage);
            System.out.printf("%s takes %d damage, Health left: %d\n", currentDefender.getName(), damageToDefender, currentDefender.getHealth());
            System.out.println("----------------------------------");


            // Check if the defender has died
            if (currentDefender.getHealth() == 0) {
                System.out.println(currentDefender.getName() + " has died! " + currentAttacker.getName() + " wins!");
                break;
            }

            // Swap roles for the next turn
            Player temp = currentAttacker;
            currentAttacker = currentDefender;
            currentDefender = temp;
        }
    }
}
