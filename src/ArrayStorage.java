import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        boolean isSave = false;
        for (int i = 0; i < storage.length; i++) {
            if (isSave) return;

            if (storage[i] == null) {
                storage[i] = r;
                isSave = true;
            }
        }
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
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid) && i != storage.length - 1) {
                for (int j = i + 1; j < storage.length; j++) {
                    storage[i] = storage[j];
                    i++;
                }
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
