package com.example.SpringbootWeb.repository;

import com.example.SpringbootWeb.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository  <Students, Long>{

}
