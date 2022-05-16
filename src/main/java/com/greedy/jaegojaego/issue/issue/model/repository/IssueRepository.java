package com.greedy.jaegojaego.issue.issue.model.repository;

import com.greedy.jaegojaego.issue.issue.model.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Integer> {

    List<Issue> findByFranchiseIssuePresenter_MemberNoOrderByFranchiseIssueCreatedDateDesc(int memberNo);

    List<Issue> findByFranchiseIssuePresenterOrderByFranchiseIssueCreatedDateDesc(int memberNo);

    @Query(value = "SELECT FRANCHISE_ISSUE_NO.CURRVAL " +
            "         FROM DUAL ", nativeQuery = true)
    int selectIssueNo();
}
