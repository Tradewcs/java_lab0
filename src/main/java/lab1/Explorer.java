package lab1;

public class Explorer {
    private DirectoryEntry currentDirectory;

    public Explorer(DirectoryEntry de) {
        this.currentDirectory = de;
    }

    /***
     *
     * @param name name of directory to be entered
     */
    public void enterDirectory(String name) {
        currentDirectory = currentDirectory.getSubDirectory(name);
    }

    /***
     * move to the parent directory
     */
    public void upDirectory() {
        if (currentDirectory.getParent() != null) {
            currentDirectory = currentDirectory.getParent();
        }
    }

}
