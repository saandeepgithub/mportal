package com.portal.util;

import com.portal.mongo.domain.Bill;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StaticData {

    public final static Map<String,BillType> billMap= new TreeMap<>();
    public final static Map<String,String> paymentMap=new HashMap<>();
    public final static String ACT="ACT";
    public final static String DTH="DTH";
    public final static String PETROL="PETROL";
    public final static String WATER_BILL="WATER_BILL";
    public final static String CBF1="POWER_BILL_FLOOR1";
    public final static String CBF2_1="POWER_BILL_FLOOR2_1";
    public final static String CBF2_2="POWER_BILL_FLOOR2_2";
    public final static String CBF3="POWER_BILL_FLOOR3";
    public final static String GROCESSORIES="GROCESSORIES";
    public final static String AMAZON="AMAZON";
    public final static String MOBILE_RECHARGE="MOBILE_RECHARGE";
    public final static String NON_VEG="NON_VEG";
    public final static String VEGETABLES="VEGETABLES";
    public final static String MEDICINES="MEDICINES";
    public final static String OTHERS="OTHERS";

   static {
       billMap.put("DTH",BillType.MONTHLY);
       billMap.put("ACT-FIBER",BillType.MONTHLY);
       billMap.put("PETROL",BillType.DAILY);
       billMap.put("WATER_BILL",BillType.MONTHLY);
       billMap.put("POWER_BILL_FLOOR1",BillType.MONTHLY);
       billMap.put("POWER_BILL_FLOOR2_1",BillType.MONTHLY);
       billMap.put("POWER_BILL_FLOOR2_2",BillType.MONTHLY);
       billMap.put("POWER_BILL_FLOOR3",BillType.MONTHLY);
       billMap.put("GROCESSORIES",BillType.DAILY);
       billMap.put("AMAZON",BillType.DAILY);
       billMap.put("MEDICINES",BillType.DAILY);
       billMap.put("NON-VEG",BillType.DAILY);
       billMap.put("VEGETABLES",BillType.DAILY);
       billMap.put("OTHERS",BillType.DAILY);
       billMap.put("MOBILE_RECHARGE",BillType.DAILY);

       paymentMap.put(Payments.AMAZON_PAY.name(),"AP");
       paymentMap.put(Payments.CASH.name(),"CA");
       paymentMap.put(Payments.CASH.name(),"CB");
       paymentMap.put(Payments.CREDIT_CARD.name(),"CC");
       paymentMap.put(Payments.DEBIT_CARD.name(),"DC");
       paymentMap.put(Payments.GOOGLE_PAY.name(),"GP");
       paymentMap.put(Payments.PAYTM.name(),"PT");
       paymentMap.put(Payments.PHONE_PAY.name(),"PP");
   }
}
