import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Util {

    static String fileInput ="\\input.txt";
    static String fileOutput ="\\output.txt";
    static ArrayList<Long> inputSisi = new ArrayList<Long>();
    
    public static void init(){
        try {
            String lokasi = new File(".").getCanonicalPath();
            fileInput = lokasi + fileInput;
            fileOutput = lokasi + fileOutput;
            System.out.println(lokasi);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    public static void bacaFile(){
        String data;
        FileReader fin =null;
        try {
            fin = new FileReader(fileInput);
            BufferedReader br = new BufferedReader(fin);

            do{
                data= br.readLine();
                if(data!=null) {
                    System.out.println(data);
                    inputSisi.add(Long.parseLong(data));
                }
            }while(data!=null);
    
        }catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());

        }finally{
            if(fin!=null){
                try {
                    fin.close();
                } catch (Exception e) {
                    //TODO: handle exception
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void tulisFile(){
        String data ="Perhitungan Selesai, lihat file 'output.txt'!";
        FileWriter fout = null;
        try {
            fout = new FileWriter(fileOutput);

            for (Long sisi : inputSisi) {
                Long volume = sisi*sisi*sisi;
                fout.write(volume + "\n");
            }

        }catch (Exception e) {
            //TODO: handle exception
                System.out.println(e.getMessage());

        }finally{
            if(fout != null){
                try {
                    fout.close();
                    System.out.println(data);
                } catch (Exception e) {
                    //TODO: handle exception
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
