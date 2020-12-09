import java.util.Stack;

/**
 * Way is the class
 * which describes the distance traveled.
 *
 * @author    Denys Honcharenko
 */
public class Way{

    /** Stack stores traversed cities */
    private Stack<City> cities;

    /** Cost of the distance traveled */
    private int cost;

    /**
     * Class constructor.
     */
    public Way(Stack<City> cities, int cost) {
        this.cities = cities;
        this.cost = cost;
    }

    public Stack<City> getCities() {
        return cities;
    }

    public void setCities(Stack<City> cities) {
        this.cities = cities;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Way{" +
                "cities=" + cities +
                ", cost=" + cost +
                '}';
    }
}