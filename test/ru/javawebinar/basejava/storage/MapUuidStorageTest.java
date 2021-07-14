package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;

class MapUuidStorageTest extends AbstractArrayStorageTest {

    public MapUuidStorageTest() {
        super(new MapUuidStorage());
    }

    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }
}