package com.portal.util;

import com.portal.mongo.domain.Bill;

import java.util.HashMap;
import java.util.Map;

public class StaticData {

    public final static Map<String,BillType> billMap= new HashMap<>();
    public final static BillType ACT=BillType.MONTHLY;
    public final static BillType DTH=BillType.MONTHLY;
    public final static BillType PETROL=BillType.DAILY;
    public final static BillType WATER_BILL=BillType.MONTHLY;
    public final static BillType POWER_BILL_FLOOR1=BillType.MONTHLY;
    public final static BillType POWER_BILL_FLOOR2_1=BillType.MONTHLY;
    public final static BillType POWER_BILL_FLOOR2_2=BillType.MONTHLY;
    public final static BillType POWER_BILL_FLOOR3=BillType.MONTHLY;
    public final static BillType GROCESSORIES=BillType.DAILY;
    public final static BillType AMAZON=BillType.DAILY;
    public final static BillType MOBILE_RECHARGE=BillType.DAILY;
    public final static BillType NON_VEG=BillType.DAILY;
    public final static BillType VEGETABLES=BillType.DAILY;
    public final static BillType MEDICINES=BillType.DAILY;
    public final static BillType OTHERS=BillType.DAILY;

   static {
       billMap.put("DTH",BillType.MONTHLY);
       billMap.put("ACT",BillType.MONTHLY);
       billMap.put("PETROL",BillType.DAILY);
       billMap.put("WB",BillType.MONTHLY);
       billMap.put("CBF1",BillType.MONTHLY);
       billMap.put("CBF2-1",BillType.MONTHLY);
       billMap.put("CBF2-2",BillType.MONTHLY);
       billMap.put("CBF3",BillType.MONTHLY);
       billMap.put("GROCESSORIES",BillType.DAILY);
       billMap.put("AMAZON",BillType.DAILY);
       billMap.put("MEDICINES",BillType.DAILY);
       billMap.put("NON-VEG",BillType.DAILY);
       billMap.put("VEGETABLES",BillType.DAILY);
       billMap.put("OTHERS",BillType.DAILY);
       billMap.put("MOBILE_RECHARGE",BillType.DAILY);
   }
}
