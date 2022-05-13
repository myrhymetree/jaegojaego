package com.greedy.jaegojaego.member.model.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.DepartmentDTO;
import com.greedy.jaegojaego.member.model.dto.MemberListDTO;
import com.greedy.jaegojaego.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <pre>
 * Class : MemberController
 * Comment : 본사 직원 계정 관련 컨트롤러 메소드를 모아놓은 Controller 클래스 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 *
 * @author 박성준
 * @version 1.0
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Instantiates a new Member controller.
     *
     * @param memberService   the member service
     * @param passwordEncoder the password encoder
     */
    @Autowired
    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 로그인 메소드(시큐리티에서 관리)
     */
    @GetMapping("/login")
    public void memberLoginForm() {

    }

    /**
     * 본사 직원 계정생성 페이지로 포워딩
     *
     * @return the string 본사직원 회원가입 페이지 반환
     */
    @GetMapping("/regist")
    public String sendRegistView() {

        return "/member/regist";
    }

    /**
     * 본사 직원 계정생성 메소드
     *
     * @param mv        세션에 전달할 값과 반환할 뷰 페이지
     * @param newMember 본사직원 정보
     * @param rttr      세션에 전달할 메시지
     * @return the model and view 세션에 전달할 값과 뷰 페이지 반환
     */
    @PostMapping("/regist")
    public ModelAndView registMember(ModelAndView mv, CompanyAccountDTO newMember, RedirectAttributes rttr) {

        newMember.setMemberPwd(passwordEncoder.encode(newMember.getMemberPwd()));
        newMember.setMemberCreatedDate(LocalDateTime.now());
        newMember.setMemberPwdInitStatus("Y");
        newMember.setMemberRemoveStatus("Y");
        newMember.setOfficeDivision("직원");
        newMember.setMemberDivision("본사");

        System.out.println("NewMember" + newMember);

        memberService.registNewMember(newMember);

        rttr.addFlashAttribute("registSuccessMessage", "회원가입에 성공하셨습니다.");
        mv.setViewName("redirect:/member/regist");

        return mv;
    }

    /**
     * 모든 부서 목록을 반환하는 비동기 메소드
     *
     * @return the list 모든 부서 목록
     */
    @GetMapping(value = "/department", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<DepartmentDTO> findAllDepartment() {

        return memberService.findDepartmentAll();
    }

    /**
     * 가맹계약팀 직원 목록 조회 비동기 메소드
     *
     * @return the string 가맹계약팀 직원 목록 반환
     */
    @GetMapping(value = "/supervisorList", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectSupervisor() {

        List<CompanyAccountDTO> teamMember = memberService.findSuperVisor();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(teamMember);
    }

    /**
     * 본사직원 목록 조회 메소드
     *
     * @param mv         세션에 담아줄 값 전달, 반환할 뷰페이지 주소 전달
     * @param searchWord 검색어
     * @return the model and view 본사 직원 목록 및 포워딩 할 주소 반환
     */
    @GetMapping("/list")
    public ModelAndView findMemberList(ModelAndView mv, String searchWord) {

        MemberListDTO memberList = memberService.findMemberList(searchWord);

        mv.addObject("memberList", memberList.getMembers());
        mv.addObject("removedMemberList",  memberList.getRemovedMembers());
        mv.setViewName("/member/list");

        return mv;
    }

    /**
     * 아이디 중복 체크 비동기 메소드
     *
     * @param request 아이디 값을 조회할 요청 값
     * @return the boolean 중복 여부 반환
     */
    @GetMapping(value = "/duplication", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public boolean duplicationIdCheck(HttpServletRequest request) {

        String memberId = request.getParameter("memberId");

        boolean status =  memberService.duplicationCheckId(memberId);

        return status;
    }

    /**
     * 로그인한 본사 계정 정보 조회 비동기 메소드(개인정보)
     *
     * @param authentication 로그인한 계정의 정보
     * @return the object 로그인한 계정의 정보 반환 하거나 로그인을 안했을시에는 NULL값을 반환한다.
     */
    @GetMapping(value = "/loginMemberInformation", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Object findMemberInformation(Authentication authentication) {

        if(authentication.getPrincipal() != null) {
            CustomUser customUser = (CustomUser) authentication.getPrincipal();

            Object loginMember = memberService.findLoginMemberInfo(customUser);

            return loginMember;
        }
        return null;
    }

    /**
     * 로그인한 본사 직원 계정의 계정정보(개인정보) 수정 메소드
     *
     * @param companyAccount 수정할 계정정보
     * @return the string 메인페이지로 리다이렉트
     */
    @PostMapping(value = "/modify")
    public String updateMember(CompanyAccountDTO companyAccount) {

        memberService.updateLoginMemberInfo(companyAccount);

        return "redirect:/";
    }

    /**
     * 본사직원 계정목록 수정 메소드
     *
     * @param companyAccount 수정할 계정정보
     * @return the string 본사직원 계정 목록 페이지 리다이렉트
     */
    @PostMapping(value = "/modifyMember")
    public String modifyMember(CompanyAccountDTO companyAccount) {

        memberService.modifyMemberInfo(companyAccount);

        return "redirect:/member/list";
    }

    /**
     * 본사직원 상세조회 비동기 메소드
     *
     * @param memberNo 직원번호(계정번호)
     * @return the string 상세조회한 계정정보 반환
     */
    @GetMapping(value = "/detailInfo/{memberNo}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String findMemberDetailInfo(@PathVariable Integer memberNo) {

        CompanyAccountDTO memberInfo =  memberService.findMemberDetailInfo(memberNo);

        System.out.println("멤버 정보는 : " + memberInfo);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(memberInfo);
    }

    /**
     * 본사직원 계정 삭제 메소드
     *
     * @param memberNo 삭제할  본사직원 계정번호
     * @return the string 본사직원 계정목록 페이지 리다이렉트
     */
    @GetMapping("/delete/{memberNo}")
    public String removeMember(@PathVariable Integer memberNo) {

        System.out.println("삭제할 멤버번호는 : " + memberNo);

        memberService.removeMember(memberNo);

        return "redirect:/member/list";
    }

    /**
     * 삭제된 본사직원 계정 복구 메소드
     *
     * @param memberNo 삭제된 본사직원 계정번호
     * @return the string 본사직원 계정목록 페이지 리다이렉트
     */
    @GetMapping("/restore/{memberNo}")
    public String restoreMember(@PathVariable Integer memberNo) {

        memberService.restoreMember(memberNo);

        return "redirect:/member/list";
    }
}
