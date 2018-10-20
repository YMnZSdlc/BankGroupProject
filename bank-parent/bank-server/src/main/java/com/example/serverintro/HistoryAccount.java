package com.example.serverintro;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
public class HistoryAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private Integer id;
    @Column(name="operaionNo")
    private int operationNo;
    @Column(name="operationTitle")
    private String operationTitle;
    @Column(name="operationDate")
    private Date operationDate;
    @Column(name="transactionType")
    private String transactionType;
    @Column(name="amount")
    private Integer amount;
    @Column(name="currency")
    private String currency;
    @Column(name="senderAccount")
    private int senderAccount;
    @Column(name="recipientAccount")
    private int recipientAccount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public int getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(int operationNo) {
        this.operationNo = operationNo;
    }

    public String getOperationTitle() {
        return operationTitle;
    }

    public void setOperationTitle(String operationTitle) {
        this.operationTitle = operationTitle;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(int senderAccount) {
        this.senderAccount = senderAccount;
    }

    public int getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(int recipientAccount) {
        this.recipientAccount = recipientAccount;
    }
}
