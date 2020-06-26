package com.portal.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class IdGenerator {

    public static String genBillId(String billName, String billType) {
        SimpleDateFormat simpleDateFormat = null;
        Date date = null;
        if (billType == BillType.DAILY.name()) {
            simpleDateFormat = new SimpleDateFormat("YYYYMMdd");
            Random random = new Random(999);
            return simpleDateFormat.format(new Date()) + billName+random.nextInt();
        } else if (billType == BillType.MONTHLY.name()) {
            simpleDateFormat = new SimpleDateFormat("YYYYMM");
            return simpleDateFormat.format(new Date()) + billName;
        } else if (billType == BillType.YEARLY.name()) {
            simpleDateFormat = new SimpleDateFormat("YYYY");
            return simpleDateFormat.format(new Date()) + billName;
        } else {
            return UUID.randomUUID().toString();
        }
    }

    public static String genIncomeId(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("mmmYYYY");
        return "I"+simpleDateFormat.format(new Date());
    }

    public static String genExpId(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("mmmYYYY");
        return "E"+simpleDateFormat.format(new Date());
    }

    public static String savingsId(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("mmmYYYY");
        return "S"+simpleDateFormat.format(new Date());
    }

    public static String emiId(String emiName){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("mmmYYYY");
        return "EMI"+emiName.toUpperCase()+simpleDateFormat.format(new Date());
    }
}
