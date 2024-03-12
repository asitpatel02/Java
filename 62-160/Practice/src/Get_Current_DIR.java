import java.nio.file.Paths;

public class Get_Current_DIR {

    public static void main(String[] args) {

        String path = System.getProperty("user.dir");

        System.out.println("Working Directory = "+path);

        String path2 = Paths.get("").toAbsolutePath().toString();

        System.out.println("Working Directory = " + path2);
    }
}
