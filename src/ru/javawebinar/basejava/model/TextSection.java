package ru.javawebinar.basejava.model;

import java.util.Objects;

public class TextSection extends Section {

    private final String textParams;

    public TextSection(String textParams) {
        this.textParams = textParams;
    }

    public String getTextParams() {
        return textParams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return Objects.equals(textParams, that.textParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textParams);
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "textParams='" + textParams + '\'' +
                '}' + "\n";
    }
}
