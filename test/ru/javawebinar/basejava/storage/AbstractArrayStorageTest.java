package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }
}