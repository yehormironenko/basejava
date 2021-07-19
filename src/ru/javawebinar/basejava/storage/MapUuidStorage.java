package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO implement
// TODO create new MapStorage with search key not uuid
public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, String searchKey) {
        map.replace(searchKey, r);
    }

    @Override
    protected boolean isExist(String searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    protected void doSave(Resume r, String searchKey) {
        map.putIfAbsent(searchKey, r);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void doDelete(String searchKey) {
        map.remove(searchKey);
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }
}