package com.greedy.jaegojaego.issue.issue.model.repository;

import com.greedy.jaegojaego.issue.issue.model.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Integer> {
}
