package com.portal.service;

import com.portal.mongo.domain.Bill;
import com.portal.mongo.domain.dto.LastModifiedDto;
import com.portal.mongo.repo.BillRepository;
import com.portal.util.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BillService {

    private BillRepository billRepository;

    private WalletService walletService;

    private CashbackService cashbackService;

    private ExpenditureService expenditureService;

    public Bill addBill(Bill bill) {
        BillType billType = StaticData.billTypeMap.get(bill.getBillName());
        bill.setBillId(IdGenerator.genBillId(bill.getBillName(), billType));
        bill.setBillName(StaticData.billMap.get(bill.getBillName()));
        LastModifiedDto lastModifiedDto = new LastModifiedDto();
        lastModifiedDto.setLastModifiedDate(new Date(System.currentTimeMillis()));
        bill.setLastModifiedDto(lastModifiedDto);
        Bill savedBill = billRepository.insert(bill);
        if (savedBill != null) {
            Payments paymentMode = StaticData.paymentMap.get(savedBill.getBillPaymentMode());
            PaymentType paymentType = PortalUtils.getPaymentType(paymentMode);
            if (!paymentType.equals(PaymentType.CASHABCK)) {
                walletService.payFromWallet(savedBill.getBillAmount(), savedBill.getBillPaymentMode());
                expenditureService.addExpenditure(savedBill.getBillAmount());
            } else {
                cashbackService.removeCashBack(savedBill.getBillAmount());
            }
        }
        if (savedBill.getCashBack() > 0) {
            cashbackService.addCashBack(savedBill.getCashBack());
            expenditureService.addCashBackToExpenditure(savedBill.getCashBack());
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

    public List<String> getAllBillId(String billPreFix) {
      List<Bill> bills=billRepository.getByBillIdIsStartingWith(billPreFix);
      List<String> billIds=bills.stream().map(bill ->bill.getBillId()).collect(Collectors.toList());
      return billIds;
    }

    public Optional<Bill> getBillByBillId(String billId) {
        Optional<Bill> optionalBill=billRepository.getAllByBillIdEquals(billId);
        return optionalBill;
    }
}
