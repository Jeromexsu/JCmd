import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JExec0 {
    public static void main(String[] args) {
        Process p;
        String cmd = "ipconfig /all";

        try{
            p = Runtime.getRuntime().exec(cmd);
            InputStream is=p.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while((line = br.readLine())!=null){ //br读中文乱码
               System.out.println(line);
            }
            int exitVal = p.waitFor();
            System.out.println("Process exit value: "+exitVal);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
