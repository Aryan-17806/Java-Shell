import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            System.out.print("$ ");
            String str = input.nextLine();
            
            String cmd; String rem;

            int space = str.indexOf(" ");
            if(space == -1){
                cmd = str;
                rem = "";
            }
            else{
                cmd = str.substring(0,space);
                rem = str.substring(space+1);
            }

            // exit
            if(cmd.equals("exit")){
                flag = false;
            }

            //echo
            else if(cmd.equals("echo")){
                System.out.println(rem);
            }

            //type
            else if(cmd.equals("type")){
                System.out.println(type(rem));
            }
                /*if(rem.equals("echo") || rem.equals("exit") || rem.equals("type")){
                    System.out.println(rem + " is a shell builtin");
                }
                else{
                    System.out.println(rem + ": not found");
                }
            }*/
                

            // invaild command
            else{
                System.out.println(cmd + ": command not found");
            }
        }
        input.close();
    }
    public static String type(String rem){
        String [] cmd = {"echo","exit","type"};
        String path = System.getenv("PATH");
        //System.out.println("PATH = " + System.getenv("PATH"));
        String[] pathDir = path.split(File.pathSeparator);     //  /usr/local/bin:/usr/bin:/bin   C:\Users\Lenovo\Desktop\ProjectDelta
        
        for (int i = 0; i < cmd.length; i++) {
            if(cmd[i].equals(rem)){
                return rem + " is a shell builtin";
            }
        }

        for(int i = 0 ; i < pathDir.length;i++){

            File file = new File(pathDir[i],rem);

            if(file.exists() && file.canExecute()){
                return rem + " is "+ file.getAbsolutePath();
            }
            
            File exeFile = new File(pathDir[i], rem + ".exe");

            if (exeFile.exists() && exeFile.canExecute()) {
                return rem + " is " + exeFile.getAbsolutePath();
            }
        }
        
        return rem + ": not found";
    }
}
