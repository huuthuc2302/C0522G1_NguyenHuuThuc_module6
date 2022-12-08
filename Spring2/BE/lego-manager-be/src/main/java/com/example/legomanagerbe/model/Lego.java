package com.example.legomanagerbe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    private String releaseYear;

    private String numberOfPieces;

    private Integer quantity;

    @Column(columnDefinition = "text")
    private String imageUrl;

    @Column(name = "status_delete", columnDefinition = "BIT")
    private Integer statusDelete = 0;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

}
