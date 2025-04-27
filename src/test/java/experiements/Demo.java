package experiements;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Date date=new Date();
        String dateText=date.toString().replace(" ","_").replace(":","_");
        System.out.println(dateText);

    }
}
