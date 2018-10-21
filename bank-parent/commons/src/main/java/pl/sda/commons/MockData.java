package pl.sda.commons;

import java.util.List;

public class MockData {

    private Integer exammpleId;
    private String exampleFirst;
    private String exampleSecond;
    private List<String> exampleList;

    public MockData() {

    }

    public MockData(Integer exammpleId, String exampleFirst, String exampleSecond, List<String> exampleList) {
        this.exammpleId = exammpleId;
        this.exampleFirst = exampleFirst;
        this.exampleSecond = exampleSecond;
        this.exampleList = exampleList;
    }

    @Override
    public String toString() {
        return "MockData{" +
                "exammpleId=" + exammpleId +
                ", exampleFirst='" + exampleFirst + '\'' +
                ", exampleSecond='" + exampleSecond + '\'' +
                ", exampleList=" + exampleList +
                '}';
    }
}
