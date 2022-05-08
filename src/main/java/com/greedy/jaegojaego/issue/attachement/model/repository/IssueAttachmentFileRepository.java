package com.greedy.jaegojaego.issue.attachement.model.repository;

import com.greedy.jaegojaego.issue.attachement.model.entity.IssueAttachmentFile;
import com.greedy.jaegojaego.member.model.entity.AttachmentFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueAttachmentFileRepository extends JpaRepository<IssueAttachmentFile, Integer> {

    List<IssueAttachmentFile> findByIssue_FranchiseIssueNoAndAttachmentFileDeleteYn(int issueNo, String deleteYn);
}
