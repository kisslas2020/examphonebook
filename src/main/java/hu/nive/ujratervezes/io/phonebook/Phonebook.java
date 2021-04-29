package hu.nive.ujratervezes.io.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {

        if (contacts == null || output == null) {
            throw new IllegalArgumentException("Null argument");
        }

        Path file = Path.of(output);
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (String name: contacts.keySet()) {
                String line = String.format("%s: %s", name, contacts.get(name));
                writer.write(line + "\n");
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }
}