package com.example.mailtest.repository;

import com.example.mailtest.entity.MemberProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberProjectRepository extends JpaRepository<MemberProject, Long> {
}
