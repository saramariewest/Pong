# Pong

## Overview

A classic Pong game implemented in Java using Swing for graphics and user interaction. Play against an AI opponent with mouse controls.

## Features

- Ball physics with speed increases after bounces
- Paddle collision detection
- Score tracking and lives system
- Mouse-controlled user paddle, AI-controlled PC paddle

## Requirements

- Java 8 or higher

## Running

From the project root:

```bash
javac src/*.java
java -cp src Main
```

## Project structure

- Main.java — application entry point
- PongGame.java — main game logic, rendering, and event handling
- Ball.java — ball movement, bouncing, and speed handling
- Paddle.java — paddle positioning and collision detection

## Notes

The game ends when lives reach zero. The ball resets after scoring.
