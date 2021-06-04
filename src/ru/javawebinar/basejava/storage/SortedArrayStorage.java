package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        if (isItPossible(methodName, r.getUuid())) {
            int index = checkIndexInArray(r.getUuid());
            index = (index + 1) * -1;
            Resume[] rtmp = Arrays.copyOfRange(storage, index, size());
            storage[index] = r;
            System.arraycopy(rtmp, 0, storage, index + 1, rtmp.length);
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        if (isItPossible(methodName, uuid)) {
            int index = checkIndexInArray(uuid);
            index = (index + 1);
            Resume[] rtmp = Arrays.copyOfRange(storage, index, size());
            System.arraycopy(rtmp, 0, storage, index - 1, rtmp.length);
            size--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}