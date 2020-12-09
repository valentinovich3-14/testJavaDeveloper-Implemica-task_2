import java.util.*;

/**
 * CitiesAndRoad is the class
 * which finds the paths of minimum cost
 * between pairs of cities.
 *
 * @author    Denys Honcharenko
 */
public class CitiesAndRoad {

    /** The number of tests */
    private int numberOfTests;

    /** The number of cities */
    private int numberOfCities;

    private List<City> cities;
    private List<CityTest> cityTests;


    /**
     * Class constructor.
     */
    public CitiesAndRoad(int numberOfTests, int numberOfCities, List<City> cities, List<CityTest> cityTests) {
        if (numberOfTests > 10){
            System.out.println("Number of tests exceeded, you wrote: " + numberOfTests);
        }else if (numberOfCities > 10000){
            System.out.println("Number of cities exceeded, you wrote: " + numberOfCities);
        }else if (numberOfTests != cityTests.size()){
            System.out.println("Test input error");
        }else {
             this.numberOfTests = numberOfTests;
             this.numberOfCities = numberOfCities;
             this.cities = cities;
             this.cityTests = cityTests;

             cityTests.forEach(cityTest -> findMinRoadBetweenPairsCities(cityTest));
        }
    }

    /**
     * The method finds finds the paths of minimum cost
     * between pairs of cities
     */
    private void findMinRoadBetweenPairsCities(CityTest cityTest){
        Queue<Way> ways = new LinkedList<>();
        List<Way> finishedWays = new ArrayList<>();

        City frstCity = findCity(cityTest.getFirstCity());
        if(frstCity == null){
            System.out.println("Invalid dispatch city name, you wrote: " + cityTest.getFirstCity());
            return;
        }

        City scndCity = findCity(cityTest.getSecondCity());
        if(scndCity == null){
            System.out.println("Invalid dispatch city name, you wrote: " + cityTest.getSecondCity());
            return;
        }

        Stack<City> stack = new Stack<>();
        stack.push(frstCity);
        ways.offer(new Way(stack, 0));

        while (!ways.isEmpty()){
            Way way = ways.poll();
            City city = way.getCities().peek();
            Map<Integer, Integer> costs = new HashMap<>();
            costs.putAll(city.getCosts());



            way.getCities().forEach(c -> costs.remove(c.getId()));

            for (Map.Entry<Integer, Integer> c: costs.entrySet()) {

                int lastCityId = c.getKey();
                City lastCity = findCity(lastCityId);

                Stack<City> cities = new Stack<>();
                cities.addAll(way.getCities());
                cities.add(lastCity);

                int cost = way.getCost() + c.getValue();

                Way newWay = new Way(cities, cost);

                if(newWay.getCities().peek().equals(scndCity)){
                    finishedWays.add(newWay);
                }else{
                    ways.offer(newWay);
                }

            }

        }

        Way minWay = finishedWays.stream().min(Comparator.comparing(Way::getCost)).get();
        cityTest.setWay(minWay);
    }


    /**
     * The method finds city from the list of cities by Name.
     */
    private City findCity(String cityName){
        return cities.stream().filter(c -> c.getName().equals(cityName)).findFirst().get();
    }

    /**
     * The method finds city from the list of cities by Id.
     */
    private City findCity(int cityID){
        return cities.stream().filter(c -> c.getId() == cityID).findFirst().get();
    }

    public int getNumberOfTests() {
        return numberOfTests;
    }

    public void setNumberOfTests(int numberOfTests) {
        this.numberOfTests = numberOfTests;
    }

    public int getNumberOfCities() {
        return numberOfCities;
    }

    public void setNumberOfCities(int numberOfCities) {
        this.numberOfCities = numberOfCities;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<CityTest> getCityTests() {
        return cityTests;
    }

    public void setCityTests(List<CityTest> cityTests) {
        this.cityTests = cityTests;
    }
}
