package com.mundo.etl.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateFileData {

    public static void main(String[] args) throws IOException {

        File file = new File("test1.txt");
        FileWriter fw = new FileWriter(file);
        Random random = new Random();
        int rangeNum = 10000000;
        int randomRange = 100000;
        for (int i = 0; i < rangeNum; i++) {
            fw.write("name" + random.nextInt(randomRange)
                    + "\tage" + random.nextInt(randomRange)
                    + "\tcity" + random.nextInt(randomRange)
                    + "\tcolumn1" + random.nextInt(randomRange)
                    + "\tcolumn2" + random.nextInt(randomRange)
                    + "\tcolumn3" + random.nextInt(randomRange)
                    + "\tcolumn4" + random.nextInt(randomRange)
                    + "\tcolumn5" + random.nextInt(randomRange)
                    + "\tcolumn6" + random.nextInt(randomRange)
                    + "\tcolumn7" + random.nextInt(randomRange));
            fw.write("\r\n");
        }

        fw.close();
    }

}
