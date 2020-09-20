package com.codegym.dao.repository;

import com.codegym.dao.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
    List<Image> findAll();
    List<Image> findByTypeContaining(String type);

}
