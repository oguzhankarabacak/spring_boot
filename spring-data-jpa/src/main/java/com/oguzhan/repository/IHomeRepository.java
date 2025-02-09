package com.oguzhan.repository;

import com.oguzhan.entities.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHomeRepository extends JpaRepository<Home, Long> {
}
