import java.io.File;
import java.io.IOException;

public class Rename {

    public static final String FOLDER = "...";
    public static final String[] ext = new String[] {".JPG", ".mp4", ".jpg", ".MP4", ".mov", ".MOV", ".PNG", ".png"};
    
    /**
     * For testing purpose
     * Create empty files with random names following the fomrat "IMG_<[0001, 9999]>" with random extensions in ext
     */
    public static void create() {
        int a = 1;
        while (a < 9999) {
            try {
                File myObj = new File(FOLDER + "IMG_" + name(a) + ext[(int)(Math.random() * ext.length)]);
                myObj.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            a += (int)(Math.random()*100+1);
        }
    }

    /**
     * Rename files in the path FOLDER chronologically according to their names
     */
    public static void rename() {
        int a = 1;
        for (int i = 0; i <= 9999; i++) {
            File temp = extension(i);
            if(temp.exists()) {
                temp.renameTo(new File(FOLDER + name(a) + 
                temp.toString().substring(temp.toString().indexOf("."))));
                a++;
            }
        }
    }

    /**
     * Check the extension of a file and return a File with the correct extension
     * If the file does not exist, return a .txt File
     */
    public static File extension(int a) {
        String b = name(a);
        File f;
        for (int i = 0; i < ext.length; i++) {
            f = new File(FOLDER + "IMG_" + b + ext[i]);
            if (f.exists()) { return f; }
        }
        return new File(FOLDER + "IMG_" + b + ".txt");
    }

    /**
     * Return a length-4 string for naming the files
     * @param a number of the file
     * @return a string of length 4 of the name
     */
    public static String name(int a) {
        String n = "";
        for (int i = 0; i < 4 - String.valueOf(a).length(); i++) {
            n = "0" + n;
        }
        return n + String.valueOf(a);
    }

    public static void main(String[] b) {
        //create();
        rename();
    }
}