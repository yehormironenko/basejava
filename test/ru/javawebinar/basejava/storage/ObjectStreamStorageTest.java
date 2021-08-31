package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;

public class ObjectStreamStorageTest extends AbstractStorageTest {

    public ObjectStreamStorageTest() {
        super(new ObjectStreamStorage(STORAGE_DIR));
    }

    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }
}