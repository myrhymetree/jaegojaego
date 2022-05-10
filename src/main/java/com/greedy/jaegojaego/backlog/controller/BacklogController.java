package com.greedy.jaegojaego.backlog.controller;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogClientDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogInWarehouseDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogItemInfoDTO;
import com.greedy.jaegojaego.backlog.dto.OutWarehouseBacklog.OutWarehouseBacklogDTO;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogInWarehouse;
import com.greedy.jaegojaego.backlog.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Class : BacklogController
 * Comment : Backlog관련 메소드를 모아놓은 Controller입니다.
 * History
 * 2022/05/01 (이소현) 백로그 관련 초기 설정
 * 2022/05/02 (이소현) 입고 백로그 목록 조회
 * 2022/05/03 (이소현) 입고 백로그 목록 조회
 * 2022/05/04 (이소현) 입고 백로그 목록 조회
 * 2022/05/05 (이소현) 입고 백로그 막대 차트 조회
 * 2022/05/06 (이소현) 입고 백로그 막대 차트 조회
 * 2022/05/07 (이소현) 입고 백로그 원차트 조회
 * 2022/05/08 (이소현) 출고 백로그 조회
 * 2022/05/09 (이소현) 출고 백로그 막대 그래프 조회
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see BacklogService, InWarehouseBacklogRepository, InWarehouseBacklogRepository 등
 */
@Controller
@RequestMapping("backlog")
public class BacklogController {

    private final BacklogService backlogService;

    @Autowired
    public BacklogController(BacklogService backlogService) {
        this.backlogService = backlogService;
    }


   @GetMapping("list")
    public ModelAndView backlogPage(ModelAndView mv) {
       List<BacklogInWarehouseDTO> inWarehouseBacklogList = backlogService.selectInWarehouseBacklogList();

       mv.addObject("inWarehouseBacklogList", inWarehouseBacklogList);
       mv.setViewName("backlog/backlogList");

       return mv;
   }

   @GetMapping("outwarehouselist")
   public ModelAndView moveOutWarehouseListPage(ModelAndView mv) {
       List<OutWarehouseBacklogDTO> outWarehouseBacklogList = backlogService.selectOutWarehouseBacklogList();

       mv.addObject("outWarehouseBacklogList", outWarehouseBacklogList);
       mv.setViewName("backlog/backlogOutWarehouseList");

        return mv;
   }

   @GetMapping(value = "iteminfolist", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public List<BacklogItemInfoDTO> findItemInfoList() {

        return backlogService.findItemInfoList();
   }

   @GetMapping(value = "selectonebackloglist", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public List<BacklogInWarehouseDTO> findBacklogInWarehouseBySelectBox(@RequestParam int itemInfoNo) {

        return backlogService.findBacklogInWarehouseBySelectBox(itemInfoNo);
   }

   @GetMapping(value = "selectoneoutwarehousebackloglist", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public List<Date> findBacklogOutWarehouseBySelectBox(@RequestParam int itemInfoNo) {

        return backlogService.findBacklogOutWarehouseBySelectBox(itemInfoNo);
   }


   @GetMapping(value = "selectcirclelist", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public List<BacklogClientDTO> findClientAndAmountList(@RequestParam int itemInfoNo, @RequestParam String date) {

        /* 1) 파라미터로 받아와야 할게 : 자재번호, 날짜(년도) , 날짜(월) 받아오기
        일단 그 자재번호에 해당하는 List받아옴(지로스팅1kg / 마계커피 / 300 / 2022-04-03 등이 담겨 있음)
        받아온 애의 size만큼 for문을 돌려서 거래처 ex) String[] clientList = [마계커피 , 인도커피, 마계커피] 이렇게 만든다음
        받아온애 size만큼 for문 돌림 -> for( ) {
                                     if(파라미터로 들온 날짜(년도) && 파라미터로 들온 날짜(월) && clientList[i]) {
                                        //List<일단미정DTO> needList = new List<>(); => [amount(실수량) , 거래처] 넣을 애
                                     } //--> 그러면 지로스팅에대한 [거래처 , 그 거래처에 따른 총실수량] 이 List에 담길테니
                                       // 얘를 return하면 되는데 add.object("list", neddList); 해서
                                       //그 javascript에서 <% %>로 for문 돌리고 List도 넣어주면 될거같기도,,,
                                 }
         */
       System.out.println("자재번호 : " + itemInfoNo);
       System.out.println("2022-03 : " + date);

       String clientList = ""; //지로스팅1kg하는 거래처들만 보여줌
       List<String> inWarehouseClienList = new ArrayList<>();
       List<BacklogInWarehouseDTO> inWarehouseListByItemInfo = backlogService.findBacklogInWarehouseBySelectBox(itemInfoNo);
       Map<String, Integer> needList = new HashMap<>(); //[거래처, 실수량]
       String dateForCompare = "";
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
       List<String> inWarehouseDate = new ArrayList<>(); //2022-03 이렇게 저장됨 ㅇㅇ


       for(int i = 0; i < inWarehouseListByItemInfo.size(); i++) {
           System.out.println("?:" +  inWarehouseListByItemInfo.get(i).getClientNoForInWarehouse().getClientName());
            clientList = inWarehouseListByItemInfo.get(i).getClientNoForInWarehouse().getClientName();
            dateForCompare = dateFormat.format(inWarehouseListByItemInfo.get(i).getInWarehouseCompleteDate());
           inWarehouseClienList.add(clientList);
            inWarehouseDate.add(dateForCompare);

       }

       System.out.println("날짜 : " + inWarehouseDate);
       System.out.println("거래처들디잇나 : " + inWarehouseClienList);

       for(int j = 0; j < inWarehouseListByItemInfo.size(); j++) {
           if(date.equals(inWarehouseDate) && inWarehouseClienList.equals(inWarehouseClienList)) {
                //일단 보류...하..
           }
       }
        return null;
   }

}
