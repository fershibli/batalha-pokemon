# Batalha Pokemon

A console Pokemon battle simulator in Java: trainers, Pokemon with base stats, EVs, levels and experience groups, level-up stat growth and damage formulas I made up for physical and special attacks. Made in February 2014, in the third semester of Digital Games at Fatec.

The stats database started as hand-typed data (`DataBasePokemon`), before I found out there was a Pokemon API.

## History

`v0` to `v3` (5-14 Feb 2014): from basic `Pokemon`/`Treinador` classes to the stats database and the full battle loop in `Principal`.

## Author

Fernando Luiz Neme Chibli ([@fershibli](https://github.com/fershibli))

## Releases

Builds are made by GitHub Actions (`.github/workflows/release.yml`) on macOS, Windows and Linux: each platform gets a zipped app image with its own Java runtime, plus a portable `BatalhaPokemon.jar` (`java -jar BatalhaPokemon.jar`). Push a tag such as `v1.0` (or run the workflow by hand) to publish a release.

The project also opens in Eclipse or NetBeans.
