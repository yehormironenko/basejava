import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, size() - 1, null);
    }


    void update(Resume r) {
        Resume updResume = get(r.uuid);
        if (updResume != null) {
            updResume = r;
        }
        else {
            System.out.println("this resume doe not exist");
        }

    }

    void save(Resume r) {
        if (get(r.uuid) != null) {
            System.out.println("this resume already exists");
            return;
        }
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume == null) return null;
            if (resume.uuid.equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (get(uuid) == null) {
            System.out.println("this resume does not exist");
            return;
        }
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size() - 1];
                storage[size() - 1] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return Arrays.copyOfRange(storage, 0, i);
            }
        }
        return new Resume[0];
    }

    int size() {
        return getAll().length;
    }
}
