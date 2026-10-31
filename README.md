# Batalha Pokemon

A console Pokemon battle simulator in Java: trainers, Pokemon with base stats, EVs, levels and experience groups, level-up stat growth and damage formulas I made up for physical and special attacks. Made in February 2014, in the third semester of Digital Games at Fatec.

The stats database started as hand-typed data (`DataBasePokemon`), before I found out there was a Pokemon API.

## History

`v0` to `v3` (5-14 Feb 2014): from basic `Pokemon`/`Treinador` classes to the stats database in `Principal`. There is no menu yet: `Principal` builds a trainer, lists his Pokemon and tries one attack.

`v3` stopped halfway through a refactor: `DataBasePokemon` gained experience and EV fields, but the 156-row table still passes the old 10 values, so `src/` does not compile on its own. `fixes/DataBasePokemon.java` adds back a 10-value constructor (the new fields start at zero); the release and web builds compile `src/` with that file on top.

## Run in the browser

**[https://fershibli.github.io/batalha-pokemon/](https://fershibli.github.io/batalha-pokemon/)**

The page runs the jar on [CheerpJ](https://cheerpj.com) (a JVM in WebAssembly) and shows the console output. Published by `.github/workflows/pages.yml`.

## Author

Fernando Luiz Neme Chibli ([@fershibli](https://github.com/fershibli))

## Releases

Builds are made by GitHub Actions (`.github/workflows/release.yml`) on macOS, Windows and Linux: each platform gets a zipped app image with its own Java runtime, plus a portable `BatalhaPokemon.jar` (`java -jar BatalhaPokemon.jar`). Push a tag such as `v1.0` (or run the workflow by hand) to publish a release.

The project also opens in Eclipse or NetBeans.
