# Problem prodcenta i konsumenta / Producer–consumer problem

Ćwiczenie problemu synchronizacji w języku Java.

założenia:
- współdzielenie ograniczonego zasobu, jakim jest bufor, między dwoma rodzajami procesów
- producent generuje elementy i próbuje umieścić je w buforze
- jeśli bufor jest pełny, producent musi oczekiwać na zwolnienie miejsca (podobnie konsument pobiera jednostki z bufora, ale oczekuje, gdy bufor jest pusty)
- czas symulacji produkcji danych jest losowy (w danym zakresie)
---

Bounded-buffer problem in Java programming language.
