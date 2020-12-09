/**
 * CityTest is the class
 * which stores information
 * about the path between two cities.
 *
 * @author    Denys Honcharenko
 */
public class CityTest {

    private String firstCity;
    private String secondCity;
    private Way way;

    public CityTest(String firstCity, String secondCity) {
        this.firstCity = firstCity;
        this.secondCity = secondCity;
    }

    public String getFirstCity() {
        return firstCity;
    }

    public void setFirstCity(String firstCity) {
        this.firstCity = firstCity;
    }

    public String getSecondCity() {
        return secondCity;
    }

    public void setSecondCity(String secondCity) {
        this.secondCity = secondCity;
    }

    public Way getWay() {
        return way;
    }

    public void setWay(Way way) {
        this.way = way;
    }

    @Override
    public String toString() {
        return "CityTest{" +
                "firstCity=" + firstCity +
                ", secondCity=" + secondCity +
                ", way=" + way +
                '}';
    }
}
