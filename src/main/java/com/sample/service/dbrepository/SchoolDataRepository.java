package com.sample.service.dbrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.service.format.Schooldata;

@Repository
public interface SchoolDataRepository extends JpaRepository<Schooldata, Long> {

}
