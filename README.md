🏰 **Tower of Hanoi**

Ett klassiskt rekursivt problem implementerat i Java.
Spelet går ut på att flytta alla skivor från den vänstra staven till den högra, enligt följande regler:
Endast en skiva får flyttas åt gången.
En skiva får endast flyttas till en tom stav eller ovanpå en större skiva.


**Beskrivning:**
Projektet är skrivet med objektorienterad programmering i fokus:
Disk → representerar en skiva (immutable, med diameter och färg).
Rod → en stav som fungerar som en stack med regler för skivor.
Tower → själva spelplanen, med tre stavar och logik för drag, flytt och kontroll av lösning.
TowerUi → ett textbaserat gränssnitt för att spela spelet.

**Krav:**
Java 17 eller senare
Kompilator (javac) och JVM (java)
