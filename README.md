# Number Guessing Game

A beginner-friendly Java console game. The program chooses a number from 1 to
100, and you have up to 7 valid guesses to find it. It gives a "too high" or
"too low" hint after each valid guess, and lets you play multiple rounds.

Invalid entries (such as text or numbers outside 1-100) are explained and do
not use a guessing attempt. The running score awards 1 point for each round
won.

## Requirements

- Java Development Kit (JDK) installed
- A terminal or command prompt

## Compile

Open a terminal in the folder containing `NumberGuessingGame.java` and run:

```text
javac NumberGuessingGame.java
```

## Run

```text
java NumberGuessingGame
```

Follow the prompts to enter guesses. After each round, enter `y` to play again
or `n` to quit.
