package pl.sda.commons.services.mockClass;

import java.util.List;

public class MockData {

    private Integer id;
    private String name;
    private String surname;
    private List<String> listOfNames;

    List<MockData> mockDataList;

    public MockData(Integer exammpleId, String name, String surname, List<String> listOfNames) {
        this.id = exammpleId;
        this.name = name;
        this.surname = surname;
        this.listOfNames = listOfNames;
    }

    public List<MockData> getMockDataList() {
        return mockDataList;
    }

    public void setMockDataList(List<MockData> mockDataList) {
        this.mockDataList = mockDataList;
    }

    @Override
    public String toString() {
        return "MockData{" +
                "exammpleId=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", listOfNames=" + listOfNames +
                '}';
    }
}
