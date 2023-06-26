package filehanding;

import java.io.*;
import java.util.Scanner;

public class FileReaderAndWriter {
    public static void main(String args[]) throws IOException {
        //writing into file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Nagaraju\\OneDrive\\Documents\\Java Documents\\filehand.txt"));
        bufferedWriter.write("Hello this is Nagaraj\n");
        bufferedWriter.write("I am working in Infosys as a Java developer");
        bufferedWriter.close();
        //reading the file
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Nagaraju\\OneDrive\\Documents\\Java Documents\\filehand.txt"));
        String readString;
        while ((readString = reader.readLine()) != null) {
            System.out.println(readString);
        }
        int wordsCount = 0;
        //How to count no.of words in File
        Scanner scanner = new Scanner(new File("C:\\Users\\Nagaraju\\OneDrive\\Documents\\Java Documents\\filehand.txt"));
        while (scanner.hasNext()) {
            String word = scanner.next();
            wordsCount++;
        }
        System.out.println(wordsCount);
    }
}
