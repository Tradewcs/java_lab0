package lab1;

public class Explorer {
    public DirectoryEntry currentDirectory;

    public Explorer(DirectoryEntry de) {
        this.currentDirectory = de;
    }

    public String[] directoriesList() {
        Object[] directories = currentDirectory.getDirectories();
        String[] stringDirectories = new String[directories.length];

        int i = 0;
        for (Object str : directories) {
            stringDirectories[i] = (String) str;
            i++;
        }

        return stringDirectories;
    }

    public void enterDirectory(String name) {
        currentDirectory = currentDirectory.getDirectory(name);
    }

    public void upDirectory() {
        if (currentDirectory.getParent() != null) {
            currentDirectory = currentDirectory.getParent();
        }
    }

}
