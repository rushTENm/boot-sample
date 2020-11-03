package com.cm.carboot.domain;

import com.cm.carboot.annotation.PII;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Car extends AbstractPersistable<Long> {

    private String model;

    @PII
    private String owner;

}
