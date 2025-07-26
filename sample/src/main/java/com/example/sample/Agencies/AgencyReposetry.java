package com.example.sample.Agencies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyReposetry extends JpaRepository<Agency, Long> {
    // You can add custom query methods if needed
}
