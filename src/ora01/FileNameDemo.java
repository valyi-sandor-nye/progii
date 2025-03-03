package ora01;

public class FileNameDemo {
    public static void main(String[] args) {
        final String FPATH = "/home/mem/index.html";
        FileName myHomePage = new FileName(FPATH,
                '/', '.');
        System.out.println("Extension = " +
                myHomePage.extension());
        System.out.println("Filename = " +
                myHomePage.filename());
        System.out.println("Path = " +
                myHomePage.path());
    }
}