package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "payment_date")
    private Date paymentDate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Customer accountNumber;
    @OneToOne(optional = false)
    @JoinColumn(referencedColumnName = "id")
    private Occupancy firstDateOccupied;
    @OneToOne(optional = false)
    @JoinColumn(referencedColumnName = "id")
    private Occupancy lastDateOccupied;
    @Column(name = "total_days")
    private int totalDays;
    @Column(name = "amount_charged")
    private BigDecimal amountCharged;
    @Column(name = "tax_rate")
    private BigDecimal taxRate;
    @Column(name = "tax_amount")
    private BigDecimal taxAmount;
    @Column(name = "payment_total")
    private BigDecimal paymentTotal;
    @Column(name = "notes", length = 1000)
    private String notes;

    public Payment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Customer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Customer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Occupancy getFirstDateOccupied() {
        return firstDateOccupied;
    }

    public void setFirstDateOccupied(Occupancy firstDateOccupied) {
        this.firstDateOccupied = firstDateOccupied;
    }

    public Occupancy getLastDateOccupied() {
        return lastDateOccupied;
    }

    public void setLastDateOccupied(Occupancy lastDateOccupied) {
        this.lastDateOccupied = lastDateOccupied;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public BigDecimal getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(BigDecimal amountCharged) {
        this.amountCharged = amountCharged;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(BigDecimal paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
