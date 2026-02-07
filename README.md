# Snap Card Game 🃏

A Java-based implementation of the classic Snap card game, demonstrating core Object-Oriented Programming principles and collection handling.

Project relies on Requirements given, here: https://github.com/nology-tech/van-rossum-jan-2026-cohort/blob/main/student-resources/04-java/1-projects/02-Snap/brief.md

## Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Game](#running-the-game)
- [How to Play](#how-to-play)
- [Project Structure](#project-structure)
- [Development Stages](#development-stages)
- [What I Learned](#what-i-learned)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## 🎯 About the Project

This project is an implementation of the Snap card game built in Java as part of my journey to strengthen software engineering fundamentals. The game demonstrates core OOP concepts including classes, inheritance, encapsulation, and collection handling through an interactive console-based interface.

### Key Concepts Demonstrated

- **Object-Oriented Programming**: Classes, inheritance, encapsulation
- **Data Structures**: ArrayList manipulation and sorting
- **Game Logic**: Turn-based gameplay and win conditions
- **User Interaction**: Console I/O and timing mechanisms

## Features

- ✅ Full 52-card deck implementation with Unicode suit symbols (♥ ♣ ♦ ♠)
- ✅ Multiple deck sorting options (by number, by suit)
- ✅ Card shuffling functionality

## Technologies Used

- **Java** - Core programming language
- **ArrayList** - Dynamic collection handling

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line tools

### Installation

1. Clone the repository
   ```bash
   git clone https://github.com/nikomakr/oop-java-project-snap-game.git
   ```

2. Navigate to the project directory
   ```bash
   cd oop-java-project-snap-game
   ```

3. Compile the Java files
   ```bash
   javac *.java
   ```

### Running the Game

```bash
java Snap
```

## How to Play

### Single Player Mode
1. Press **Enter** to deal a new card
2. Watch for matching card symbols
3. When two consecutive cards match, you win!

## Project Structure

oop-java-project-snap-game/
├── Card.java           # Card class with suit, symbol, and value
├── CardGame.java       # Base card game class with deck management
├── Snap.java           # Snap game implementation
├── Player.java         # Player class for two-player mode
└── README.md          # Project documentation

## Development Stages

This project was built incrementally through four stages:

### Stage 1: Core Classes
- Created `Card` class with suit, symbol, and value properties
- Implemented `CardGame` class with a 52-card deck
- Added `toString()` method for card display

### Stage 2: Deck Operations
- Implemented `dealCard()` to remove and return the top card
- Added `sortDeckInNumberOrder()` for numerical sorting
- Added `sortDeckIntoSuits()` for suit-based sorting
- Implemented `shuffleDeck()` for randomization

### Stage 3: Single Player Snap
- Created `Snap` class extending `CardGame`
- Implemented turn-based gameplay with Enter key
- Added win condition detection for consecutive matching cards

### Stage 4: Two Player Mode

## What I Learned

- How to structure a Java project with multiple interacting classes
- Practical application of inheritance and method overriding
- ArrayList manipulation including sorting and shuffling

## Contributing

This is a learning project, but feedback and suggestions are welcome!


## License

MIT License

Copyright (c) 2026 Niko

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.IT

## Contact

Nikolaos Niko Makridis - [@nikomakr](https://github.com/nikomakr)

Project Link: [https://github.com/nikomakr/oop-java-project-snap-game](https://github.com/nikomakr/oop-java-project-snap-game)

---

⭐ If you found this project helpful, please consider giving it a star!