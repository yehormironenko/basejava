package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final String organizationName;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String description;
    private final Link organizationLink;


    public Organization(String organizationName, LocalDate startDate, LocalDate endDate, String description, Link organizationLink) {
        Objects.requireNonNull(organizationName);
        Objects.requireNonNull(startDate);
        Objects.requireNonNull(endDate);
        this.organizationName = organizationName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.organizationLink = organizationLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return organizationName.equals(that.organizationName) && startDate.equals(that.startDate) && endDate.equals(that.endDate) && Objects.equals(description, that.description) && Objects.equals(organizationLink, that.organizationLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationName, startDate, endDate, description, organizationLink);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organizationName='" + organizationName + '\'' +
                ", organizationLink=" + organizationLink +
                ", startDate=" + startDate +
                ", endDate=" +  endDate +
                ", description='" + description + '\'' +
                '}' + "\n";
    }
}
