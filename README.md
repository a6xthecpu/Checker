# Java Checkers Game

## 1. Project Overview

This project is a Java-based implementation of the classic Checkers game. The game will feature core mechanics such as legal move validation, turn-based gameplay, and win condition detection. Future enhancements may include a graphical interface and AI for single-player mode.

## 2. Features

- 8x8 Checkers board representation
- Turn-based gameplay
- Legal move enforcement
- King promotion mechanics
- Win condition detection

## 3. Installation & Setup

### Prerequisites

- Java Development Kit (JDK) 11 or later
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code

### Steps

1. Clone this repository:
   ```sh
   git clone https://github.com/yourusername/java-checkers.git
   ```
2. Open the project in your preferred IDE.
3. Compile and run the game:
   ```sh
   javac src/*.java
   java src.Main
   ```

## 4. Game Logic Implementation

### Board Representation

- The game board is implemented using a 2D array.
- Each piece has properties such as type (normal/king) and color.

### Move Validation

- Normal pieces can move diagonally forward.
- Kings can move diagonally in both directions.
- Capture mechanics (jumping over opponent pieces) are enforced.

### Turn Management

- The game alternates turns between two players.
- Moves are validated before execution.

### Winning Conditions

- A player wins when the opponent has no valid moves left.

## 5. Next Steps

- Implement a command-line interface for user interaction.
- Develop a GUI using Java Swing or JavaFX.
- Add AI for a single-player mode.

## 6. Contributors

- @a6xthecpu
- @hammyexe

---

Stay tuned for updates and improvements!
