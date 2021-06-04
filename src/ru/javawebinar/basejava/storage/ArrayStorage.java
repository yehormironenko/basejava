package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void delete(String uuid) {
        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        if (isItPossible(methodName, uuid)) {
            int index = checkIndexInArray(uuid);
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    public void save(Resume r) {
        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        if (isItPossible(methodName, r.getUuid())) {
            storage[size] = r;
            size++;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}