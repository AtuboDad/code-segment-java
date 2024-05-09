package com.mundo.flink.table;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.BatchTableEnvironment;
import org.apache.flink.table.sources.CsvTableSource;
import org.apache.flink.types.Row;
import org.junit.Test;

/**
 * @author mundo
 */
public class TableQuerySuite2 {

    @Test
    public void testCsvRead() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        BatchTableEnvironment tableEnv = BatchTableEnvironment.create(env);

        CsvTableSource tableSource = CsvTableSource.builder()
                .path("D:\\workspaces\\selfspaces\\work-apache-project\\data\\test.csv")
                .field("category", DataTypes.STRING())
                .field("title", DataTypes.STRING())
                .field("url", DataTypes.STRING())
                .fieldDelimiter("^")
                .lineDelimiter("\n")
                // .ignoreFirstLine()
                .commentPrefix("%")
                .build();

        DataSet<Row> dataSet = tableSource.getDataSet(env);
        tableEnv.createTemporaryView("hTable", dataSet);
        Table table = tableEnv.sqlQuery("select category,title,url from hTable");
        DataSet<CsvInfos> set = tableEnv.toDataSet(table, CsvInfos.class);
        set.print();
    }

}
