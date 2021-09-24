package homework5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadWrite {
    public static void main(String[] args) {
        File file1 = new File("1.csv");

        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] inHeader = {"cat", "wolf", "bug"};
        Integer[][] inBody = {{1, 2, 3}, {11, 22, 33}};
        writeData(inHeader, inBody);
        readData();
    }

    public static void writeData(String[] header, Integer[][] body) {

        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.csv", false);
            String tempString1 = Arrays.toString(header);
            for (int c = 0; c < tempString1.length(); c++) {
                if (tempString1.charAt(c) == 44) {
                    outputStream.write(59);
                }
                if (tempString1.charAt(c) == 91 || tempString1.charAt(c) == 93 || tempString1.charAt(c) == 44 || tempString1.charAt(c) == 32) {
                    outputStream.write(("").getBytes(StandardCharsets.UTF_8));
                } else {
                    outputStream.write(tempString1.charAt(c));
                }
            }
            outputStream.write(("\n").getBytes(StandardCharsets.UTF_8));
            for (int i = 0; i < body.length; i++) {
                String tempString2 = Arrays.toString(body[i]);
                for (int c = 0; c < tempString2.length(); c++) {
                    if (tempString2.charAt(c) == 44) {
                        outputStream.write(59);
                    }
                    if (tempString2.charAt(c) == 91 || tempString2.charAt(c) == 93 || tempString2.charAt(c) == 44 || tempString2.charAt(c) == 32) {
                        outputStream.write(("").getBytes(StandardCharsets.UTF_8));
                    }else{
                        outputStream.write(tempString2.charAt(c));
                    }
                }
                outputStream.write(("\n").getBytes(StandardCharsets.UTF_8));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readData() {
        String[] headerArr;
        ArrayList<Integer[]> bodyArr = new ArrayList<>();

        String tempString;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("1.csv"));
            tempString = bufferedReader.readLine();
            headerArr = tempString.split(";");
            while ((tempString = bufferedReader.readLine()) != null) {
                String[] parametersArr = tempString.split(";");
                Integer[] integers = new Integer[parametersArr.length];
                for (int i = 0; i < parametersArr.length; i++) {
                    integers[i] = Integer.parseInt(parametersArr[i]);
                }
                bodyArr.add(integers);
            }
            System.out.println(Arrays.toString(headerArr));
            System.out.println(Arrays.deepToString(bodyArr.toArray()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
