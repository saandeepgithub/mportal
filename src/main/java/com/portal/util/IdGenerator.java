package com.portal.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class IdGenerator {

    public static String genBillId(String billName, BillType billType) {
        SimpleDateFormat simpleDateFormat = null;
        Date date = null;
        if (billType == BillType.DAILY) {
            simpleDateFormat = new SimpleDateFormat("YYYYMMMdd");
            String billPreFix=simpleDateFormat.format(new Date()).toUpperCase();
            int billPostFix=new Random().nextInt(999);
            return billPreFix + billName+String.valueOf(billPostFix);
        } else if (billType == BillType.MONTHLY) {
            simpleDateFormat = new SimpleDateFormat("YYYYMMM");
            return simpleDateFormat.format(new Date()).toUpperCase() + billName;
        } else if (billType == BillType.YEARLY) {
            simpleDateFormat = new SimpleDateFormat("YYYY");
            return simpleDateFormat.format(new Date()).toUpperCase() + billName;
        } else {
            return UUID.randomUUID().toString();
        }
    }

    public static String genIncomeId(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MMMYYYY");
        return "IN"+simpleDateFormat.format(new Date()).toUpperCase();
    }

    public static String genExpId(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MMMYYYY");
        return "EX"+simpleDateFormat.format(new Date()).toUpperCase();
    }

    public static String genWalletId(String walletName){
        String walletReference=StaticData.paymentMap.get(walletName);
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MMMYYYY");
        return walletReference+simpleDateFormat.format(new Date()).toUpperCase();
    }

    public static String savingsId(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MMMYYYY");
        return "SA"+simpleDateFormat.format(new Date()).toUpperCase();
    }

    public static String cashBackId(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MMMYYYY");
        return "CB"+simpleDateFormat.format(new Date()).toUpperCase();
    }

    public static String emiId(String emiName){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MMMYYYY");
        return "EMI"+emiName.toUpperCase()+simpleDateFormat.format(new Date()).toUpperCase();
    }
}
