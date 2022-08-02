import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import jdk.*;

public class Main {

    public static void main(String[] args) throws IOException {

        FileSystem zfs = FileSystems.newFileSystem(Path.of("symlink-demo.zip"));
        FileSystem zfs1 = FileSystems.newFileSystem(Path.of("link.zip"));
        System.out.println(zfs.getClass());
        FileSystem filesystem = FileSystems.getDefault();
        //FileSystem fs1 = FileSystems.newFileSystem(Path.of("/dev/shm"));
        for (FileStore store : zfs.getFileStores()) {

            // Print statement
            System.out.println(store.toString());
        }

        System.out.println(Files.isSymbolicLink(FileSystems.newFileSystem(Path.of("sdsym.zip")).getPath("one.txt")));
        BasicFileAttributes attributes = Files.readAttributes(zfs1.getPath("link"), BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        //BasicFileAttributes attributes = Files.readAttributes(filesystem.getPath("/home/wrkhd/Workspace/JDK-8268856/symlink-demo/symlink"), BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        //System.out.println(Files.isSymbolicLink(filesystem.getPath("/home/wrkhd/Workspace/JDK-8268856/symlink-demo/symlink")));
        System.out.println(attributes.toString());

        ZipFileSystem
    }
}
