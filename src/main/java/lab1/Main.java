package lab1;

public class Main {
    public static void main(String[] args) {
        DirectoryEntry root = new DirectoryEntry(null, "/");
        root.addFile(new FileEntry("file1", 1024));
        root.addFile(new FileEntry("file2", 555));
        root.addFile(new DirectoryEntry(root, "dir1"));
        root.addFile(new DirectoryEntry(root, "dir2"));
        DirectoryEntry de = new DirectoryEntry(root.getSubDirectory("dir1"), "dir1.dir_");
        root.getSubDirectory("dir1").addFile(de);

        
        Explorer explorer = new Explorer(root);
        explorer.enterDirectory("dir1");
        explorer.upDirectory();



    }
}
