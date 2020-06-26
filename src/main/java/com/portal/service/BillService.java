package com.portal.service;

import com.portal.mongo.domain.Bill;
import com.portal.mongo.repo.BillRepository;
import com.portal.mongo.repo.BillTypeRepository;
import com.portal.util.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    private BillRepository billRepository;

    private BillTypeRepository billTypeRepository;

    public BillService(BillRepository billRepository, BillTypeRepository billTypeRepository) {
        this.billRepository = billRepository;
        this.billTypeRepository = billTypeRepository;
    }

    public Bill addBill(Bill bill) {
        String billType=billTypeRepository.findById(bill.getBillName()).get().getBillType();
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
