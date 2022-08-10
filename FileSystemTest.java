package fileSystem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {


    @Test
    void addFolder() {
        FileSystem root1 = new FileSystem("root1");
        root1.addFolderByPath("root1","test1" );
        assertEquals(false, root1.addFolderByPath("root1","" ));
        assertEquals(false, root1.addFolderByPath("root1","test1" ));
    }

    @Test
    void addFile() {
        FileSystem root1 = new FileSystem("root1");
        root1.addFileByPath("root1","test1","word1");
        assertEquals(false, root1.addFileByPath("root1","test1",""));
        assertEquals(false, root1.addFileByPath("root1","","word1"));
        assertEquals(false, root1.addFileByPath("root1","",""));
        assertEquals(false, root1.addFileByPath("root1","test1","word1"));
    }

    @Test
    void deleteFolder() {
        FileSystem root1 = new FileSystem("root1");
        root1.addFolderByPath("root1","test1");
        root1.addFolderByPath("root1","test2");
        root1.addFolderByPath("root1/test1", "testFolder1_2");
        root1.addFileByPath("root1/test1","test2", "java");
        assertEquals(true, root1.deleteFolderByPath("root1/test1/testFolder1_2"));
        // When you delete a folder, all the files and folders inside are also deleted.
        root1.rootToString("root1");
        root1.deleteFolderByPath("root1/test1");
        root1.rootToString("root1");
    }

    @Test
    void deleteFile() {
        FileSystem root1 = new FileSystem("root1");
        root1.addFileByPath("root1","test1", "java");
        root1.rootToString("root1");
        assertEquals(true, root1.deleteFileByPath("root1/test1.java"));
        root1.rootToString("root1");
    }

    @Test
    void rootToString() {
        FileSystem root1 = new FileSystem("root1");
        root1.addFolderByPath("root1","test1");
        root1.addFolderByPath("root1","test2");
        root1.addFolderByPath("root1/test1", "testFolder1_2");
        root1.addFileByPath("root1/test1","test2", "java");
        root1.addFolderByPath("root1","test3");
        assertEquals(true, root1.rootToString("root1"));
        //Another test of print folder from root folder:
        System.out.println("Print only 'test1' folder:");
        assertEquals(true, root1.rootToString("root1/test1"));
    }

}