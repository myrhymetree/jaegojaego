package com.greedy.jaegojaego.materials.model.repository;


import com.greedy.jaegojaego.materials.model.entity.Material;
import com.greedy.jaegojaego.materials.model.entity.MaterialProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MaterialProductRepository extends JpaRepository<MaterialProduct, Integer> {

}
