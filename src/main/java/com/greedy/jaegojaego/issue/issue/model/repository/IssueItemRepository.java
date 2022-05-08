package com.greedy.jaegojaego.issue.issue.model.repository;

import com.greedy.jaegojaego.issue.issue.model.entity.IssueItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueItemRepository extends JpaRepository<IssueItem, Integer> {
}
