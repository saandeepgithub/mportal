package com.portal.service;

import com.portal.mongo.domain.Bill;
import com.portal.mongo.repo.BillRepository;
import com.portal.util.BillType;
import com.portal.util.IdGenerator;
import com.portal.util.StaticData;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    private BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill addBill(Bill bill) {
        BillType billType= StaticData.billMap.get(bill.getBillName());
        bill.setBillId(IdGenerator.genBillId(bill.getBillName(),billType));
        Bill savedBill=billRepository.insert(bill);
        return savedBill;
    }

    public Bill saveBill(Bill bill) {
        Bill savedBill=billRepository.save(bill);
        return savedBill;
    }

    public Optional<Bill> viewBill(String billId){
       Optional<Bill> viewBill=billRepository.findById(billId);
       return viewBill;
    }
}
