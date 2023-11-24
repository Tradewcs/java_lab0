package lab3;

import lab1.DirectoryEntry;
import lab1.FileEntry;

import java.util.List;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DirectoryEntry root = new DirectoryEntry("/");
        DirectoryEntry current = root;
        FileEntry fe = new FileEntry("f1.txt", 512);
        current.addFile(new FileEntry("p2.py", 157));
        current.addSubDirectory(new DirectoryEntry("d1"));
        current.addFile(new FileEntry("g3.java", 452));
        current.addFile(new FileEntry("p4.txt", 753));
        current.addFile(fe);

        DirectoryEntryService desc = new DirectoryEntryServiceCollection(root);
        desc = new DirectoryEntryServiceStreamAPI(root);

        printList(desc.getSortedFilesByDate(Order.DESC));
        printList(desc.getFilesByExtension("txt"));
        printList(desc.getFilesByDateRange(LocalDate.of(2023, 11, 18), LocalDate.of(2023, 11, 20)));
        printList(desc.getFilesByPartName("p"));
    }

    public static void printList(List<FileEntry> list) {
        for (FileEntry fe : list) {
            System.out.println(fe.getName());
        }
        System.out.println();
    }
}
