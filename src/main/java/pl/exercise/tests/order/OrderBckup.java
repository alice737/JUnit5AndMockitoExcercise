package pl.exercise.tests.order;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Writer;

public class OrderBckup {
    private Writer writer;

    public OrderBckup(Writer writer) {
        this.writer = writer;
    }

    void createFile() throws FileNotFoundException {
        File file = new File("oderBackup.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

    }
}
