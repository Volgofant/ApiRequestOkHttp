import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WorkWithJSON {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    Person person = new Person("Vasya", 34, Arrays.asList("Moscow", "Volgograd", "Berlin"));
    String json = GSON.toJson(person);
//        System.out.println(json);
//
//    Person person1 = GSON.fromJson(json, Person.class);
//        System.out.println(person1.getName() + " " + person1.getAge() + " " + person1.getGeoHistory());
}


class Person {
    public String getName() {
        return name;
    }

    Integer getAge() {
        return age;
    }

    List<String> getGeoHistory() {
        return geoHistory;
    }

    private String name;
    private Integer age;

    @SerializedName("geo")
    private List<String> geoHistory = new ArrayList<>();

    Person(String name, Integer age, List<String> geoHistory) {
        this.name = name;
        this.age = age;
        this.geoHistory = geoHistory;
    }
}