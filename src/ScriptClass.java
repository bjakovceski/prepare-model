import java.io.*;
import java.util.*;

public class ScriptClass {

    public static void tokenization() {
        String fileName = "C:/Dev/stanford-ner-2017-06-09/jane-austen-emma-ch2.tok";
//        String fileName = "C:/Users/Jakovcheski/Desktop/nif-page-structure_en.ttl";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
//            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Dev/stanford-ner-2017-06-09/jane-austen-emma-ch1.tsv"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Dev/stanford-ner-2017-06-09/jane-austen-emma-ch2.tsv"));

            while ((line = br.readLine()) != null) {
                writer.write(line + "\tO\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createFileFromTTL() {

//        String fileName = "C:/Users/Jakovcheski/Desktop/sampleFromNIF-PAGE-STRUCTURE.ttl";
        String fileName = "C:/Users/Jakovcheski/Desktop/nif-page-structure_en.ttl"; //BIG FILE with 88_190_517 lines
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            BufferedWriter writerA = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksA.ttl"));
            BufferedWriter writerB = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksB.ttl"));
            BufferedWriter writerC = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksC.ttl"));
            BufferedWriter writerD = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksD.ttl"));
            BufferedWriter writerE = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksE.ttl"));
            BufferedWriter writerF = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksF.ttl"));
            BufferedWriter writerG = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksG.ttl"));
            BufferedWriter writerH = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksH.ttl"));
            BufferedWriter writerI = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksI.ttl"));
            BufferedWriter writerJ = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksJ.ttl"));
            BufferedWriter writerK = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksK.ttl"));
            BufferedWriter writerL = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksL.ttl"));
            BufferedWriter writerM = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksM.ttl"));
            BufferedWriter writerN = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksN.ttl"));
            BufferedWriter writerO = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksO.ttl"));
            BufferedWriter writerP = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksP.ttl"));
            BufferedWriter writerQ = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksQ.ttl"));
            BufferedWriter writerR = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksR.ttl"));
            BufferedWriter writerS = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksS.ttl"));
            BufferedWriter writerT = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksT.ttl"));
            BufferedWriter writerU = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksU.ttl"));
            BufferedWriter writerV = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksV.ttl"));
            BufferedWriter writerW = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksW.ttl"));
            BufferedWriter writerX = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksX.ttl"));
            BufferedWriter writerY = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksY.ttl"));
            BufferedWriter writerZ = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-linksZ.ttl"));

            while ((line = br.readLine()) != null) {
                String[] a = line.split("> ");
                if (a[0] != null) {
                    if (a[0].contains("http://dbpedia.org/resource/A")) {
                        writerA.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/B")) {
                        writerB.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/C")) {
                        writerC.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/D")) {
                        writerD.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/E")) {
                        writerE.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/F")) {
                        writerF.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/G")) {
                        writerG.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/H")) {
                        writerH.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/I")) {
                        writerI.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/J")) {
                        writerJ.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/K")) {
                        writerK.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/L")) {
                        writerL.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/M")) {
                        writerM.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/N")) {
                        writerN.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/O")) {
                        writerO.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/P")) {
                        writerP.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/Q")) {
                        writerQ.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/R")) {
                        writerR.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/S")) {
                        writerS.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/T")) {
                        writerT.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/U")) {
                        writerU.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/V")) {
                        writerV.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/W")) {
                        writerW.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/X")) {
                        writerX.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/Y")) {
                        writerY.write(a[0] + "\n");
                    } else if (a[0].contains("http://dbpedia.org/resource/Z")) {
                        writerZ.write(a[0] + "\n");
                    }
                }
            }
            writerA.close();
            writerB.close();
            writerC.close();
            writerD.close();
            writerE.close();
            writerF.close();
            writerG.close();
            writerH.close();
            writerI.close();
            writerJ.close();
            writerK.close();
            writerL.close();
            writerM.close();
            writerN.close();
            writerO.close();
            writerP.close();
            writerQ.close();
            writerR.close();
            writerS.close();
            writerT.close();
            writerU.close();
            writerV.close();
            writerW.close();
            writerX.close();
            writerY.close();
            writerZ.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cleanDuplicatesFromTTLFile() throws IOException {
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            String fileName = "C:/Users/Jakovcheski/Desktop/big-nif-page-structure_en-links"+ alphabet +".ttl";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            Set<String> lines = new LinkedHashSet<String>(600000); // maybe should be bigger
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/clean-big-nif-page-structure_en-links"+ alphabet +".ttl"));
            for (String unique : lines) {
                writer.write(unique);
                writer.newLine();
            }
            writer.close();
        }
    }


    public static void main(String args[]) {

//        createFileFromTTL();
        try {
//            cleanDuplicatesFromTTLFile();
//            createFileFromTTL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
