Escape the Bank


Escape the Bank is a maze-based, real-time strategy game where you play as a thief attempting to escape a burning bank without getting caught by patrolling cops. Navigate through barriers, avoid fires, collect cash rewards, and outsmart the cops to make your grand escape.

🎮 Game Overview

Objective: Escape the bank by collecting all cash rewards and the special bonus safe without being caught by cops or burned by fire.

Main Character: 

The thief, controlled by the player.

Enemies:

Cops: Patrolling guards that will end the game if they catch the thief.

Fire: Static hazards that burn the thief if they walk into them.

Rewards:

Cash: Scattered throughout the bank to increase the score.

Bonus Safe: A special item that significantly boosts the score when collected.

Obstacles:        
       
Barriers: Fixed walls that block the thief's path, creating a maze-like environment.

🕹️ Gameplay Mechanics
Thief Movement

        Controls:

        Press W to move up.

        Press A to move left.

        Press S to move down.

        Press D to move right.

Preconditions: There must be a valid, unoccupied cell in the direction the thief intends to move.

Exceptions: Pressing any key other than W, A, S, or D results in no movement.

Interactions
        
Fire:

        If the thief moves into a cell containing fire, they take damage.

        Multiple fire cells can reduce the thief's health to zero, resulting in game over.

Cop:

        If the thief moves into a cell containing a cop, they are caught, and the game ends.

Barrier:

        If the thief attempts to move into a cell with a barrier, they remain in their current position.

Cash Reward:

        If the thief moves into a cell containing cash, they collect the reward, increasing their score.

Bonus Safe:

        If the thief moves into a cell containing the bonus safe, they collect it, significantly boosting their score.

Health & Game Over

        The thief starts with full health.

        Health decreases when walking into fire or being caught by a cop.

        If health reaches zero, the game ends.

🧩 Game Board
Layout: The bank is represented as a grid (e.g., 10x10 cells).

Elements:

        Thief: Player-controlled character.

        Cops: AI-controlled enemies patrolling the bank.

        Fire: Static hazards scattered across the grid.

        Cash: Collectible rewards placed in various cells.

        Bonus Safe: A special item that appears in a random cell.

        Barriers: Impassable walls forming the maze.

🛠️ Development Process
Methodology: Adopted a Scrum-like process with 3–4 meetings per week.

Team Structure:

Divided into two pairs, each responsible for specific tasks.

Collaborated closely to ensure cohesive development.

Quality Assurance:

Conducted regular code reviews and testing sessions.

Iterated on feedback to improve gameplay mechanics and user experience.

📂 Project Structure
/src: Source code files.

/assets: Images, sounds, and other media assets.

/docs: Documentation and design documents.

README.md: This file.

🚀 Getting Started
Prerequisites
Python 3.x

Pygame library

Installation
Clone the repository:

bash
git clone https://github.com/mhl32/cmpt276.git
cd cmpt276
Install dependencies:

bash
pip install pygame
Running the Game
bash
python main.py
Follow the on-screen instructions to start the game.



📄 License
This project is licensed under the MIT License. See the LICENSE file for more details.
