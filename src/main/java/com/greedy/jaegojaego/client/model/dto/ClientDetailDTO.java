package com.greedy.jaegojaego.client.model.dto;

import com.greedy.jaegojaego.client.model.entity.ClientContractItemCategory;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import lombok.Data;

import java.util.Date;
@Data
public class ClientDetailDTO {

    private int clientNo;                                                           //파라미터로 받아온 해당 거래처 번호
    private String clientName;
    private String clientCbrNo;                                                     //거래처 사업자등록번호
    private String clientAddress;                                                   //거래처 주소
    private ClientContractInfoDTO clientContractStartDate;                                           //거래처 계약 시작일
    private ClientContractInfoDTO clientContractEndDate;                                             //거래처 계약 종료일
    private String ClientRepresentativeName;                                        //거래처 대표 이름
    private String clientRepresentativePhone;                                       //거래처 대표 핸드폰번호
    private String clientRepresentativeEmail;                                       //거래처 대표 이메일
    private ClientContractItemCategoryDTO clientContractItemCategory;               //거래처 판매 상품 카테고리
    private ClientMemberDTO clientMemberName;                                           //최후 수정자

}
