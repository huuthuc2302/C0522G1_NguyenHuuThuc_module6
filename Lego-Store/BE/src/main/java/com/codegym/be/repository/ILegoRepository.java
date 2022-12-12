package com.codegym.be.repository;

import com.codegym.be.model.Lego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ILegoRepository extends JpaRepository<Lego, Integer> {

    @Query(value = "select * from lego where status_delete = 0 and name like :nameLego", nativeQuery = true)
    List<Lego> findAllLego(@Param("nameLego") String nameLego);

    @Modifying
    @Query(value = "update lego set name = :name, price = :price, release_year = :releaseYear, number_of_pieces = :numberOfPieces, quantity = :quantity, category = :category  where id =:id", nativeQuery = true)
    void updateLego(@Param("name") String name, @Param("price") Double price,
                    @Param("releaseYear") String releaseYear, @Param("numberOfPieces") String numberOfPieces,
                    @Param("quantity") Integer quantity, @Param("category") Integer category, @Param("id") Integer id);

    @Modifying
    @Query(value = "update lego set status_delete = 1 where id = :id", nativeQuery = true)
    void deleteLego(@Param("id") Integer id);

}
