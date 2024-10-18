Yatzy Refactoring Kata Java Version
===================================

For full instructions see [top level instructions](../README.md)

There are three variants of this kata each with different refactoring challenges.

## Code Reading Practice
Here is a list of github urls of all the YatzyCalculator Java classes:

* [Yatzy1](https://github.com/emilybache/Yatzy-Refactoring-Kata/blob/main/java/src/main/java/org/codingdojo/yatzy1/Yatzy1.java)
* [Yatzy2](https://github.com/emilybache/Yatzy-Refactoring-Kata/blob/main/java/src/main/java/org/codingdojo/yatzy2/Yatzy2.java)
* [Yatzy3](https://github.com/emilybache/Yatzy-Refactoring-Kata/blob/main/java/src/main/java/org/codingdojo/yatzy3/Yatzy3.java)

# Yatzy Implementation

* [kATA-Yatzy repo](https://github.com/bel-zak/Omnilog-Kata-Datanumia/tree/main/java) 

## Table des Matières

1. [Introduction](#introduction)
2. [Structure du Projet](#structure-du-projet)
3. [Classes Principales](https://github.com/bel-zak/Omnilog-Kata-Datanumia/tree/main/java/src/main/java/yatzy/refactoring/scorers)
    - [IYatzyCalculator](https://github.com/bel-zak/Omnilog-Kata-Datanumia/blob/main/java/src/main/java/yatzy/refactoring/interfaces/IYatzyCalculator.java)
    - [YatzyCalculatorImpl](https://github.com/bel-zak/Omnilog-Kata-Datanumia/blob/main/java/src/main/java/yatzy/refactoring/service/YatzyCalculatorImpl.java)
    - [CategoryScorer](https://github.com/bel-zak/Omnilog-Kata-Datanumia/blob/main/java/src/main/java/yatzy/refactoring/scorers/CategoryScorer.java)
    - [Scorers Spécifiques](https://github.com/bel-zak/Omnilog-Kata-Datanumia/blob/main/java/src/main/java/yatzy/refactoring/scorers/ChanceScorer.java)
    - [YatzyCategory](https://github.com/bel-zak/Omnilog-Kata-Datanumia/blob/main/java/src/main/java/yatzy/refactoring/models/YatzyCategory.java)
4. [Tests](https://github.com/bel-zak/Omnilog-Kata-Datanumia/tree/main/java/src/test/java/refactoring)

---

## Introduction

Cette implémentation du jeu **Yatzy** permet de calculer les scores pour différentes catégories du jeu. Contrairement aux implémentations précédentes, cette version utilise directement une liste d'entiers pour représenter les valeurs des dés, éliminant ainsi la nécessité d'une classe dédiée pour les dés.

---

## Structure du Projet

```plaintext
src
└── com
    └── example
        └── yatzy
            ├── IYatzyCalculator.java
            ├── YatzyCalculator.java
            └── scorers
                ├── CategoryScorer.java
                ├── ChanceScorer.java
                ├── FullHouseScorer.java
                ├── NumberScorer.java
                ├── RepeatedCountScorer.java
                ├── StraightScorer.java
                ├── TwoPairsScorer.java
                └── YatzyPointsScorer.java
            └── models
                └── YatzyCategory.java
