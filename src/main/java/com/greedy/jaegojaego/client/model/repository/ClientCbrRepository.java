package com.greedy.jaegojaego.client.model.repository;

import com.greedy.jaegojaego.client.model.dto.ClientCbrDTO;
import com.greedy.jaegojaego.client.model.entity.ClientCbr;
import com.greedy.jaegojaego.client.model.entity.ClientContractItemAttachmentFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.DoubleStream;

public interface ClientCbrRepository extends JpaRepository<ClientCbr, Integer> {

}
