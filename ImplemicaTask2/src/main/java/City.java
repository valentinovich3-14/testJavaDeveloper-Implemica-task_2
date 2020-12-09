import java.util.Map;

/**
 * City is the class
 * which describes the city
 * and connection with other cities
 *
 * @author    Denys Honcharenko
 */
public class City {

    private int id;
    private String name;

    /** The number of cities directly connected to the given city */
    private int numberOfNeighbors;

    /** The map stores city ID and distance */
    private Map<Integer, Integer> costs;

    /**
     * Class constructor.
     */
    public City(int id, String name, int numberOfNeighbors, Map<Integer, Integer> costs) {
        this.id = id;
        this.name = name;
        this.numberOfNeighbors = numberOfNeighbors;
        this.costs = costs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfNeighbors() {
        return numberOfNeighbors;
    }

    public void setNumberOfNeighbors(int numberOfNeighbors) {
        this.numberOfNeighbors = numberOfNeighbors;
    }

    public Map<Integer, Integer> getCosts() {
        return costs;
    }

    public void setCosts(Map<Integer, Integer> costs) {
        this.costs = costs;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfNeighbors=" + numberOfNeighbors +
                ", costs=" + costs +
                '}';
    }
}
