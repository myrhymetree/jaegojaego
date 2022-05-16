package com.greedy.jaegojaego.client.model.repository;

import com.greedy.jaegojaego.client.model.entity.ClientBusinessType;
import com.greedy.jaegojaego.client.model.entity.ClientContractItemAttachmentFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientContractItemAttachmentFileRepository extends JpaRepository<ClientContractItemAttachmentFile, Integer> {
    ClientContractItemAttachmentFile findByClientContractItem_ClientContractItemNoAndAttachmentFileDeleteYn(int clientContractItemNo, String n);
}
