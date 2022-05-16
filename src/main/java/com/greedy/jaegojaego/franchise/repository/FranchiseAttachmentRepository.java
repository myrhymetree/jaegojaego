package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseAttachmentFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : FranchiseAttachmentRepository
 * Comment : 가맹점 첨부파일 Spring-data JPA 공통 레포지토리 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Repository
public interface FranchiseAttachmentRepository extends JpaRepository<FranchiseAttachmentFile, Integer> {

    /* 첨부파일 번호로 첨부파일을 조회하는 메소드 */
    FranchiseAttachmentFile findByAttachmentNo(Integer attachmentNo);

    /* 해당 가맹점 번호로 첨부파일을 조회하는 메소드 */
    List<FranchiseAttachmentFile> findByFranchiseRepresentativeNo(Integer franchiseRepresentativeNo);
}
