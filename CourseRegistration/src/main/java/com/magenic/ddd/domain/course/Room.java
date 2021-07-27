package com.magenic.ddd.domain.course;

import com.magenic.ddd.domain.shared.AuditingBaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Room extends AuditingBaseEntity {
    @NotEmpty
    private String roomNumber;

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
