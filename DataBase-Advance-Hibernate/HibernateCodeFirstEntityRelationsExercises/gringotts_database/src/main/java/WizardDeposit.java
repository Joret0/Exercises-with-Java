import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class WizardDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstName", length = 50)
    private String firstName;

    @Column(name = "lastName", length = 60, nullable = false)
    private String lastName;

    @Column(name = "notes", length = 1000)
    private String notes;

    @Column(name = "age", nullable = false)
    @Min(0)
    private int age;

    @Column(name = "magic_land_creator", length = 100)
    private String magicLandCreator;

    @Column(name = "magic_land_size")
    @Min(1)
    @Max(32768)
    private int magicLandSize;

    @Column(name = "deposit_group", length = 20)
    private String depositGroup;

    @Basic
    private Date depositStartDate;

    @Basic
    private double depositAmount;

    @Basic
    private double depositInterest;

    @Basic
    private double depositCharge;

    @Basic
    private Date depositExpireDate;

    @Basic
    private boolean isDepositExpired;

    public WizardDeposit() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMagicLandCreator() {
        return magicLandCreator;
    }

    public void setMagicLandCreator(String magicLandCreator) {
        this.magicLandCreator = magicLandCreator;
    }

    public int getMagicLandSize() {
        return magicLandSize;
    }

    public void setMagicLandSize(int magicLandSize) {
        this.magicLandSize = magicLandSize;
    }

    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public Date getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(Date depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(double depositInterest) {
        this.depositInterest = depositInterest;
    }

    public double getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(double depositCharge) {
        this.depositCharge = depositCharge;
    }

    public Date getDepositExpireDate() {
        return depositExpireDate;
    }

    public void setDepositExpireDate(Date depositExpireDate) {
        this.depositExpireDate = depositExpireDate;
    }

    public boolean isDepositExpired() {
        return isDepositExpired;
    }

    public void setDepositExpired(boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}
