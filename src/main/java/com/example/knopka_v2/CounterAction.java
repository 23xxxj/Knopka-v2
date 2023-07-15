package com.example.knopka_v2;

import jakarta.persistence.*;

@Entity
class CounterAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "counter_id", referencedColumnName = "id")
    private Counter counter;

    @Column(name = "counter_value")
    private Integer value;

    public CounterAction() {}

    public CounterAction(Counter counter, Integer value) {
        this.counter = counter;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}