package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.Config;
import ru.javawebinar.basejava.exception.StorageException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SqlStorageTest extends AbstractStorageTest {

    public SqlStorageTest() {
        super(new SqlStorage(Config.get().getDbUrl(), Config.get().getDbUser(), Config.get().getDbPassword()));
    }

    @Disabled
    @Override
    void saveOverflow() {
        super.saveOverflow();
    }

    @Override
    @Test
    public void getExist() {
        assertThrows(StorageException.class, () -> storage.save(R1));
    }
}