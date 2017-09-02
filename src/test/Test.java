import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/1 0001.
 */

public class Test {
    public static void main(String[] args) {
        File file=new File("F:/"+"aa.txt");
        Date date =new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String hehe = dateFormat.format(date);
        System.out.println(hehe);
        System.out.println(file.getPath());
    }
}
