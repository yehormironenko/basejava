package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;

class MapResumeStorageTest extends AbstractArrayStorageTest {

    public MapResumeStorageTest() {
        super(new MapResumeStorage());
    }

    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }
}
