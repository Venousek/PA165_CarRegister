/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author blahut
 */
public enum Role {
    USER(0),
    ADMIN(1);
    
    private final int value;
    
    private Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static Role getRoleFromValue(int value) {
        for (Role r : Role.values()) {
            if (r.getValue() == value) {
                return r;
            }
        }

        return null;
    }
    
    private static final Map<Integer, String> descriptions;

    static {
        Map<Integer, String> descMap = new HashMap<Integer, String>();
        descMap.put(0, "User");
        descMap.put(1, "Admin");
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

