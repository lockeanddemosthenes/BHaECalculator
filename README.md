# BHaECalculator
A Java-based calculator for a Discord-based tabletop game with a custom battle system. Initially created in one week in 2019 and updated many times over the course of two years. The last update was on April 23, 2021.

This version is deprecated. This repository remains available for archival purposes.

## Features
- Automatic hit %, crit %, and damage calculations for both attacker and defender
- Simple combat art selection
- Easy weapon change
- One-button target swap
- Shows personal and crest abilities
- Gambit calculations

## Running the Calculator
- Ensure you have Java Runtime Environment (JRE) 8 or higher installed.
- Download the "BHaECalculator.zip" file.
- Extract its contents. You should end up with a folder called BHaECalculator that has the following contents:
  - arena.txt
  - arts.txt
  - calculator.jar
  - enemies.txt
  - gambits.txt
  - runner.bat
  - units.txt
  - weapons.txt
- If you have older versions of these files, overwrite them or delete them. Be sure the names are exact (e.g. no "arts.txt (1)")
- Double-click on "calculator.jar" to run the calculator.
  - If this step does not work, try double-clicking on "runner.bat". If the calculator still does not work, contact Loki.

## Screenshots
![Combat type selection screen](/img/img1.png)

*Combat type selection screen*

![Sample combat output](/img/img2.png)

*Sample combat output screen*

![Sample combat art selection](/img/img3.png)

*Lance combat art selection screen*

## Tools
Java and Java Swing were utilized to create this calculator.
- Java was used to parse information from external files and form the calculations.
- Java Swing was used to create a GUI for easy, intuitive use by all members of the community.

## Equations
Atk = WeaponMt + (Mag||Str)
Hit = WeaponHit + Dex + Lck/2
For combat arts that extend outside of the weapon & user’s natural range, hit -10 * (spaces)
Crit = WeaponCrit + Dex + Lck/2
CritAvo = Lck
AtkSpd = Spd - (TotalWt - int(Str/5))
Avo = Lck + AtkSpd/2

Dmg per attack = [Attacker]Atk - [Defender](Def || Res)
Follow-up attack if difference in AtkSpd >= 4
Hit rate = [Attacker]Hit - [Defender]Avo
Crit rate = [Attacker]Crit - [Defender]CritAvo
Crit dmg = Dmg per attack * 3
Effective dmg from weapon = WeaponMt * 3 + (Mag || Str)
Effective dmg from combat art = WeaponMt * 2 + ArtMt + (Mag || Str)
Effective dmg from weapon + combat art = WeaponMt * 3 + ArtMt + (Mag || Str)

Gambit Dmg (phys) = (GambitMt + AuthorityLv)* EffBonus + int(Cha/5) + [Attacker](Mag || Str) - [Defender](Def || Res)
Gambit Hit Rate = GambitHit + (([Attacker]Cha - [Defender]Cha) * 5)

Authority Lv: E = 0, E+ = 2, D = 3, D+ = 4, C = 5, C+ = 6, B = 7, B+ = 8, A = 9, A+ = 10, S = 11, S+ = 12
