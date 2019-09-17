package pl.exercise.tests.order;

import java.io.*;

public class OrderBackup {
    private Writer writer;

    public Writer getWriter(){
        return writer;
    }

    void createFile() throws FileNotFoundException {
        File file = new File("oderBackup.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(outputStreamWriter);
    }

    void backupOrder(Order order) throws IOException {
        writer.append(order.toString());
    }


    void closeWriter() throws IOException {
        writer.close();
    }

}