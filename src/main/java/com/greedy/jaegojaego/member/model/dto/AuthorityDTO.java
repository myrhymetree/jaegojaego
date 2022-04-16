package com.greedy.jaegojaego.member.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AuthorityDTO {

    private int authorityCode;
    private String authorityName;
    private String authorityInfo;

}
