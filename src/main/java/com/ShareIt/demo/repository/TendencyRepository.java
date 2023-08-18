package com.ShareIt.demo.repository;

import com.ShareIt.demo.domain.Tendency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TendencyRepository extends JpaRepository<Tendency,Long> {

    Tendency findByMemberId(Long id);
}
