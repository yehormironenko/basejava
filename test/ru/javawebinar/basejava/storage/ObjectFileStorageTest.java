package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;
import ru.javawebinar.basejava.storage.serializer.ObjectStreamSerializer;

public class ObjectFileStorageTest extends AbstractStorageTest {

    public ObjectFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }

    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }
}