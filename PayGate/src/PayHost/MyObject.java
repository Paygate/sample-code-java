/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayHost;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * Helper to manipulate dynamic creation of fields
 *
 * @author App Inlet (Pty) Ltd
 * @version 1.0
 * @since 1.0
 */
public class MyObject {

    /**
     * Main data attribute
     */
    private HashMap<String, Object> properties = new HashMap<>();

    /**
     * Init for MyObject with a ready made properties (Clone an existing one)
     *
     * @param properties HashMap {@literal <}String, Object{@literal>} attribute
     */
    public MyObject(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    /**
     * Init for MyObject from scratch with empty properties attribute
     *
     */
    public MyObject() {
    }

    /**
     * Set a value for the key in HashMap
     *
     * @param key String
     * @param value String
     * @return Object
     */
    public Object setProperty(String key, String value) {
        return this.properties.put(key, value); //Returns old value if existing
    }

    /**
     * Get Object by key in HashMap
     *
     * @param key String
     * @return Object
     */
    public Object getProperty(String key) {
        return this.properties.getOrDefault(key, null);
    }

    /**
     * Prints properties as JSON Array String
     */
    public void printProperties() {
        System.out.println(Arrays.asList(this.properties));
    }

    /**
     * Return properties as JSON Array String
     *
     * @return Set of properties
     */
    public Set<String> getPropertiesAsSet() {
        return this.properties.keySet();
    }
}
