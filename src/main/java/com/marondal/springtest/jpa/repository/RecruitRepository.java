package com.marondal.springtest.jpa.repository;

import com.marondal.springtest.jpa.domain.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Integer> {

}
