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

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

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

class Arena {
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
            System.out.printf("%s attacks! Attack Roll: %d, Damage: %d\n", currentAttacker.getName(), attackRoll,
                    attackDamage);
            System.out.printf("%s defends! Defense Roll: %d, Damage Blocked: %d\n", currentDefender.getName(),
                    defenseRoll, defenseDamage);
            System.out.printf("%s takes %d damage, Health left: %d\n", currentDefender.getName(), damageToDefender,
                    currentDefender.getHealth());
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

public class swiggyGame {
    public static void main(String[] args) {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 5);

        Arena arena = new Arena();
        arena.fight(playerA, playerB);
    }
}
