import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TestCitiesAndRoad is the test class
 * for testing CitiesAndRoad.
 *
 * @author    Denys Honcharenko
 */
public class TestCitiesAndRoad {

    /**
     * The positive test method for testing findMinRoadBetweenPairsCities method.
     */
    @Test
    public void testFindMinRoadBetweenPairsCities(){

        List<City> cities = new ArrayList<>();

        Map<Integer, Integer> cost1 = new HashMap<>();
        cost1.put(2, 1);
        cost1.put(3, 3);
        cities.add(new City(1, "gdansk", 2, cost1));

        Map<Integer, Integer> cost2 = new HashMap<>();
        cost2.put(1, 1);
        cost2.put(3, 1);
        cost2.put(4, 4);
        cities.add(new City(2, "bydgoszcz", 3, cost2));

        Map<Integer, Integer> cost3 = new HashMap<>();
        cost3.put(1, 1);
        cost3.put(2, 1);
        cost3.put(4, 1);
        cities.add(new City(3, "torun", 3, cost3));

        Map<Integer, Integer> cost4 = new HashMap<>();
        cost4.put(2, 4);
        cost4.put(3, 1);
        cities.add(new City(4, "warszawa", 2, cost4));

        List<CityTest> cityTests = new ArrayList<>();
        cityTests.add(new CityTest("gdansk", "warszawa"));
        cityTests.add(new CityTest("bydgoszcz", "warszawa"));

        CitiesAndRoad citiesAndRoad = new CitiesAndRoad(2, 4, cities, cityTests);

        int actual1 = citiesAndRoad.getCityTests().get(0).getWay().getCost();
        int actual2 = citiesAndRoad.getCityTests().get(1).getWay().getCost();
        Assert.assertEquals(3, actual1);
        Assert.assertEquals(2, actual2);
    }
}
