# ☠️ Les Pirates

> *Jack Le Borgne et Bill Jambe de Bois se disputent le commandement du Sanguinaire.*  
> *Un plateau. Deux pirates. Une seule barque.*

---

## Le jeu

Les Pirates est un jeu de société de parcours en console, développé en Java dans le cadre du cours de **Conception et Programmation Orientée Objet** (L3 SRI — UPSSITECH).

Deux pirates s'affrontent sur un plateau de **30 cases** disposées en spirale. Chaque tour, un pirate lance deux dés et avance. Certaines cases déclenchent des effets spéciaux qui peuvent tout faire basculer.

**Condition de victoire** : atteindre la case 30 en premier, ou survivre à son adversaire.

---

## Les cases spéciales

| Case | Positions | Effet |
|------|-----------|-------|
| 💀 **Roulette Russe** | 5 · 15 · 25 | Le pirate est téléporté vers une case aléatoire du plateau |
| ❤️‍🔥 **Vol de Vie** | 10 · 20 | Le pirate vole 1 cœur à son adversaire et est téléporté |

Chaque pirate commence avec **5 cœurs**. Tomber à 0 = défaite immédiate.

---

## Architecture

Le projet suit une architecture **ECB / MVC stricte** :

```
src/
├── affichage/          ← VUE  — tout ce qui s'affiche
│   ├── IAffichage.java     Interface : uniquement des types primitifs
│   └── Affichage.java      Implémentation console
│
├── jeu/                ← MODÈLE — aucun affichage
│   ├── Jeu.java            Chef d'orchestre du jeu
│   ├── Joueur.java         État d'un pirate (vie, position, couleur)
│   ├── De.java             Lancer de dés via GenerateurRandom
│   ├── Plateau.java        30 cases, instanciation dynamique
│   └── Couleur.java        Enum ROUGE / BLEU
│
├── cases/              ← MODÈLE — hiérarchie de cases
│   ├── Case.java           Classe abstraite
│   ├── CaseNormale.java    Aucun effet (code 0)
│   ├── CaseRouletteRusse.java  Téléportation (code 1)
│   └── CaseVolVie.java     Vol de vie + téléportation (code 2)
│
├── communs/
│   └── GenerateurRandom.java   Singleton d'aléatoire (SecureRandom)
│
└── tests/
    └── Test.java           Point d'entrée
```

---

## Lancer le jeu

```bash
# Compiler
javac -d bin src/**/*.java

# Lancer
java -cp bin tests.Test
```

Le jeu est entièrement en console, interactif tour par tour.

---

## Exemple de session

```
===============================================
--- C'est le tour de : Jack Le Borgne ---
>>> Appuyez sur <Entrée> pour lancer les dés...
-> Les dés roulent... Résultat obtenu : 9

>>> Appuyez sur <Entrée> pour avancer sur le plateau...
-> Atterrissage sur la case numéro 10
   VOL DE VIE ! Le pirate vole un cœur et est téléporté !
-----------------------------------------------
   Bilan Jack Le Borgne (Pion ROUGE) : 6 cœurs, position 17
   Bilan Bill Jambe de Bois (Pion BLEU) : 4 cœurs, position 8
```

---

## Conception

| Document | Contenu |
|----------|---------|
| Diagramme de classes | Architecture complète avec toutes les cases |
| Diagramme de séquence système | Boucle de jeu principale |
| Diagramme de séquence détaillé × 2 | CaseRouletteRusse · CaseVolVie |
| Description des cases spéciales | Effets, ordre des opérations, conditions de fin |

---
