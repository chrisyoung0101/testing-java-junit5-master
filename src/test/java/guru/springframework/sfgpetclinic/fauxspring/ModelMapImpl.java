package guru.springframework.sfgpetclinic.fauxspring;


import java.util.HashMap;
import java.util.Map;

// TODO : 59
// here we have manually created a mock object where we are mimicking what spring does in fauxspring/Model.java
public class ModelMapImpl implements Model{
    Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {

        map.put(key, o);

    }

    @Override
    public void addAttribute(Object o) {
        // do nothing...
    }

    // allows us to get our map object
    public Map<String, Object> getMap() {
        return map;
    }
}
