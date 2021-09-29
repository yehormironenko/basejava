package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;
import ru.javawebinar.basejava.storage.serializer.ObjectStreamSerializer;

public class ObjectPathStorageTest extends AbstractStorageTest {

    public ObjectPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer()));
    }

    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }
}