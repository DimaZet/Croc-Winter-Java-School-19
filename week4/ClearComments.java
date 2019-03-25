package week4;

import java.io.*;

public class ClearComments {
    public static void main(String[] args) {
        try (FileReader in = new FileReader(args[0])) {
            int b='\0',c;
            while ((c = in.read()) != -1){
                if (c == '/') {
                    b = c;
                    c = in.read();
                    if (c == '/') {
                        if((c = skipOneStrComment(in)) != -1)
                            System.out.println();
                    } else if (c == '*') {
                        skipMultyStrComment(in);
                    } else {
                        System.out.print("" + (char)b + (char)c);
                    }
                } else System.out.print((char)c);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int skipOneStrComment(Reader in) throws IOException {
        int c;
        while ((c = in.read()) != '\n' && c != -1);
        return c;
    }

    private static void skipMultyStrComment(Reader in) throws IOException {
        int b, c='\0';
        do {
            b = c;
            c = in.read();
        } while (b != '*' || c != '/');
    }

}