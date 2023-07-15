package com.example.knopka_v2;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "counter_value")
    private Integer value;

    public Counter() {
        this.value = 0;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Transactional
    public void increment() {
        this.value++;
    }
}
