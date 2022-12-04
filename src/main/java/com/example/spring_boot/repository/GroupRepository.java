package com.example.spring_boot.repository;

import com.example.spring_boot.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long> {

}
