package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;
import ru.javawebinar.basejava.storage.serializer.DataStreamSerializer;

public class DataStreamStorageTest extends AbstractStorageTest {

    public DataStreamStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()));
    }
    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }

}