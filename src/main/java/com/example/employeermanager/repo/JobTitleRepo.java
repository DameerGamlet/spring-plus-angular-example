package com.example.employeermanager.repo;

import com.example.employeermanager.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepo extends JpaRepository<JobTitle, Long> {
}
