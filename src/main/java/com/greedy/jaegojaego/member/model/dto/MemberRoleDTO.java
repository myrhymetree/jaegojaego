package com.greedy.jaegojaego.member.model.dto;

import com.greedy.jaegojaego.member.model.entity.Authority;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberRoleDTO {

    private int memberNo;
    private AuthorityDTO authority;

}
