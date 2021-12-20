package com.itransition.santa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "pairs")
public class Pair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "santa_id")
    private Employee santa;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "child_id")
    private Employee child;

    public Pair(Employee santa, Employee child) {
        this.child = child;
        this.santa = santa;
    }

    @Override
    public String toString() {
        return "Пара: " + santa +
                " -> " + child;
    }
}
