package com.mundo.etl.test;

import java.util.ArrayList;
import java.util.List;

public class HexTest {

    public static void main(String[] args) {
        //十六转汉字
//        System.out.println(toZh_CN("770B")+" "+toZh_CN("8C01")+" "+
//                toZh_CN("8C01")+" "+toZh_CN("53D8")+" "+toZh_CN("732A"));
//        System.out.println("·   ╭︿︿︿╮ " );
//        System.out.println("{/ o  o /}");
//        System.out.println(" ( (oo) ) ");
//        System.out.println("·  ︶ ︶︶ ");
//        String str = "看谁谁变猪";
//        System.out.println(toCode(str,16));

        System.out.println("(♥^‿^)ﾉﾞ  Mondu启动成功   <-(´ڡ`<-)ﾞ  \n" +
                " .-------.             .-------.        \n" +
                " |  _ _  \\             /  _ _  |        \n" +
                " |  |  \\  \\           /  /  |  |        \n" +
                " |  |   \\  \\         /  /   |  |        \n" +
                " |  |    \\  \\       /  /    |  |        \n" +
                " |  |     \\  \\     /  /     |  |        \n" +
                " |  |      \\  \\   /  /      |  |        \n" +
                " |  |       -- \\ / --       |  |        \n" +
                " ----                       ----      ");

    }
    /*
     * 十六进制编码转换为汉字
     * 参数 为十六进制编码
     */
    public static char toZh_CN(String code){
        //16进制的字符串变10进制的字符串
        String hexString=Integer.valueOf(code,16).toString();
        return (char)Integer.parseInt(hexString);
    }
    public static List<String> toCode(String source, int p) {
        List<String> list = new ArrayList<String>();
        char[] arr = source.toCharArray();
        for (char c : arr) {
            StringBuilder sb = new StringBuilder();
            int tt = c;

            int ii = 0;
            //System.out.println(tt);

            while (tt != 0) {
                ii = tt % p;
                if (ii > 9) {//如果大于9则用A-Z代替
                    sb.insert(0, getData(ii));//插入到最前面
                } else {
                    sb.insert(0, ii);//插入到最前面
                }
                tt = tt / p;
            }
            list.add(sb.toString());
        }

        return list;
    }
    public static String getData(int i) {
        switch (i) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            case 16:
                return "G";
            case 17:
                return "H";
            case 18:
                return "I";
            case 19:
                return "J";
            case 20:
                return "K";
            case 21:
                return "L";
            case 22:
                return "M";
            case 23:
                return "N";
            case 24:
                return "O";
            case 25:
                return "P";
            case 26:
                return "Q";
            case 27:
                return "R";
            case 28:
                return "S";
            case 29:
                return "T";
            case 30:
                return "U";
            case 31:
                return "V";
            case 32:
                return "W";
            case 33:
                return "X";
            case 34:
                return "Y";
            case 35:
                return "Z";

        }
        return "";
    }

}
