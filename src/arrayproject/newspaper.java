package arrayproject;

import java.io.*;
import java.util.*;

/**
 * @author george oster
 */
public class newspaper implements Serializable {

    String name;
    String circulation;
    String city;
    String state;
    String ISSN;

    public newspaper() {
    }

    public newspaper(String nam, String cir, String cit, String sta, String ISS) {
        name = nam;
        circulation = cir;
        city = cit;
        state = sta;
        ISSN = ISS;
    }

    public String getName() {
        return name;
    }

    public String getCirculation() {
        return circulation;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setName(String nam) {
        name = nam;
    }

    public void setCirculation(String cir) {
        circulation = cir;
    }

    public void setCity(String cit) {
        city = cit;
    }

    public void setState(String sta) {
        state = sta;
    }

    public void setISSN(String ISS) {
        ISSN = ISS;
    }

    public String toString() {
        String whatIsHappening = "name: " + name + " circulation: " + circulation + " city: " + city + " state: " + state + " ISSN: " + ISSN;
        return whatIsHappening;
    }

}//end class newspaper

