# G O L D E N S Y N T A X
## The Batle Arena

![Diagrammpr](https://github.com/Many-Al/abschlussproject/assets/130827365/8b3f9006-c65f-403b-b6ea-2f219a83c649)



## Features


- 1.Der Spieler wählt zunächst seinen Charakter aus Krieger, Magician und warrior
- 2.Jeder von ihnen erbt von der übergeordneten classe, der Heroclasse
- 3.Der Spieler beginnt das Spiel und trifft auf zwei Arten von Monstern: ein FinalBoss und ein UnderBoss.
  Sie erben von der Opponetclasse.
- 4.Der Spieler beginnt das Spiel und trifft auf zwei Arten von Monstern: ein FinalBoss und ein UnderBoss.

- 5.Die drei Charaktere verfügen je nach Typ über unterschiedliche Fähigkeiten, beispielsweise einen starken Angriff für einen Krieger, Zaubersprüche für einen Magier und hohen Widerstand für einen Kämpfer.
- 6.Der Spieler und seine Feinde erleiden Schaden, wenn sie mächtige Angriffe ausführen oder von feindlichen Angriffen getroffen werden.
Nach Abschluss jeder Runde werden die HP jedes Charakters und Monsters angezeigt
- 7.Der Kämpfer ist mit einer Tasche ausgestattet, die ein Vitamin und drei Medikamente für die drei Runden enthält. Der Charakter kann in   den nächsten Runden Vitamine zur Steigerung der Kraft einnehmen oder Medikamente zur schnellen Genesung einnehmen.
- 8.Der Computer wählt zufällig die Bewegungen der Feinde aus und greift die Kämpfer an.
- 9.Das Spiel geht weiter, bis alle Feinde oder die drei Krieger sterben
- 10.Das Spiel endet und der Punktestand wird angezeigt, wenn alle Monster getötet wurden oder alle drei Charakter sterben.



## Game code erklärung

Dieser Code stellt eine Klasse namens "Spiel" dar, die ein privates Attribut "team" vom Typ "Team", ein privates Attribut "finalboss" vom Typ "Finalboss" und ein privates Attribut "bag" vom Typ "Bag" enthält. Es gibt auch eine optionale Variable "underboss" vom Typ "Opponent", die anfangs auf "null" gesetzt ist, und ein Attribut "userinput" vom Typ "Userinput".
Die Klasse hat eine Methode namens "start()", die den Spielablauf steuert.
Der Code beginnt mit einer Willkommensnachricht, gefolgt von der Anzeige der aktuellen Lebenspunkte der Helden des Teams und des Lebenspunktestands des Endbosses.
Dann beginnt eine Schleife, die solange läuft, wie entweder ein Held im Team am Leben ist und der Endboss oder der Unterboss (falls vorhanden) noch am Leben ist.
Innerhalb dieser Schleife durchläuft der Code alle Helden im Team und überprüft, ob der jeweilige Held noch am Leben ist. Wenn ja, wird eine Aktion für diesen Held ausgeführt. Vor der Ausführung der Aktion wird überprüft, ob ein Unterboss vorhanden ist. Falls ja, wird der Spieler aufgefordert, ein Ziel auszuwählen - entweder den Endboss oder den Unterboss. Basierend auf der Wahl des Spielers wird das entsprechende Ziel ausgewählt und die Aktion wird für den Helden ausgeführt.
Danach wird überprüft, ob der Endboss noch am Leben ist. Falls ja, führt der Endboss eine Aktion gegen das Team aus.
Es wird auch überprüft, ob der Unterboss erstellt werden muss. Wenn das Attribut "isusedunderboss" des Endbosses true ist und der Unterboss noch nicht erstellt wurde, wird ein Unterboss erstellt und eine entsprechende Nachricht wird ausgegeben.
Wenn der Unterboss existiert und noch am Leben ist, führt er eine Aktion gegen das Team aus.
Am Ende jeder Runde werden die aktuellen Lebenspunkte der Helden im Team und des Endbosses angezeigt. Wenn ein Unterboss existiert, werden auch seine aktuellen Lebenspunkte angezeigt.
Sobald die Schleife beendet ist, wird überprüft, ob noch ein Held im Team am Leben ist. Wenn ja, wird eine Glückwunschnachricht ausgegeben. Andernfalls wird eine Nachricht angezeigt, dass das Team besiegt wurde und das Spiel vorbei ist.
