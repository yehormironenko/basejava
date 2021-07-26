package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListSection extends Section {

    private final List<String> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    public ListSection(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "items=" + items +
                '}' + "\n";
    }
}
