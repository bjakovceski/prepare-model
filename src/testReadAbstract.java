import java.io.*;
import java.util.Scanner;

public class testReadAbstract {

    public static void tokenization() throws IOException {
        Long start = System.nanoTime();
        String filePath = "C:/USers/Jakovcheski/Desktop/nif-abstract/nif-abstract-context_en.ttl";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/USers/Jakovcheski/Desktop/prepared-nif-abstract-context_en.ttl"));

            while ((line = br.readLine()) != null) {
//                System.err.println(line.split("\\s+"));
                String words[] = line.split("\\s+");
                for (String s : words) {
                    writer.write(s + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream inputStream = null;
        Scanner sc = null;
        String outputPath = "C:/USers/Jakovcheski/Desktop/Stream2TESTnif-abstract-context_en.ttl";
        PrintWriter p = new PrintWriter(new FileOutputStream(outputPath));
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String words[] = line.split("\\s+");
//                System.out.println(line);
                for (String s : words) {
                    System.err.println(s);
                    p.println(s + "\n");
                }
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
                p.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        System.err.println("total time: " + (System.nanoTime() - start));
    }

    public static void copyFromLinksToTestFile() throws IOException {
        String filePath = "C:/USers/Jakovcheski/Desktop/nif-text-links/nif-text-links_en.ttl";
        FileInputStream inputStream = null;
        Scanner sc = null;
        String outputPath = "C:/USers/Jakovcheski/Desktop/links.ttl";
        PrintWriter p = new PrintWriter(new FileOutputStream(outputPath));
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            int i = 0;
            while (sc.hasNextLine() && i < 10_000_000) {
                String line = sc.nextLine();
                p.println(line);
                System.err.println(i);
                i++;
//                String words[] = line.split("\\s+");
////                System.out.println(line);
//                for (String s : words) {
//                    System.err.println(s);
//                    p.println(s + "\n");
//                }
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
                p.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    public static void readInstanceTypes() {
        Long start = System.nanoTime();
        String filePath = "C:/USers/Jakovcheski/Desktop/instance_types_en.ttl";
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("/ontology/Book")) {
                    i++;
                    String[] links = line.split(">\\s+<");
                    for (String s : links) {
                        System.err.println(s + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.err.println("total annotations " + i);
        System.err.println("total time: " + (System.nanoTime() - start));
    }

    public static void main(String args[]) {
        //            tokenization();
//        readInstanceTypes();
        try {
            copyFromLinksToTestFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
