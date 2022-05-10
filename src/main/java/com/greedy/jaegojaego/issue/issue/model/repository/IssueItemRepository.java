package com.greedy.jaegojaego.issue.issue.model.repository;

import com.greedy.jaegojaego.issue.issue.model.entity.IssueItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueItemRepository extends JpaRepository<IssueItem, Integer> {
    List<IssueItem> findByIssue_FranchiseIssueNo(int franchiseIssueNo);
}
