package com.greedy.jaegojaego.backlog.service;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogInWarehouseDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogInWarehouseHistoryDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.InWarehouseBacklogDTO;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogInWarehouse;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.InWarehouseBacklog;
import com.greedy.jaegojaego.backlog.repository.InWarehouseBacklogRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : BacklogService
 * Comment : Backlog관련 메소드를 모아놓은 Service입니다.
 * History
 * 2022/05/01 (이소현) BacklogService 기본 설정 작성
 * 2022/05/02 (이소현) 입고 백로그 목록 조회
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see InWarehouseBacklogRepository , BacklogController
 * */
@Service
public class BacklogService {

    private final InWarehouseBacklogRepository inWarehouseBacklogRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BacklogService(InWarehouseBacklogRepository inWarehouseBacklogRepository, ModelMapper modelMapper) {
        this.inWarehouseBacklogRepository = inWarehouseBacklogRepository;
        this.modelMapper = modelMapper;
    }

    public List<InWarehouseBacklogDTO> selectInWarehouseBacklogList() {

//        1. 입고 목록을 전부 조회해온다.
//        2. 새로운 입고 목록을 하나 선언한다.
//        3. 목록 반복문 + 목록별 히스토리 반복문 2중 반복을 통해 히스토리 목록 안에 입고완료 상태를 가지고 있는 입고를 확인한다.
//        4. 확인된 입고를 새로운 입고목록에 추가한다.

        List<InWarehouseBacklog> inWarehouseBacklogList = inWarehouseBacklogRepository.findAll();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        System.out.println("엔티티 전체조회");
        inWarehouseBacklogList.forEach(System.out::println);
        /* DTO에 넣어주고 */
        List<InWarehouseBacklogDTO> inWarehouseBacklogDTOList = inWarehouseBacklogList.stream().map(inWarehouseBacklog -> modelMapper.map(inWarehouseBacklog, InWarehouseBacklogDTO.class)).collect(Collectors.toList());
        System.out.println("DTO로 전체조회: " + inWarehouseBacklogDTOList);


//        List<InWarehouseBacklogDTO> realBacklogDTOList = null;
//        //위에애는 모든애를 다 조회해온것! -> [ 1 백로그 - 1 물품명 - 1 물품번호 - 1 거래처 - 1 입고완료날짜 - 1 개수 ]
//        //저 위에 List에는 몇개의 행이 들어있는거지?
//        for(int i = 0; i < inWarehouseBacklogDTOList.size(); i++) {
//            System.out.println("몇개의 행이 들어가 있을까? ");
//            System.out.println(inWarehouseBacklogDTOList.get(i).getInWarehouseDivisionNo());
//
//            for(int j = 0; j < inWarehouseBacklogDTOList.get(i).getInWarehouseDivisionNo().getBacklogInWarehouseHistoryList().size(); j++) {
//
//                System.out.println(inWarehouseBacklogDTOList.get(i).getInWarehouseDivisionNo().getBacklogInWarehouseHistoryList().get(j).getInWarehouseStatusName());
//                if("입고 완료".equals(inWarehouseBacklogDTOList.get(i).getInWarehouseDivisionNo().getBacklogInWarehouseHistoryList().get(j).getInWarehouseStatusName())) {
//                    realBacklogDTOList.add(inWarehouseBacklogDTOList.get(j));
//                }
//
//            }
//
//            System.out.println("제대로 잘 드갔으려나.. 2개 : ");
//            realBacklogDTOList.forEach(System.out::println);
//
//
//        }



        /* 하나하나 넣어줄 애들 */
//        BacklogInWarehouseHistoryDTO backlogInwarehouseHistoryDTO = null;
//        BacklogInWarehouseDTO backlogInWarehouseDTO = null;
//        InWarehouseBacklogDTO inwarehouseDTO = null;
//
//        List<InWarehouseBacklogDTO> realInWasrehouseBacklogList = null;
//
//
//        for (int i = 0; i < inWarehouseBacklogDTOList.size(); i++) {
//            System.out.println("DTOList :" + inWarehouseBacklogDTOList);
//            System.out.println("상태 : " + inWarehouseBacklogDTOList.get(i).getInWarehouseDivisionNo().getBacklogInWarehouseHistoryList().get(i).getInWarehouseStatusName());
//            for(int j = 0; j < inWarehouseBacklogDTOList.get(i).getInWarehouseDivisionNo().getBacklogInWarehouseHistoryList().size(); j++) {
//
//
//                backlogInWarehouseDTO = inWarehouseBacklogDTOList.get(i).getInWarehouseDivisionNo();
//                backlogInwarehouseHistoryDTO = inWarehouseBacklogDTOList.get(i).getInWarehouseDivisionNo().getBacklogInWarehouseHistoryList().get(j));
//
//                System.out.println("입고 : " + backlogInWarehouseDTO);
//                System.out.println("입고 히스토리 내역 : " + backlogInwarehouseHistoryDTO);
//
//                inwarehouseDTO.setInWarehouseDivisionNo(backlogInWarehouseDTO.setBacklogInWarehouseHistoryList(backlogInwarehouseHistoryDTO));
//                System.out.println("입고 백로그 : " + inwarehouseDTO);
//
//
//                System.out.println("입고완료와 입고대기가 나와야함 : " + inWarehouseBacklogDTOList.get(i).getInWarehouseDivisionNo().getBacklogInWarehouseHistoryList().get(j).getInWarehouseStatusName() );
//                if("입고 완료".equals(inWarehouseBacklogDTOList.get(i).getInWarehouseDivisionNo().getBacklogInWarehouseHistoryList().get(j).getInWarehouseStatusName())) {
//                    System.out.println("입고완료만 나와야함: " + inWarehouseBacklogDTOList.get(i).getInWarehouseDivisionNo().getBacklogInWarehouseHistoryList().get(j).getInWarehouseStatusName());
//
//                }
//
//            }
//
//        }

        return inWarehouseBacklogList.stream().map(inWarehouseBacklog -> modelMapper.map(inWarehouseBacklog, InWarehouseBacklogDTO.class)).collect(Collectors.toList());

    }
}
