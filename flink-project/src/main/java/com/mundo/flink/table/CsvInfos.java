package com.mundo.flink.table;

/**
 * @author mundo
 */
public class CsvInfos {

    private String category;

    private String title;

    private String url;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


        @Override
        public String toString() {
                return "CsvInfos{" +
                        "category='" + category + '\'' +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        '}';
        }
}
