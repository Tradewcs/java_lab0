package lab1;

import java.util.HashMap;
import java.util.Map;

public class DirectoryEntry extends FileEntry {
    private final DirectoryEntry parent;
    private Map<String, FileEntry> files = new HashMap();

    public DirectoryEntry(DirectoryEntry parent, String name) {
        super(name, 0);
        this.parent = parent;
    }

    public void addFile(FileEntry fe) {
        files.put(fe.getName(), fe);
    }

    public void removeFile(String name) {
        files.remove(name);
    }

    public long size() {
        long size = 0;
        for (FileEntry fe : files.values()) {
            size += fe.size();
        }

        return size;
    }

    public DirectoryEntry getParent() {
        return parent;
    }

    public DirectoryEntry getDirectory(String name) {
        return (DirectoryEntry) files.get(name);
    }

    public Object[] getDirectories() {
        return files.keySet().toArray();
    }
}
