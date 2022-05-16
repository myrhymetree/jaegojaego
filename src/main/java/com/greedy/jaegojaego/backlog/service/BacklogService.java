package com.greedy.jaegojaego.backlog.service;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogClientDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogInWarehouseDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogItemInfoDTO;
import com.greedy.jaegojaego.backlog.dto.OutWarehouseBacklog.OutWarehouseBacklogDTO;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogClient;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogInWarehouse;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogItemInfo;
import com.greedy.jaegojaego.backlog.entity.OutWarehouseBacklog.OutWarehouseBacklog;
import com.greedy.jaegojaego.backlog.repository.InWarehouseBacklog.BacklogClientRepository;
import com.greedy.jaegojaego.backlog.repository.InWarehouseBacklog.BacklogItemInfoRepository;
import com.greedy.jaegojaego.backlog.repository.InWarehouseBacklog.InWarehouseBacklogRepository;
import com.greedy.jaegojaego.backlog.repository.OutWarehouseBacklog.OutWarehouseBacklogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : BacklogService
 * Comment : Backlog관련 메소드를 모아놓은 Service입니다.
 * History
 * 2022/05/01 (이소현) BacklogService 기본 설정 작성
 * 2022/05/02 (이소현) 입고 백로그 목록 조회
 * 2022/05/03 (이소현) 입고 백로그 목록 조회
 * 2022/05/04 (이소현) 입고 백로그 목록 조회
 * 2022/05/05 (이소현) 입고 백로그 막대 차트 조회
 * 2022/05/06 (이소현) 입고 백로그 막대 차트 조회
 * 2022/05/07 (이소현) 입고 백로그 원차트 조회
 * 2022/05/08 (이소현) 출고 백로그 조회
 * 2022/05/09 (이소현) 출고 백로그 막대 그래프 조회
 * </pre>
 * @version 9
 * @author 이소현
 * */
@Service
public class BacklogService {

    private final InWarehouseBacklogRepository inWarehouseBacklogRepository;
    private final ModelMapper modelMapper;
    private final BacklogItemInfoRepository backlogItemInfoRepository;
    private final BacklogClientRepository backlogClientRepository;
    private final OutWarehouseBacklogRepository outWarehouseBacklogRepository;

    @Autowired
    public BacklogService(InWarehouseBacklogRepository inWarehouseBacklogRepository, ModelMapper modelMapper, BacklogItemInfoRepository backlogItemInfoRepository, BacklogClientRepository backlogClientRepository, OutWarehouseBacklogRepository outWarehouseBacklogRepository) {
        this.inWarehouseBacklogRepository = inWarehouseBacklogRepository;
        this.modelMapper = modelMapper;
        this.backlogItemInfoRepository = backlogItemInfoRepository;
        this.backlogClientRepository = backlogClientRepository;
        this.outWarehouseBacklogRepository = outWarehouseBacklogRepository;
    }

    /**
     * findAll : 입고 전체 리스트 조회
     * @return : 입고 전체 리스트
     * */
    public List<BacklogInWarehouseDTO> selectInWarehouseBacklogList() {

        /** 입고 목록 전체 조회 */
        List<BacklogInWarehouse> inWarehouseBacklogList = inWarehouseBacklogRepository.findAll();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        /** DTO에 넣음 */
        List<BacklogInWarehouseDTO> backlogInWarehouseDTOList = new ArrayList<>();

        for(int i = 0; i < inWarehouseBacklogList.size(); i++) {
            if("입고 완료".equals(inWarehouseBacklogList.get(i).getBacklogInWarehousePK().getInWarehouseStatus())) {

                BacklogInWarehouseDTO backlogInWarehouseDTO = new BacklogInWarehouseDTO();
                BacklogItemInfoDTO backlogItemInfoDTO = new BacklogItemInfoDTO();
                BacklogClientDTO backlogClientDTO = new BacklogClientDTO();

                backlogClientDTO.setClientNo(inWarehouseBacklogList.get(i).getClientNoForInWarehouse().getClientNo());
                backlogClientDTO.setClientName(inWarehouseBacklogList.get(i).getClientNoForInWarehouse().getClientName());

                backlogItemInfoDTO.setItemInfoNo(inWarehouseBacklogList.get(i).getItemInfoNoForInWarehouse().getItemInfoNo());
                backlogItemInfoDTO.setItemInfoName(inWarehouseBacklogList.get(i).getItemInfoNoForInWarehouse().getItemInfoName());
                backlogItemInfoDTO.setItemInfoItemSerialNo(inWarehouseBacklogList.get(i).getItemInfoNoForInWarehouse().getItemInfoItemSerialNo());

                backlogInWarehouseDTO.setInWarehouseNo(inWarehouseBacklogList.get(i).getBacklogInWarehousePK().getInWarehouseNo());
                backlogInWarehouseDTO.setInWarehouseStatus(inWarehouseBacklogList.get(i).getBacklogInWarehousePK().getInWarehouseStatus());
                backlogInWarehouseDTO.setInWarehouseDate(inWarehouseBacklogList.get(i).getInWarehouseDate());
                backlogInWarehouseDTO.setInWarehouseAmount(inWarehouseBacklogList.get(i).getInWarehouseAmount());
                backlogInWarehouseDTO.setItemInfoNoForInWarehouse(backlogItemInfoDTO);
                backlogInWarehouseDTO.setClientNoForInWarehouse(backlogClientDTO);
                backlogInWarehouseDTO.setInWarehouseCompleteDate(inWarehouseBacklogList.get(i).getInWarehouseCompleteDate());

                backlogInWarehouseDTOList.add(backlogInWarehouseDTO);
            }
        }
        return backlogInWarehouseDTOList;

    }

    /**
     * findAll : 자재 전체 리스트 조회
     * @return : 자제 전체 리스트
     * */
    public List<BacklogItemInfoDTO> findItemInfoList() {

        List<BacklogItemInfo> ItemInfoList = backlogItemInfoRepository.findAll();

        return ItemInfoList.stream().map(backlogItemInfo -> modelMapper.map(backlogItemInfo, BacklogItemInfoDTO.class)).collect(Collectors.toList());
    }

    /**
     * findBacklogInWarehouseBySelectBox : 특정 자재 선택에 따른 특정 입고 내용 조회
     * @param itemInfoNo : 특정 자재 번호
     * @return : 특정 입고 내용
     * */
    public List<BacklogInWarehouseDTO> findBacklogInWarehouseBySelectBox(int itemInfoNo) {

        List<BacklogInWarehouse> findBacklogInWarehouseBySelectBox = inWarehouseBacklogRepository.findBacklogInWarehouseBySelectBox(itemInfoNo);

        return findBacklogInWarehouseBySelectBox.stream().map(backlogInWarehouse -> modelMapper.map(backlogInWarehouse, BacklogInWarehouseDTO.class)).collect(Collectors.toList());
    }

    /**
     * findAll : 거래처 전체 리스트 조회
     * @return : 거래처 전체 리스트
     * */
    public List<BacklogClientDTO> findClientList() {

        List<BacklogClient> clinetList = backlogClientRepository.findAll();

        return clinetList.stream().map(backlogClient -> modelMapper.map(backlogClient, BacklogClientDTO.class)).collect(Collectors.toList());
    }

    /**
     * findAll : 전체 출고 리스트 조회
     * @return : 전체 출고 리스트
     * */
    public List<OutWarehouseBacklogDTO> selectOutWarehouseBacklogList() {

        List<OutWarehouseBacklog> outWarehouseBacklogList = outWarehouseBacklogRepository.findAll();

        return outWarehouseBacklogList.stream().map(outWarehouseBacklog -> modelMapper.map(outWarehouseBacklog, OutWarehouseBacklogDTO.class)).collect(Collectors.toList());
    }

    /**
     * findAll : 특정 자재 선택에 따른 특정 출고 내용 조회
     * @return : 특정 출고 내용
     *
     * findById : 특정 자재 번호에 따른 특정 자재 이름 조회
     * @param itemInfoNo : 특정 자재 번호
     * @return : 특정 자재 이름
     * */
    public List<Date> findBacklogOutWarehouseBySelectBox(int itemInfoNo) {

        /** 출고 목록 전체 조회 */ 
        List<OutWarehouseBacklog> outWarehouseBacklogList = outWarehouseBacklogRepository.findAll();

        /** 자재 이름 조회 */
        Optional<BacklogItemInfo> itemName = backlogItemInfoRepository.findById(itemInfoNo);
        String itemNameForRepare = itemName.get().getItemInfoName();


        /** 자재 이름과 출고 목록 전체 조회의 자재 이름 비교 */
        List<Date> date = new ArrayList<>();

        for(int i = 0; i < outWarehouseBacklogList.size(); i++) {
            if(itemNameForRepare.equals(outWarehouseBacklogList.get(i).getOutWarehouseNoForBacklog().getIssueNoForBacklog().getIssueItemDTOList().get(0).getItemInfoNoForBacklog().getItemInfoName())) {
                date.add(outWarehouseBacklogList.get(i).getOutWarehouseNoForBacklog().getIssueNoForBacklog().getIssueCreatedDate());
            }
        }

        /** 반환 */
        return date;

    }
}
