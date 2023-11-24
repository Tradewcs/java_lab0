package lab3;

import lab1.FileEntry;

import java.time.LocalDate;
import java.util.List;

public interface DirectoryEntryService {
    List<FileEntry> getSortedFilesByDate(Order order);
    List<FileEntry> getFilesByExtension(String extension);
    List<FileEntry> getFilesByPartName(String partName);
    List<FileEntry> getFilesByDateRange(LocalDate from, LocalDate to);

}
