package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;
import ru.javawebinar.basejava.storage.serializer.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest {

    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()));
    }

    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }

}