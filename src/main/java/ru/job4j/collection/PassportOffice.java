package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = true;
        for (String key : citizens.keySet()) {
            Citizen value = citizens.get(key);
            if (value.getPassport().equals(citizen.getPassport())) {
                rsl = false;
                break;
            }
        }
        if (rsl) {
            citizens.put(citizen.getPassport(), citizen);
        }
        return rsl;
    }

    public Citizen get(String passport) {
        Citizen pass = null;
        for (String key : citizens.keySet()) {
            if (key.equals(passport)) {
                pass = citizens.get(key);
                break;
            }
        }
        return pass;
    }
}
