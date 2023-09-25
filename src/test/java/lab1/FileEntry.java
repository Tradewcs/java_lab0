package lab1;

import java.util.Objects;

public class FileEntry {
    private String name;
    private long size;

    public FileEntry(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long size() {
        return size;
    }

}
