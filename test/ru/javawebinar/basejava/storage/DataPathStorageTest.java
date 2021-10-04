package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;
import ru.javawebinar.basejava.storage.serializer.DataStreamSerializer;

public class DataPathStorageTest extends AbstractStorageTest {

    public DataPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()));
    }
    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }

}