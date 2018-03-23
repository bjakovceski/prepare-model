import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunPython {
    public static void main(String args[]) throws IOException {
        Process process = Runtime.getRuntime().exec("python test.py hello");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        System.out.println(reader.readLine());
        reader.close();
    }
}