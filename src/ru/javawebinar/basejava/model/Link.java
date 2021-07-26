package ru.javawebinar.basejava.model;

import java.net.URL;
import java.util.Objects;

public class Link {
    private final URL url;

    public Link(URL url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        return Objects.equals(url, link.url);
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }

    public URL getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Link{" +
                "url=" + url +
                '}';
    }
}
