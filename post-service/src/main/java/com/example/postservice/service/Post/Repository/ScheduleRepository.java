package com.example.postservice.service.Post.Repository;

import com.example.postservice.service.Post.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
