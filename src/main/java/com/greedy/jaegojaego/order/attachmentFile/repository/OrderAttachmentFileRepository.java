package com.greedy.jaegojaego.order.attachmentFile.repository;

import com.greedy.jaegojaego.order.attachmentFile.entity.OrderAttachmentFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderAttachmentFileRepository extends JpaRepository<OrderAttachmentFile, Integer> {

    OrderAttachmentFile findByOrderItemInfo_ItemInfoNoAndAttachmentFileDeleteYn(int itemInfoNo, String deleteYn);
}
