package ru.javawebinar.basejava.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStorageTest {

    protected final Storage storage;

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String USER_1 = "user1";
    private static final String UUID_2 = "uuid2";
    private static final String USER_2 = "user2";
    private static final String UUID_3 = "uuid3";
    private static final String USER_3 = "user3";

    private static final Resume RESUME_1 = new Resume(UUID_1, USER_1);
    private static final Resume RESUME_2 = new Resume(UUID_2, USER_2);
    private static final Resume RESUME_3 = new Resume(UUID_3, USER_3);


    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
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
    public void getAll() {
        List<Resume> resumes = storage.getAllSorted();
        assertAll("resumes",
                () -> assertEquals(resumes.get(0), storage.get("uuid1")),
                () -> assertEquals(resumes.get(1), storage.get("uuid2")),
                () -> assertEquals(resumes.get(2), storage.get("uuid3")));
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
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test
    public void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get("dummy"));
    }

    @Test
    public void getExist() {
        assertThrows(ExistStorageException.class, () -> storage.save(RESUME_1));
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