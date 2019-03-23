import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JComplier {
    public static void main(String[] args) {
        try{
            Runtime rt = Runtime.getRuntime();
            String[] cmds= new String[2];
            cmds[0]="javac";
            cmds[1]="HelloCmd.java";
            doCmd(rt,cmds);
            cmds[0]="java";
            cmds[1]="HelloCmd";
            doCmd(rt,cmds);

        }catch (Exception e){

        }
    }

    private static void doCmd(Runtime rt,String[] cmds) {
        try {
            Process p = rt.exec(cmds,null,new File("D:\\IdeaProj\\JCmd\\src"));

            InputStream inputStream = p.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine())!=null){ //br读中文乱码
                System.out.println(line);
            }
            int exitVal = p.waitFor();
            System.out.println("Process exit value: "+exitVal);

        } catch (Exception e){

        }

    }

}
