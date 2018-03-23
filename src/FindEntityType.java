import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class FindEntityType {

    private static void readFromAbstract() throws IOException {
        Long start = System.nanoTime();
        String filePath = "C:/Users/Jakovcheski/Desktop/testNIF/AggasiTextFrom-nif-abstract_en.ttl";
        FileInputStream inputStream = null;
        Scanner sc = null;
        Map<String, String> entityType = new LinkedHashMap<>();
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.indexOf("#isString") > 0) {
                    String[] links = line.split(">\\s+");
                    String[] parsedLink = links[0].split("&nif=context");
                    entityType = readFromNifLinks(parsedLink[0]);
                    divadeTextToWordAtLineWithType(links[2], entityType);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        System.err.println(entityType);
        System.err.println("TOTAL TIME: " + ((System.nanoTime() - start) / 1_000_000_000) + " s");
    }

    private static Map<String, String> readFromNifLinks(String link) throws IOException {
        Long start = System.nanoTime();
        Map<String, String> types = new LinkedHashMap<>(); //key: entity, value: type
//        System.err.println("link from abstract " + link);
        String filePath = "C:/Users/Jakovcheski/Desktop/testNIF/AggasiLinksFrom-nif-text-links.ttl";
        FileInputStream inputStream = null;
        Scanner sc = null;
        inputStream = new FileInputStream(filePath);
        sc = new Scanner(inputStream, "UTF-8");
        String word;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] subjectLink = line.split("\\s+");

            if (subjectLink[0].contains(link)) {
                if (subjectLink[1].contains("#taIdentRef")) {
                    String parseEntity = sc.nextLine();
                    String[] entity = parseEntity.split(">\\s+");
//                    System.err.println("Entity " + entity[2].substring(1, entity[2].length()-3));
                    String type = readFromInstanceTypesAndReturnType(subjectLink[2]);
//                    System.err.println("Type " + type);
                    if (!type.equals("OTHER")) {
                        types.put(entity[2].substring(1, entity[2].length() - 3), type); //key: entity, value: type
                    }
                }

            }
        }
        sc.close();
        inputStream.close();
        System.err.println("readFromNifLinks total time: " + (System.nanoTime() - start) / 1_000_000 + " ms");
        return types;
    }

    private static String readFromInstanceTypesAndReturnType(String linkFromNifLinks) throws IOException {
        Long start = System.nanoTime();
        String filePath = "C:/Users/Jakovcheski/Desktop/instance_types_en.ttl";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.err.println("link " + linkFromNifLinks);
            String ontologyType = "OTHER";
            while ((line = br.readLine()) != null) {
                if (line.contains(linkFromNifLinks)) {
                    String[] linkType = line.split(">\\s+<");
                    linkType[2] = linkType[2].substring(0, (linkType[2].length() - 3));
                    String[] type = linkType[2].split("ontology/");
                    if (type.length > 1) {
                        ontologyType = type[1];
                    }
                }
            }
            Long end = (System.nanoTime() - start) / 1_000_000;
            System.err.println("readFromInstanceTypesAndReturnType total time " + end + " ms");
            return ontologyType;
        }
    }

//    private static void test() throws IOException {
//        String filePath = "C:/Users/Jakovcheski/Desktop/instance_types_en.ttl";
//        RandomAccessFile file = new RandomAccessFile(filePath, "r");
//        FileChannel channel = file.getChannel();
//        MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, 1024*700_000);
//        CharBuffer cb = null;
//        cb = Charset.forName("UTF-8").decode(buf);
//        System.err.println(cb);
//    }

    private static void divadeTextToWordAtLineWithType(String text, Map<String, String> entityType) throws FileNotFoundException {
        Long start = System.nanoTime();
        text = text.substring(1, text.length() - 3);
        String[] words = text.split("\\s+");
        String outputPath = "C:/Users/Jakovcheski/Desktop/TestTypesAgassi.ttl";
        PrintWriter p = new PrintWriter(new FileOutputStream(outputPath));

        for (String word : words) {
            if (entityType.containsKey(word)) {
//                a.add(word + "\t" + entityType.get(word));
                p.println(word + "\t" + entityType.get(word));
            } else {
//                a.add(word + "\t" + "OTHER");
                p.println(word + "\t" + "O");
            }
        }
        try {
            p.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("divadeTextToWordAtLineWithType total time " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }

    public static void main(String[] args) {
        try {
            readFromAbstract();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
