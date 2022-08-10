package fileSystem1;

import java.util.HashMap;

public class Folder {
    private String folderName;
    private HashMap<String, String> files = new HashMap < > ();
    private HashMap<String, Folder> folders = new HashMap < > ();

    public Folder(String newFolderName){
        this.folderName = newFolderName;
    }

    public void setFolderName(String newFolderName) {
        this.folderName = newFolderName;
    }

    public String getFolderName() {
        return folderName;
    }

    public HashMap<String, String> getFiles() {
        return files;
    }

    public HashMap<String, Folder> getFolders() {
        return folders;
    }

    public void addFolder(String newFolderName) {
        Folder newFolder = new Folder(newFolderName);
        folders.put(newFolderName, newFolder);
    }

    //The symbol '◇' represents a file. The symbol '◆' represents a folder.
    //The int spaces represent the distance in print  of files and folder that in a specific folder.
    public void folderToString(int spaces) {
        //Print the root
        System.out.print("◆ "+folderName+":");
       //Print all files from root.
        for (HashMap.Entry<String, String> set : files.entrySet()) {
            System.out.println("");
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
                System.out.print("◇ "+set.getKey());
        }
        System.out.println("");
        //print all folders from root.
        for (HashMap.Entry<String, Folder> set : folders.entrySet()) {
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
            set.getValue().folderToString(spaces+4);
        }
    }



}



