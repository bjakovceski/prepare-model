import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindEntityTypeWithBufferReader {
    private static void readFromAbstract() throws IOException {
        Long start = System.nanoTime();
        String filePath = "C:/Users/Jakovcheski/Desktop/testNIF/AggasiTextFrom-nif-abstract_en.ttl";

        Map<String, String> entityType = new HashMap<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = in.readLine()) != null) {
                // process line here.
                if (line.indexOf("#isString") > 0) {
                    String[] links = line.split(">\\s+<");
                    String[] a = links[0].split("&nif=context");

                    entityType = readFromNifLinks(a[0]);

                }
            }
            System.err.println(entityType);
            System.err.println("TOTAL TIME: " + ((System.nanoTime() - start) / 1_000_000_000) + " s");
        }
    }

    private static Map<String, String> readFromNifLinks(String link) throws IOException {
        Map<String, String> types = new HashMap<>(); //key: entity, value: type
//        System.err.println("link from abstract " + link);
        String filePath = "C:/Users/Jakovcheski/Desktop/testNIF/AggasiLinksFrom-nif-text-links.ttl";
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] subjectLink = line.split("\\s+");
                if (subjectLink[0].contains(link)) {
                    if (subjectLink[1].contains("#taIdentRef")) {
                        String parseEntity = in.readLine();
                        String[] entity = parseEntity.split(">\\s+");
                        String type = readFromInstanceTypesAndReturnType(subjectLink[2]);
                        if (!type.equals("OTHER")) {
                            types.put(entity[2].substring(1, entity[2].length() - 3), type); //key: entity, value: type
                        }
                    }
                }
            }
        }

        return types;
    }

    private static String readFromInstanceTypesAndReturnType(String linkFromNifLinks) throws IOException {
        String filePath = "C:/Users/Jakovcheski/Desktop/instance_types_en.ttl";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
//            System.err.println("link " + linkFromNifLinks);
            String ontologyType = "OTHER";
            System.err.println(linkFromNifLinks);
            while ((line = br.readLine()) != null) {
                if (line.contains(linkFromNifLinks)) {
                    String[] linkType = line.split(">\\s+<");
                    linkType[2] = linkType[2].substring(0, (linkType[2].length() - 3));
                    String[] type = linkType[2].split("ontology/");
                    if (type.length > 1)
                        ontologyType = type[1];
                }
            }
            return ontologyType;
        }
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
