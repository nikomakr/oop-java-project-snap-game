# Snap Card Game 🃏

A Java-based implementation of the classic Snap card game, demonstrating core Object-Oriented Programming principles and collection handling.

Project relies on Requirements given, here: https://github.com/nology-tech/van-rossum-jan-2026-cohort/blob/main/student-resources/04-java/1-projects/02-Snap/brief.md

## 📋 Table of Contents

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

This project is an implementation of the Snap card game built in Java as part of my journey to strengthen software engineering fundamentals. The game demonstrates core OOP concepts including classes, inheritance, encapsulation, and collection handling through an interactive console-based interface with visual countdown timer.

### Key Concepts Demonstrated

- **Object-Oriented Programming**: Classes, inheritance, encapsulation
- **Data Structures**: ArrayList manipulation and sorting
- **Game Logic**: Turn-based gameplay and win conditions
- **User Interaction**: Console I/O and timing mechanisms
- **Timer Implementation**: Progress bar countdown with visual feedback

## ✨ Features

- ✅ Full 52-card deck implementation with Unicode suit symbols (♥ ♣ ♦ ♠)
- ✅ Multiple deck sorting options (by number, by suit)
- ✅ Card shuffling functionality
- ✅ Single-player and two-player modes
- ✅ Visual progress bar countdown (2-second timer)
- ✅ Timed "snap" response mechanism with live visual feedback
- ✅ Interactive console-based gameplay
- ✅ Multiple rounds with persistent player statistics
- ✅ Replay functionality with cumulative win tracking

## 🛠️ Technologies Used

- **Java** - Core programming language
- **ArrayList** - Dynamic collection handling
- **Scanner** - Console input handling
- **Timer/TimerTask** - Timed game mechanics and visual countdown
- **ANSI Escape Codes** - Terminal-based progress bar animation

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line tools
- Terminal with ANSI escape code support (most modern terminals)

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

## 🎮 How to Play

### Two-Player Mode
1. Enter names for both players when prompted
2. Players take turns pressing **Enter** to deal a card
3. When two consecutive cards match (a "snap"), a visual progress bar appears
4. Type **"snap"** within 2 seconds to win the round
5. The fastest player to type "snap" wins the round and earns a point
6. Game continues until the deck is empty
7. Choose to play again (Y/N) to start a new game with persistent statistics

### Visual Countdown
When a match occurs, you'll see:
```
*** MATCH! Two Ks! ***

⏱️  [████████████████████] 

Type 'snap': 
```
The progress bar fills up as time passes - type "snap" before it completes!

## 📁 Project Structure

```
oop-java-project-snap-game/
├── .gitignore
├── README.md
├── LICENSE
├── pom.xml
├── src/
|   └──  main/
|      └── java/
|          ├── Card.java
|          ├── CardGame.java
|          ├── Player.java
|          ├── Snap.java
|          └── SnapTerminal.java
└──  target/
   └── maven-archiver/
          ├── pom.properties
          └── snap-card-game-1.0.0.jar
```

## 🔄 Development Stages

This project was built incrementally through four stages:

### Stage 1: Core Classes
- Created `Card` class with suit, symbol, and value properties
- Implemented `CardGame` class with a 52-card deck
- Added `toString()` method for card display
- Implemented getter methods for encapsulation

### Stage 2: Deck Operations
- Implemented `dealCard()` to remove and return the top card
- Added `sortDeckInNumberOrder()` for numerical sorting
- Added `sortDeckIntoSuits()` for suit-based sorting
- Implemented `shuffleDeck()` for randomisation using Collections.shuffle()

### Stage 3: Single Player Snap
- Created `Snap` class extending `CardGame`
- Implemented turn-based gameplay with Enter key
- Added win condition detection for consecutive matching cards
- Integrated Scanner for user input handling

### Stage 4: Two-Player Mode
- Created `Player` class with name and win tracking
- Implemented turn alternation between two players
- Added 2-second timer using Timer and TimerTask
- Implemented input validation for "snap" keyword
- Integrated visual progress bar countdown
- Added replay functionality with persistent statistics
- Implemented multiple-round gameplay with cumulative scoring

## 💡 What I Learned

- How to structure a Java project with multiple interacting classes
- Practical application of inheritance and method overriding
- ArrayList manipulation including sorting and shuffling
- Implementing game state management and turn logic
- Working with console I/O and timing mechanisms
- Using Timer and TimerTask for asynchronous countdown
- ANSI escape codes for terminal-based visual feedback
- Constructor overloading for different object initialisation scenarios
- Persisting object state across multiple game instances

## 🔮 Future Enhancements

- [ ] Add GUI using JavaFX or Swing
- [ ] Implement different game variations
- [ ] Add sound effects for card dealing and snaps
- [ ] Create leaderboard system with file persistence
- [ ] Add AI opponent for single-player mode
- [ ] Implement networked multiplayer (client-server architecture)
- [ ] Add customisable timer duration
- [ ] Implement different difficulty levels

## 🤝 Contributing

This is a learning project, but feedback and suggestions are welcome!

1. Fork the project
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

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
SOFTWARE.

## 📬 Contact

Nikolaos Niko Makridis - [@nikomakr](https://github.com/nikomakr)

Project Link: [https://github.com/nikomakr/oop-java-project-snap-game](https://github.com/nikomakr/oop-java-project-snap-game)

---

⭐ If you found this project helpful, please consider giving it a star!