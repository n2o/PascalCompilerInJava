# Python Skript um ein Shell Skript zu erstellen, welches alle Testcases durchläuft

1. Navigiere in das Hauptverzeichnis des Compilers (da, wo auch StupsCompiler.java und jasmin.jar gespeichert sind)

2. Alle Testcases müssen im aktuellen Verzeichnis in dem Ordner testCases/ gespeichert sein.

3. In der Shell ausführen:
	> python generateShellScript.py
	> sh shellScript.sh

Alle Testcases werden nun frisch aus der DropBox in einen neuen Ordner kopiert, durch den Compiler gejagt, mit jasmin convertiert und schließlich mit Java ausgeführt.
