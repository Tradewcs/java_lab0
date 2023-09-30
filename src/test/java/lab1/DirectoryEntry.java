package lab1;

import java.util.HashSet;
import java.util.Objects;

public class DirectoryEntry extends FileEntry {
    private final DirectoryEntry parent;
//    private Map<String, FileEntry> files = new HashMap();
    private HashSet<FileEntry> files = new HashSet();

    public static class Builder {
        private DirectoryEntry parent;
        private String name;

        public Builder parent(DirectoryEntry directoryParent) {
            this.parent = directoryParent;
            return this;
        }

        public Builder name(String directoryName) {
            this.name = directoryName;
            return this;
        }

        public DirectoryEntry build() {
            DirectoryEntry de = new DirectoryEntry(this.parent, this.name);
            return de;
        }
    }

    public DirectoryEntry(DirectoryEntry parent, String name) {
        super(name, 0);
        this.parent = parent;
    }

    public void addFile(FileEntry fe) {
        files.add(fe);
    }

    public void removeFile(String name) {
        files.remove(name);
    }

    /***
     *
     * @return size of all files in directory
     */
    public long getSize() {
        long size = 0;
        for (FileEntry fe : files) {
            size += fe.getSize();
        }

        return size;
    }

    public DirectoryEntry getParent() {
        return parent;
    }


    /***
     *
     * @param name name of directory to be returned
     * @return directory with given name
     */
    public DirectoryEntry getSubDirectory(String name) {
        for (FileEntry fe : files) {
            if (fe.getName().equals(name)) {
                return (DirectoryEntry) fe;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        String parentName;
        if (this.parent == null) {
            parentName = "null";
        } else {
            parentName = this.parent.getName();
        }

        String filesNames = "";
        for (FileEntry fe : files) {
            if (fe instanceof FileEntry) {
                filesNames += " " + fe.getName();
            }
        }


        return "DirectoryEntry{" +
                "parent='" + parentName +
                "', files='" + filesNames +
                "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        DirectoryEntry de = (DirectoryEntry) o;
        return this.parent.equals(de.parent) &&
                this.files.equals(de.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, files);
    }


}
