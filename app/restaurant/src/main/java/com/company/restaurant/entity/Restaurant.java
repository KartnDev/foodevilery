package com.company.restaurant.entity;

import com.company.commonlib.entity.Location;
import io.jmix.core.DeletePolicy;
import io.jmix.core.FileRef;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@JmixEntity
@Table(name = "RSTRNT_RESTAURANT", indexes = {
        @Index(name = "IDX_RSTRNT_RESTAURANT_LOCATION", columnList = "LOCATION_ID")
})
@Entity(name = "rstrnt_Restaurant")
@Getter
@Setter
public class Restaurant {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @Composition
    @JoinColumn(name = "LOCATION_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Location location;

    @NotNull
    @InstanceName
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ICON", length = 1024)
    private FileRef icon;

    public FileRef getIcon() {
        return icon;
    }

    public void setIcon(FileRef icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}