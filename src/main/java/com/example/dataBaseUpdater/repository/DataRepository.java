package com.example.dataBaseUpdater.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dataBaseUpdater.entity.Data;


public interface DataRepository extends JpaRepository<Data,Long> {
    
}
