package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;

public class ListStorageTest extends AbstractArrayStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }

    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }
}