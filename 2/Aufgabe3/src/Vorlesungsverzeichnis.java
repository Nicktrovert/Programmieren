import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Vorlesungsverzeichnis {
    private Set<Vorlesung> vorlesungen;

    public Vorlesungsverzeichnis(String filename) throws IOException, TextFileFormatException {
        this.vorlesungen = new HashSet<>();

        if (filename == null || filename.trim().isEmpty()) {
            throw new TextFileFormatException("Dateiname darf nicht leer sein");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(":");

                    if (parts.length != 4) {
                        throw new TextFileFormatException(
                                "Zeile " + lineNumber + ": Formatfehler - erwartet 4 durch ':' getrennte Felder, gefunden " + parts.length
                        );
                    }

                    try {
                        String studiengruppe = parts[0].trim();
                        String titel = parts[1].trim();
                        String dozent = parts[2].trim();
                        int teilnehmerzahl = Integer.parseInt(parts[3].trim());

                        if (teilnehmerzahl < 0) {
                            throw new TextFileFormatException(
                                    "Zeile " + lineNumber + ": Teilnehmerzahl darf nicht negativ sein"
                            );
                        }

                        vorlesungen.add(new Vorlesung(studiengruppe, titel, dozent, teilnehmerzahl));
                    } catch (NumberFormatException e) {
                        throw new TextFileFormatException(
                                "Zeile " + lineNumber + ": Teilnehmerzahl '" + parts[3] + "' ist keine gültige Ganzzahl"
                        );
                    }
                }
            }
        }
    }

    public List<String> titles() {
        return null;
    }

    public Set<String> workaholics() {
        return null;
    }

    public Map<String, List<String>> groupToTitles() {
        return null;
    }

    public Map<String, List<String>> multipleTitles() {
        return null;
    }

    public List<String> descendingTitles() {
        return null;
    }
}