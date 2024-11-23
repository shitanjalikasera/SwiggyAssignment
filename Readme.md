
# **Arena Game**

## **Overview**
The Arena is a turn-based game where two players battle against each other by rolling dice to attack and defend. The player with health reduced to zero first loses. The game has been implemented as a Maven project in Java, following clean coding practices and including robust test cases for edge scenarios.

---

## **How to Execute the Project**

### **Prerequisites**
1. **Java Development Kit (JDK 8 or later):**
   - Ensure that Java is installed and configured on your system.
   - Check the installation by running:
     ```bash
     java -version
     ```
2. **Maven:**
   - Apache Maven is required for building and running the project.
   - Verify Maven installation by running:
     ```bash
     mvn -version
     ```

3. **Git (Optional):**
   - To clone the repository, ensure Git is installed.

---

### **Steps to Run the Project**

1. **Clone the Repository**
   ```bash
   git clone https://github.com/shitanjalikasera/SwiggyAssignment.git
   cd SwiggyAssignment
   ```

2. **Build the Project**
   Run the following Maven command to clean and package the project:
   ```bash
   mvn clean package
   ```

3. **Run the Application**
   After building, execute the main class to start the game:
   ```bash
   java -cp target/SwiggyAssignment-1.0-SNAPSHOT.jar com.example.App
   ```

4. **Run Test Cases**
   Execute the test cases using Maven:
   ```bash
   mvn test
   ```

---

## **Project Structure**

```
SwiggyAssignment/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example/
│   │   │       ├── App.java          # Main class
│   │   │       ├── Arena.java        # Game logic
│   │   │       └── Player.java       # Player logic
│   ├── test/
│       └── java/
│           └── com.example/
│               └── ArenaTest.java    # Test cases for the game
├── pom.xml                           # Maven configuration file
└── README.md                         # Project documentation
```

---

## **Key Features**
1. **Turn-Based Gameplay:**
   - Players attack and defend alternately.
   - The player with lower health attacks first.

2. **Dice Rolls:**
   - Dice rolls determine attack and defense outcomes.
   - Six-sided dice simulate randomness (values between 1–6).

3. **Health and Damage Calculation:**
   - Attack damage: `attack * attackDiceRoll`.
   - Defense damage: `strength * defenseDiceRoll`.
   - Damage taken: `max(0, attackDamage - defenseDamage)`.

4. **End Conditions:**
   - Game ends when one player’s health reaches zero.

---

## **Test Cases**
The project includes comprehensive unit tests to validate all critical scenarios. Below are the key test cases:

1. **Players with Equal Health**
   - Ensures the game works when both players start with the same health.
   - Validates that the turn sequence is maintained.

2. **High Damage Rolls vs. Low Defense Rolls**
   - Tests scenarios where one player consistently rolls high for attack while the other rolls low for defense.
   - Validates the damage calculation.


---

## **Sample Output**
When you run the application, you’ll see output like this:

```
Fight starts between Player A and Player B
Player A attacks! Attack Roll: 5, Damage: 50
Player B defends! Defense Roll: 2, Damage Blocked: 20
Player B takes 30 damage, Health left: 70
----------------------------------
Player B attacks! Attack Roll: 4, Damage: 20
Player A defends! Defense Roll: 3, Damage Blocked: 15
Player A takes 5 damage, Health left: 45
----------------------------------
...
Player A has died! Player B wins!
```

---

## **Contributions**
This project was developed as part of an assignment to demonstrate proficiency in:
- Low-level design.
- Maven-based project structuring.
- Unit testing and coverage.

---

## **Author**
**Shitanjali Kasera**  


---
