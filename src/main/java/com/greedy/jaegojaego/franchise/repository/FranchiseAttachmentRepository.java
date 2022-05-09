package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseAttachmentFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FranchiseAttachmentRepository extends JpaRepository<FranchiseAttachmentFile, Integer> {

    FranchiseAttachmentFile findByAttachmentNo(Integer attachmentNo);

    List<FranchiseAttachmentFile> findByFranchiseRepresentativeNo(Integer franchiseRepresentativeNo);
}
