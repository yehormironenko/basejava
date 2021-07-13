package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;

class MapStorageTest extends AbstractArrayStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }
}