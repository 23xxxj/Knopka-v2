package com.example.knopka_v2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterActionRepository extends JpaRepository<CounterAction, Long> {
}