package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.sql.TransactionTemplate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqlStorage implements Storage {

    private TransactionTemplate transaction;

    public SqlStorage(TransactionTemplate transaction) {
        this.transaction = transaction;
    }

    @Override
    public void clear() {
        transaction.action("DELETE FROM resume", (ps -> {
            ps.execute();
            return null;
        }));
    }

    @Override
    public Resume get(String uuid) {
        return (Resume) transaction.action("SELECT * FROM resume r WHERE r.uuid =?", ps -> {
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                throw new NotExistStorageException(uuid);
            }
            return new Resume(uuid, rs.getString("full_name"));
        });
    }

    @Override
    public void update(Resume r) {
        transaction.action("UPDATE resume r SET  full_name = ? WHERE uuid = ?", ps -> {
            ps.setString(1, r.getUuid());
            ps.setString(2, r.getFullName());
            ps.execute();
            return null;
        });
    }

    @Override
    public void save(Resume r) {
        transaction.action("INSERT INTO resume (uuid, full_name) VALUES (?,?)", ps -> {
            ps.setString(1, r.getUuid());
            ps.setString(2, r.getFullName());
            ps.execute();
            return null;
        });
    }


    @Override
    public List<Resume> getAllSorted() {
        return (List<Resume>) transaction.action("SELECT *  FROM resume order by full_name", ps -> {
            ResultSet rs = ps.executeQuery();
            List<Resume> resumes = new ArrayList<>();
            while (rs.next()) {
                resumes.add(new Resume(rs.getString("uuid").trim(), rs.getString("full_name").trim()));
            }
            return resumes;
        });

    }

    @Override
    public int size() {
        return (Integer) transaction.action("SELECT count(*) as size FROM resume", ps -> {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        });

    }


    @Override
    public void delete(String uuid) {
        transaction.action("DELETE FROM resume r WHERE r.uuid = ?", ps -> {
            ps.setString(1, uuid);
            ps.execute();
            return null;
        });
    }


}