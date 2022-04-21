package com.greedy.jaegojaego.menu.repository;

import com.greedy.jaegojaego.menu.entity.RawMaterial;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

@DataJpaTest
@SpringBootTest
public interface MenuRepositoryTests extends JpaRepository<RawMaterial, Integer> {




}
