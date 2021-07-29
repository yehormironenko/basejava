package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;


public class OrganizationSection extends Section {

   private final Map<String, ArrayList<Organization>> ogranizationMap;// =  new HashMap<>()

    public OrganizationSection(Map<String, ArrayList<Organization>> ogranizationMap) {
        Objects.requireNonNull(ogranizationMap, "organizations must not be null");
        this.ogranizationMap = ogranizationMap;
    }

    public Map<String, ArrayList<Organization>> getOgranizationMap() {
        return ogranizationMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return ogranizationMap.equals(that.ogranizationMap);

    }

    @Override
    public int hashCode() {
        return ogranizationMap.hashCode();
    }

    @Override
    public String toString() {
        return ogranizationMap.toString();
    }
}