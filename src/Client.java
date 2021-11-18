
import java.util.HashMap;
import java.util.Map;

public class Client {
    public Client(String full_name) {
        String[] names=full_name.split(" ");
        this.first_name = names[0];
        this.surname = names[1];
        this.pair=new HashMap<>();
    }

    private String first_name;
    private String surname;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Map<Event, Integer> getPair() {
        return pair;
    }

    public void setPair(Map<Event, Integer> pair) {
        this.pair = pair;
    }

    private Map<Event,Integer> pair;


    @Override
    public String toString() {
        return this.surname+this.first_name;
    }
}
