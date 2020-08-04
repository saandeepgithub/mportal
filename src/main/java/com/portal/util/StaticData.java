package com.portal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StaticData {

    public final static Map<String,BillType> billTypeMap= new HashMap<>();
    public final static Map<String,Payments> paymentMap=new HashMap<>();
    public final static Map<String,String> billMap = new TreeMap<>();
    public final static Map<Payments,String> walletMap= new TreeMap<>();

   static {
       billTypeMap.put("DTH",BillType.MONTHLY);
       billTypeMap.put("MLK",BillType.MONTHLY);
       billTypeMap.put("ACT",BillType.MONTHLY);
       billTypeMap.put("PTL",BillType.DAILY);
       billTypeMap.put("WB",BillType.MONTHLY);
       billTypeMap.put("CB1",BillType.MONTHLY);
       billTypeMap.put("CB21",BillType.MONTHLY);
       billTypeMap.put("CB22",BillType.MONTHLY);
       billTypeMap.put("CB3",BillType.MONTHLY);
       billTypeMap.put("GRO",BillType.DAILY);
       billTypeMap.put("AMZ",BillType.DAILY);
       billTypeMap.put("MED",BillType.DAILY);
       billTypeMap.put("NV",BillType.DAILY);
       billTypeMap.put("VEG",BillType.DAILY);
       billTypeMap.put("ZZZ",BillType.DAILY);
       billTypeMap.put("MR",BillType.DAILY);

       billMap.put("DTH","DTH");
       billMap.put("MLK","MILK");
       billMap.put("ACT-FIBER","ACT-FIBER");
       billMap.put("PTL","PETROL");
       billMap.put("WB","WATER_BILL");
       billMap.put("CB1","POWER_BILL_FLOOR1");
       billMap.put("CB21","POWER_BILL_FLOOR2_1");
       billMap.put("CB22","POWER_BILL_FLOOR2_2");
       billMap.put("CB3","POWER_BILL_FLOOR3");
       billMap.put("GRO","GROCESSORIES");
       billMap.put("AMZ","AMAZON");
       billMap.put("MED","MEDICINES");
       billMap.put("NV","NON-VEG");
       billMap.put("VEG","VEGETABLES");
       billMap.put("ZZZ","OTHERS");
       billMap.put("MR","MOBILE_RECHARGE");

       paymentMap.put("AP",Payments.AMAZON_PAY);
       paymentMap.put("CB",Payments.CASH_BACK);
       paymentMap.put("CH",Payments.CASH);
       paymentMap.put("CC",Payments.CREDIT_CARD);
       paymentMap.put("DC",Payments.DEBIT_CARD);
       paymentMap.put("GP",Payments.GOOGLE_PAY);
       paymentMap.put("PT",Payments.PAYTM);
       paymentMap.put("PP",Payments.PHONE_PAY);

       walletMap.put(Payments.AMAZON_PAY,"AP");
       walletMap.put(Payments.CASH,"CH");
       walletMap.put(Payments.CREDIT_CARD,"CC");
       walletMap.put(Payments.DEBIT_CARD,"DC");
       walletMap.put(Payments.GOOGLE_PAY,"GP");
       walletMap.put(Payments.PAYTM,"PT");
       walletMap.put(Payments.PHONE_PAY,"PP");
   }
}
