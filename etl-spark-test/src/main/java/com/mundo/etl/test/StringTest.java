package com.mundo.etl.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class StringTest {


    public static String hexString2String(String src) {
        String temp = "";
        for (int i = 0; i < src.length() / 2; i++) {
            temp = temp
                    + (char) Integer.valueOf(src.substring(i * 2, i * 2 + 2),
                    16).byteValue();
        }
        return temp;
    }

    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(
                        s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "gbk");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    @Test
    public void test1() {
        String a = "a_d_";
        String b = a.substring(0, a.length() - 1);
        System.out.println(b);
    }

    public static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }

    @Test
    public void test2() {
        Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    @Test
    public void test3() throws IOException {
        File file = new File("C:\\workspaces\\ideaspaces\\onlyou-cdh-spark\\data\\f_software_copyright_info_100000.txt");
        File dest = new File("C:\\workspaces\\ideaspaces\\onlyou-cdh-spark\\data\\f_software_copyright_info_1000002.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line + "),");
                writer.newLine();
                line = reader.readLine();
            }
            writer.flush();
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() throws IOException {
        File file = new File("C:\\workspaces\\ideaspaces\\onlyou-cdh-spark\\data\\test1.txt");
        File dest = new File("C:\\workspaces\\ideaspaces\\onlyou-cdh-spark\\data\\test2.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
            String line = reader.readLine();
            while (line != null) {
                String[] strings = line.split(" ,");

                for (String string : strings) {
                    String[] splits = string.split("\\|");

                    if ("X0100047-X0100059-X0100023-X0100075-Z0100056-X0100018-X0100061-Z0100030-X0100049".contains(splits[0])) {
                        writer.write(string);
                        writer.newLine();
                    }
                    line = reader.readLine();
                }
            }
            writer.flush();
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() throws IOException {
        for (int i = 0; i < 55; i++) {
            System.out.println("      case " + (15 + i) + " =>");
            for (int j = 0; j < (15 + i); j++) {
                System.out.println("        var item" + j + " = splits(" + j + ")");
                System.out.println("        if (\"NULL\".equalsIgnoreCase(item" + j + ")) {");
                System.out.println("          item" + j + " = \"\"");
                System.out.println("        }");
            }
            System.out.println("        val columnBean = RowFactory.create(");
            String str = "";
            for (int j = 0; j < (15 + i); j++) {
                if (j == (15 + i - 1)) {
                    str += "item" + j;
                } else {
                    str += "item" + j + ",";
                }

            }
            System.out.println(str);
            System.out.println("        )");
            System.out.println("        columnBean");
        }
    }

    @Test
    public void test6() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("test", "test\ttest");
        String s = JSON.toJSONString(data);
        System.out.println(s);
        HashMap hashMap = JSON.parseObject(s, HashMap.class);
        System.out.println(hashMap);
        for (Object o : hashMap.values()) {
            String[] split = o.toString().split("\t");
            for (String s1 : split) {
                System.out.println(s1);
            }
        }
    }

    @Test
    public void test7() {
        System.out.println(randomString(-229985452) + " " + randomString(-147909649));
    }

    public String randomString(int i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            sb.append((char) ('`' + k));
        }
        return sb.toString();
    }


}
