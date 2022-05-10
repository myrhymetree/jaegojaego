package com.greedy.jaegojaego.issue.issue.model.repository;

import com.greedy.jaegojaego.issue.issue.model.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Integer> {
    List<IssueHistory> findByIssue_FranchiseIssueNo(int removeIssueNo);
}
