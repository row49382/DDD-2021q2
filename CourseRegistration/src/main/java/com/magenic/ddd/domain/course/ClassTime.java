package com.magenic.ddd.domain.course;

import com.magenic.ddd.domain.shared.AuditingBaseEntity;
import com.magenic.ddd.domain.shared.constant.DayOfTheWeek;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class ClassTime extends AuditingBaseEntity {
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    @NotNull
    private Date startTime;

    @NotNull
    private Date endTime;

    @NotNull
    private DayOfTheWeek dayOfTheWeek;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public DayOfTheWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }
}
