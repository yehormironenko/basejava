package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStorageTest {

    protected static final File STORAGE_DIR = new File("D:\\OneDrive - Computaris\\java\\projects\\basejava\\storage");

    protected final Storage storage;

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String USER_1 = "name1";
    private static final String UUID_2 = "uuid2";
    private static final String USER_2 = "name2";
    private static final String UUID_3 = "uuid3";
    private static final String USER_3 = "name3";

    protected static final Resume R1;
    protected static final Resume R2;
    protected static final Resume R3;

    static {
        R1 = new Resume(UUID_1, USER_1);
        R2 = new Resume(UUID_2, USER_2);
        R3 = new Resume(UUID_3, USER_3);
        ResumeTestData.fillResume();
    }

    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() {
        Resume r = storage.get("uuid2");
        storage.update(r);
        assertEquals(r, storage.get("uuid2"));
    }

    @Test
    public void getAllSorted() {
        List<Resume> resumes = storage.getAllSorted();
        assertAll("resumes",
                () -> assertEquals(3, resumes.size()),
                () -> assertEquals(resumes, Arrays.asList(R1, R2, R3)));
    }

    @Test
    public void save() {
        Resume r = new Resume("uuid4", "user4");
        storage.save(r);
        assertEquals(storage.get("uuid4"), r);
    }

    @Test
    public void delete() {
        storage.delete("uuid2");
        assertThrows(NotExistStorageException.class, () -> storage.get("uuid2"));
    }

    @Test
    public void deleteCount() {
        storage.delete("uuid2");
        assertEquals(2, storage.size());
    }

    @Test
    public void get() {
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
    }

    @Test
    public void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get("dummy"));
    }

    @Test
    public void getExist() {
        assertThrows(ExistStorageException.class, () -> storage.save(R1));
    }

    @Test
    void saveOverflow() {
        try {
            for (int i = storage.size(); i < 10000; i++) {
                storage.save(new Resume("new" + i));
            }
        } catch (StorageException e) {
            fail();
        }
        assertEquals(storage.size(), 10000);
        assertThrows(StorageException.class, () -> storage.save(new Resume("new")));
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

}