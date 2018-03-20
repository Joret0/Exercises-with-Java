package entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "room_number", unique = true)
    private String roomNumber;
    @ManyToOne(optional = false)
    @JoinColumn(name = "room_type_id", referencedColumnName = "id")
    private RoomType roomType;
    @ManyToOne(optional = false)
    @JoinColumn(name = "bed_type_id", referencedColumnName = "id")
    private BedType bedType;
    @Column(name = "rate")
    private BigDecimal rate;
    @ManyToOne()
    @JoinColumn(name = "room_status_id", referencedColumnName = "id")
    private RoomStatus roomStatus;
    @Column(name = "notes", columnDefinition = "text")
    private String notes;

    public Room() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
