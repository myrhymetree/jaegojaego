package com.greedy.jaegojaego.authentification.model.service;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.dto.MemberRoleDTO;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Data
public class AuthenticationServiceImpl implements AuthenticationService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final ModelAndView mv;

    @Autowired
    public AuthenticationServiceImpl(MemberRepository memberRepository, ModelMapper modelMapper, ModelAndView mv) {

        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
        this.mv = mv;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findMemberByMemberId(username);
//        System.out.println("member = " + member);

        if(member == null) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        List<MemberRole> memberRoleList = member.getMemberRoleList();

//        List<MemberRole> memberRoleList = memberRepository.findByMemberNo(member.getMemberNo());
        System.out.println("memberRole = " + memberRoleList);

        MemberDTO loginMember =  modelMapper.map(member, MemberDTO.class);

//        MemberRoleDTO memberRoleDTO = modelMapper.map(memberRoleList, MemberRoleDTO.class);

        List<MemberRoleDTO> memberRoleDTOList = memberRoleList.stream().map(memberRole -> modelMapper.map(memberRole, MemberRoleDTO.class)).collect(Collectors.toList());

        List<GrantedAuthority> authorities = new ArrayList<>();

        for(int i = 0; i < memberRoleDTOList.size(); i++) {
            authorities.add(new SimpleGrantedAuthority(memberRoleDTOList.get(i).getAuthority().getAuthorityName()));
        }

        CustomUser customUser = new CustomUser(loginMember, authorities);

        return customUser;
    }

    @Override
    public Map<String, List<String>> getPermitListMap() {

        Map<String, List<String>> permitListMap = new HashMap<>();
        List<String> adminPermitList = new ArrayList<>();
        List<String> memberPermitList = new ArrayList<>();
        List<String> franchisePermitList = new ArrayList<>();

//        adminPermitList.add("/member/regist");

        permitListMap.put("adminPermitList", adminPermitList);
        permitListMap.put("memberPermitList", memberPermitList);
        permitListMap.put("franchisePermitList", franchisePermitList);

        return permitListMap;
    }
}
