package com.greedy.jaegojaego.authentification.model.service;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.dto.MemberRoleDTO;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthenticationServiceImpl(MemberRepository memberRepository, ModelMapper modelMapper) {

        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findMemberByMemberId(username);
        System.out.println("member = " + member);

        if(member == null) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }
        MemberDTO loginMember =  modelMapper.map(member, MemberDTO.class);

        MemberRole memberRole = member.getMemberRole();

        MemberRoleDTO memberRoleDTO = modelMapper.map(memberRole, MemberRoleDTO.class);

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(loginMember.getAuthority().getAuthorityName()));

        return new CustomUser(loginMember, authorities);
    }
}
