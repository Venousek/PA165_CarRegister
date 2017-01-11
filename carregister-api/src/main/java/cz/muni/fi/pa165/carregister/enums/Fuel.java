package cz.muni.fi.pa165.CarRegister.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author blahut
 */
public enum Fuel {
    GASOLINE(0),
    DIESEL(1);
    
    private final int value;
    
    private Fuel(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static Fuel getFuelFromValue(int value) {
        for (Fuel fuel : Fuel.values()) {
            if (fuel.getValue() == value) {
                return fuel;
            }
        }

        return null;
    }
    
    private static final Map<Integer, String> descriptions;

    static {
        Map<Integer, String> descMap = new HashMap<Integer, String>();
        descMap.put(0, "Gasolide");
        descMap.put(1, "Diesel");
        descriptions = Collections.unmodifiableMap(descMap);
    }
    
    public String getDescription() {
        if (descriptions.containsKey(this.value)) {
            return descriptions.get(this.value);
        } else {
            return "";
        }
    }
}

