# Beleg_PVS_Mandelbrotmenge

Dieses Projekt berechnet und visualisiert die Mandelbrotmenge mithilfe eines verteilten Systems. Die Berechnungen werden auf mehrere Server verteilt, um die Effizienz zu steigern.

## Projektstruktur

- **client**: Enthält den Client-Code für die Benutzeroberfläche.
- **master**: Enthält den Master-Server-Code, der die Berechnungsaufgaben verteilt.
- **worker**: Enthält den Worker-Server-Code, der die tatsächlichen Berechnungen durchführt.
- **documentation**: Enthält die Dokumentation der Architektur, Implementierung und Ergebnisse.

## Anweisungen zum Ausführen

1. Starten Sie den Master-Server.
2. Starten Sie die Worker-Server.
3. Starten Sie den Client und geben Sie den Zoompunkt ein.

## Anforderungen

- Java JDK 8+
- Netzwerkverbindung zwischen Master und Worker-Servern

## Autoren

- Mateo Thürig -> s85638
