package com.magenic.ddd.domain.course;

import com.magenic.ddd.domain.shared.AuditingBaseEntity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Location extends AuditingBaseEntity {
    @NotNull
    @OneToOne(targetEntity = Room.class)
    private Room room;

    @NotEmpty
    @OneToMany(mappedBy = "location")
    private List<ClassTime> classTimes;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<ClassTime> getClassTimes() {
        return classTimes;
    }

    public void setClassTimes(List<ClassTime> classTimes) {
        this.classTimes = classTimes;
    }
}
