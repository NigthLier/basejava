/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    void clear() {
        for (; storageSize > 0; storageSize--) {
            storage[storageSize] = null;
        }
    }

    void save(Resume r) {
        storage[(storageSize++)] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[storageSize - 1];
                storage[(storageSize--) - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[storageSize];
        System.arraycopy(storage, 0, allResume, 0, storageSize);
        return allResume;
    }

    int size() {
        return storageSize;
    }
}
