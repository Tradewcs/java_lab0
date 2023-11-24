package lab3;

import lab1.DirectoryEntry;
import lab1.FileEntry;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DirectoryEntryServiceCollection implements DirectoryEntryService {
    private DirectoryEntry root;

    public DirectoryEntryServiceCollection(DirectoryEntry root) {
        this.root = root;
    }
    @Override
    public List<FileEntry> getSortedFilesByDate(Order order) {
        Comparator<FileEntry> byDate = new Comparator<FileEntry>() {
            @Override
            public int compare(FileEntry o1, FileEntry o2) {
                return order == Order.ASC ? o1.getCreated().compareTo(o2.getCreated()) : o2.getCreated().compareTo(o1.getCreated());
            }
        };

        List<FileEntry> res = root.getFiles();
        res.sort(byDate);

        return res;
    }

    @Override
    public List<FileEntry> getFilesByExtension(String extension) {
        List<FileEntry> result = new ArrayList<>();

        List<FileEntry> files = root.getFiles();
        for (FileEntry file : files) {
            if (file.getName().endsWith("." + extension)) {
                result.add(file);
            }
        }

        return result;
    }

    @Override
    public List<FileEntry> getFilesByPartName(String partName) {
        List<FileEntry> result = new ArrayList<>();

        for (FileEntry fe : root.getFiles()) {
            if (fe.getName().contains(partName)) {
                result.add(fe);
            }
        }

        return result;
    }

    @Override
    public List<FileEntry> getFilesByDateRange(LocalDate from, LocalDate to) {
        List<FileEntry> result = new ArrayList<>();

        for (FileEntry fe: root.getFiles()) {
            if (fe.getCreated().isAfter(from) && fe.getCreated().isBefore(to)) {
                result.add(fe);
            }
        }

        return result;
    }
}
