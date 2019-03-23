import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JExec1 {
    public static void main(String[] args) {
        try{
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("javac");
            InputStream is = p.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            int exitVal = p.waitFor();
            System.out.println("Process exit value: "+exitVal);
        }catch (Exception e){

        }
    }
}
