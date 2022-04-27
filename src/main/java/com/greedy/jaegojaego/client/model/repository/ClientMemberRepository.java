package com.greedy.jaegojaego.client.model.repository;

import com.greedy.jaegojaego.client.model.dto.ClientMemberDTO;
import com.greedy.jaegojaego.client.model.entity.ClientBusinessType;
import com.greedy.jaegojaego.client.model.entity.ClientMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientMemberRepository extends JpaRepository<ClientMember, Integer> {

    ClientMember findByClientMemberNo(int memberNo);
}
