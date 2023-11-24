package lab3;

import lab1.DirectoryEntry;
import lab1.FileEntry;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DirectoryEntryServiceStreamAPI implements DirectoryEntryService {
    private DirectoryEntry root;

    public DirectoryEntryServiceStreamAPI(DirectoryEntry root) {
        this.root = root;
    }
    @Override
    public List<FileEntry> getSortedFilesByDate(Order order) {
        return root.getFiles().stream()
                .sorted((o1, o2) -> order == Order.ASC ? o1.getCreated().compareTo(o2.getCreated()) : o2.getCreated().compareTo(o1.getCreated()))
                .collect(Collectors.toList());
    }

    @Override
    public List<FileEntry> getFilesByExtension(String extension) {
        return root.getFiles().stream()
                .filter(file -> file.getName().endsWith("." + extension))
                .collect(Collectors.toList());
    }

    @Override
    public List<FileEntry> getFilesByPartName(String partName) {
        return root.getFiles().stream()
                .filter(file -> file.getName().contains(partName))
                .collect(Collectors.toList());
    }

    @Override
    public List<FileEntry> getFilesByDateRange(LocalDate from, LocalDate to) {
        return root.getFiles().stream()
                .filter(file -> file.getCreated().isAfter(from) && file.getCreated().isBefore(to))
                .collect(Collectors.toList());
    }
}
