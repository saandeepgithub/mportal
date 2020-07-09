package com.portal.service;

import com.portal.mongo.domain.Bill;
import com.portal.mongo.domain.dto.LastModifiedDto;
import com.portal.mongo.repo.BillRepository;
import com.portal.util.BillType;
import com.portal.util.IdGenerator;
import com.portal.util.Payments;
import com.portal.util.StaticData;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BillService {

    private BillRepository billRepository;

    private WalletService walletService;

    private CashbackService cashbackService;

    private ExpenditureService expenditureService;

    public Bill addBill(Bill bill) {
        BillType billType = StaticData.billMap.get(bill.getBillName());
        bill.setBillId(IdGenerator.genBillId(bill.getBillName(), billType));
        bill.setLastModifiedDto(new LastModifiedDto());
        String paymentMode = bill.getBillPaymentMode();
        Bill savedBill = billRepository.insert(bill);
        if (!paymentMode.equals(Payments.CASH_BACK)) {
            payFromWallet(paymentMode, savedBill.getBillAmount());
            expenditureService.addExpenditure(savedBill.getBillAmount());
        } else {
            removeCashBack(savedBill.getBillAmount());
        }
        if (savedBill.getCashBack() > 0) {
            addCashBack(paymentMode, savedBill.getBillAmount());
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

    private void payFromWallet(String walletName, float walletAmount) {
        walletService.payFromWallet(walletAmount, walletName);
    }

    public void updateWallet(String walletName, float walletAmount) {
        walletService.addMoneyWallet(walletAmount, walletName);
    }

    private void addCashBack(String walletName, float walletAmount) {
        walletService.addCashBack(walletAmount, walletName);
        cashbackService.addCashBack(walletAmount);
    }

    public void removeCashBack(float walletAmount) {
        cashbackService.removeCashBack(walletAmount);
    }
}
