package fileSystem1;

public class FileSystem {
    private Folder root;

    public FileSystem(String name) {
        root = new Folder(name);
        root.setFolderName(name);
    }

    public boolean addFolderByPath(String pathOfFolderToAdd, String newFolderName) {
        //Check if new folder name is valid.
        if (newFolderName.equals("")) {
            System.out.println("Invalid name");
            return false;
        }
        Folder t = root;
        String[] d = pathOfFolderToAdd.split("/");
        for (int i = 1; i < d.length; i++) {
            // Check if the folder exists
            if (t.getFolders().containsKey(d[i])) {
                //Move on to the next file
                t = t.getFolders().get(d[i]);
            } else if (i != d.length - 1) {
                System.out.println("The folder named " + d[i] + " dose not exists");
                return false;
            }
        }
        //Check if the folder already contains a folder with that name.
        if (t.getFolders().containsKey(newFolderName)){
            System.out.println("This name is already exists in this folder, please try another name.");
            return false;
        }
        //Add folder
        t.addFolder(newFolderName);
        System.out.println("This folder has been successfully added");
        return true;
    }

    public boolean addFileByPath(String pathOfFolderToAdd, String newFileName, String newFileExtention){
        //Check that the strings are valid.
        if (newFileName.equals("") || newFileExtention.equals("")) {
            System.out.println("Invalid name");
            return false;
        }
        Folder t = root;
        String[] d = pathOfFolderToAdd.split("/");
        for (int i = 1; i < d.length; i++) {
            // Check if the folder exists
            if (t.getFolders().containsKey(d[i])) {
                //Move on to the next file
                t = t.getFolders().get(d[i]);
            } else if (i != d.length - 1) {
                System.out.println("The folder named " + d[i] + " dose not exists");
                return false;
            }
        }
        //Check if the folder already contains a file with that name.
        if (t.getFiles().containsKey(newFileName+"."+newFileExtention)) {
            System.out.println("This name is already exists in this folder, please try another name.");
            return false;
        }
        //Add file
        // The char 'a' is just to ensure that two files with the same name will not delete each other,
        // when 2 files have the same name but different value.
        t.getFiles().put(newFileName+"."+newFileExtention, "a");
        System.out.println("This file has been successfully added");
        return true;
    }

    public boolean deleteFolderByPath(String path){
        Folder t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length-1; i++) {
            // check if the folder exists
            if (t.getFolders().containsKey(d[i])) {
                //move on to the next file
                t = t.getFolders().get(d[i]);
            } else if (i != d.length - 1) {
                System.out.println("The folder named " + d[i] + " dose not exists");
                return false;
            }
        }
        //delete folder
        t.getFolders().remove(d[d.length-1]);
        System.out.println("The folder was successfully deleted");
        return true;

    }

    public boolean deleteFileByPath(String path){
        Folder t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length-1; i++) {
            // check if the folder exists
            if (t.getFolders().containsKey(d[i])) {
                //move on to the next file
                t = t.getFolders().get(d[i]);
            } else if (i != d.length - 1) {
                System.out.println("The folder named " + d[i] + " dose not exists");
                return false;
            }
        }
        //delete file
        t.getFiles().remove(d[d.length-1]);
        System.out.println("The folder was successfully deleted");
        return true;
    }

    public boolean rootToString(String path) {
        //Take the last folder from path.
        Folder t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            // check if the folder exists
            if (t.getFolders().containsKey(d[i])) {
                //move on to the next file
                t = t.getFolders().get(d[i]);
            } else if (i != d.length - 1) {
                System.out.println("The folder named " + d[i] + " dose not exists");
                return false;
            }
        }
        // The number 4 was chosen only because it gives the nicest spaces between lines.
        t.folderToString(4);
        return true;
    }

}
