package com.greedy.jaegojaego.member.model.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberListDTO {

    private List<CompanyAccountDTO> members;
    private List<CompanyAccountDTO> removedMembers;
}
