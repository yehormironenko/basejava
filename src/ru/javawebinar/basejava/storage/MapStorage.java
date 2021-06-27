package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
        size = 0;
    }

    @Override
    public void update(Resume r) {
        if (storage.replace(r.getUuid(), r) == null) {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public Resume get(String uuid) {
        if (storage.get(uuid) != null) {
            return storage.get(uuid);
        } else throw new NotExistStorageException(uuid);
    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    public void save(Resume r) {
        if (storage.putIfAbsent(r.getUuid(), r) != null) {
            throw new ExistStorageException(r.getUuid());
        } else {
            size++;
        }

    }

    @Override
    public void delete(String uuid) {
        if (storage.remove(uuid) != null) {
            size--;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }
}
