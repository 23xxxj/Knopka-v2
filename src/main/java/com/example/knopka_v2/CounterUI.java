package com.example.knopka_v2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
class CounterUI extends VerticalLayout {
    private final CounterRepository counterRepository;
    private final CounterActionRepository counterActionRepository;
    private final TextField counterField;
    private Counter counter;

    public CounterUI(CounterRepository counterRepository, CounterActionRepository counterActionRepository) {
        this.counterRepository = counterRepository;
        this.counterActionRepository = counterActionRepository;

        counter = counterRepository.save(new Counter());

        counterField = new TextField("Counter value");
        counterField.setValue(counter.getValue().toString());
        counterField.addValueChangeListener(event -> {
            counter.setValue(Integer.valueOf(event.getValue()));
            counterRepository.save(counter);

            if (event.isFromClient()) {
                CounterAction action = new CounterAction(counter, counter.getValue());
                counterActionRepository.save(action);
            }
        });

        Button incrementButton = new Button("Increment");
        incrementButton.addClickListener(e -> {
            counter.increment();
            counterField.setValue(counter.getValue().toString());
            counterRepository.save(counter);

            CounterAction action = new CounterAction(counter, counter.getValue());
            counterActionRepository.save(action);
        });

        add(counterField, incrementButton);
    }
}