package utils;

import java.util.Date;

public class Utitlity {

    public static final int IMPLICIT_WAIT_TIME=10;
    public static final int PAGE_LOAD_TIME=5;
    public static String generateEmailWithTimeStamp(){
        Date date=new Date();
        String dateText=date.toString().replace(" ","_").replace(":","_");
        return "ali.raza"+dateText+"@gmail.com";
    }
}
