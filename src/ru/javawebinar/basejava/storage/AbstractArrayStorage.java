package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[index] = r;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected int checkIndexInArray(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
            return index;
        }
        return index;
    }

    protected boolean isItPossible(String methodName, String uuid) {
        int index = checkIndexInArray(uuid);
        if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
            return false;
        } else if (methodName == "save" && index >= 0) {
            System.out.println("Resume " + uuid + " already exist");
            return false;
        } else if (methodName == "delete" && index < 0) {
            System.out.println("Resume " + uuid + " not exist");
            return false;
        }

        return true;
    }

    public abstract void save(Resume r);

    public abstract void delete(String uuid);

    protected abstract int getIndex(String uuid);

}