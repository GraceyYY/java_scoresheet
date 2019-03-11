package service;

import model.TheClass;

import java.io.*;
import java.util.Optional;

public class Document {
    private File scoreFile;

    public Document() {
        this.scoreFile = new File("./src/scores.txt");
    }

    public Optional<TheClass> readFromFile() {
        Optional<TheClass> currentClass = Optional.empty();
        if (this.scoreFile.length() > 0) {
            try (ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(this.scoreFile))) {
                currentClass = Optional.ofNullable((TheClass) inputFile.readObject());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return currentClass;
    }

    public void writeToFile(TheClass klass) {
        try (ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(this.scoreFile))) {
            outputFile.writeObject(klass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}