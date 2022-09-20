package Experiments;

import java.io.*;  
class ExpCode  
{  
    public static void main(String args[])  throws FileNotFoundException
    {  
    	String path = System.getProperty("user.dir");
//    	System.out.println(path);
        try{  
        FileInputStream fstream=new FileInputStream(path+"\\src\\"+"Experiments\\ExpCode.java");
        BufferedReader br=new BufferedReader(new InputStreamReader(fstream));  
            //read data line by line from the file  
            String s;  
            while((s = br.readLine() ) != null)  
            {  
                System.out.println(s);  
            }  
            fstream.close();  
        }  
        catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
}  