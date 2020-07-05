package com.portal.service;

import com.portal.mongo.domain.Bill;
import com.portal.mongo.domain.dto.LastModifiedDto;
import com.portal.mongo.repo.BillRepository;
import com.portal.util.BillType;
import com.portal.util.IdGenerator;
import com.portal.util.Payments;
import com.portal.util.StaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private WalletService walletService;

    @Autowired
    private CashbackService cashbackService;

    public Bill addBill(Bill bill) {
        BillType billType = StaticData.billMap.get(bill.getBillName());
        bill.setBillId(IdGenerator.genBillId(bill.getBillName(), billType));
        bill.setLastModifiedDto(new LastModifiedDto());
        String paymentMode = bill.getBillPaymentMode();
        Bill savedBill = billRepository.insert(bill);
        if (paymentMode.equals(Payments.AMAZON_PAY.name()) ||
                paymentMode.equals(Payments.GOOGLE_PAY.name()) ||
                paymentMode.equals(Payments.PAYTM.name()) ||
                paymentMode.equals(Payments.PHONE_PAY.name())) {
            payFromWallet(paymentMode, (int) savedBill.getBillAmount());
        } else if (paymentMode.equals(Payments.CASH_BACK)) {
            removeCashBack((int) savedBill.getBillAmount());
        }
        if (savedBill.getCashBack() > 0) {
            addCashBack(paymentMode, (int) savedBill.getBillAmount());
        }
        return savedBill;
    }

    public Bill saveBill(Bill bill) {
        Bill savedBill = billRepository.save(bill);
        return savedBill;
    }

    public Optional<Bill> viewBill(String billId) {
        Optional<Bill> viewBill = billRepository.findById(billId);
        return viewBill;
    }

    public void payFromWallet(String walletName, int walletAmount) {
        walletService.payFromWallet(walletAmount, walletName);
    }

    public void updateWallet(String walletName, int walletAmount) {
        walletService.addMoneyWallet(walletAmount, walletName);
    }

    public void addCashBack(String walletName, int walletAmount) {
        walletService.addCashBack(walletAmount, walletName);
        cashbackService.addCashBack(walletAmount);
    }

    public void removeCashBack(int walletAmount) {
        cashbackService.removeCashBack(walletAmount);
    }
}
