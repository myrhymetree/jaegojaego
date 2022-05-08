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

import java.util.ArrayList;
import java.util.List;
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
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see InWarehouseBacklogRepository , BacklogController
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

    public List<BacklogInWarehouseDTO> selectInWarehouseBacklogList() {

        List<BacklogInWarehouse> inWarehouseBacklogList = inWarehouseBacklogRepository.findAll();
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        System.out.println("엔티티 전체조회");
        inWarehouseBacklogList.forEach(System.out::println);
        /* DTO에 넣어주고 */
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

        System.out.println("해치웟나? : " + backlogInWarehouseDTOList);

        return backlogInWarehouseDTOList;

    }

    public List<BacklogItemInfoDTO> findItemInfoList() {

        List<BacklogItemInfo> ItemInfoList = backlogItemInfoRepository.findAll();

        ItemInfoList.forEach(System.out::println);

        return ItemInfoList.stream().map(backlogItemInfo -> modelMapper.map(backlogItemInfo, BacklogItemInfoDTO.class)).collect(Collectors.toList());
    }

    public List<BacklogInWarehouseDTO> findBacklogInWarehouseBySelectBox(int itemInfoNo) {

        List<BacklogInWarehouse> findBacklogInWarehouseBySelectBox = inWarehouseBacklogRepository.findBacklogInWarehouseBySelectBox(itemInfoNo);
        System.out.println("잘나오냐? : " + findBacklogInWarehouseBySelectBox);

        return findBacklogInWarehouseBySelectBox.stream().map(backlogInWarehouse -> modelMapper.map(backlogInWarehouse, BacklogInWarehouseDTO.class)).collect(Collectors.toList());
    }

    public List<BacklogClientDTO> findClientList() {

        List<BacklogClient> clinetList = backlogClientRepository.findAll();

        clinetList.forEach(System.out::println);

        return clinetList.stream().map(backlogClient -> modelMapper.map(backlogClient, BacklogClientDTO.class)).collect(Collectors.toList());
    }

    public List<OutWarehouseBacklogDTO> selectOutWarehouseBacklogList() {

        List<OutWarehouseBacklog> outWarehouseBacklogList = outWarehouseBacklogRepository.findAll();

        System.out.println("되냐?");
        outWarehouseBacklogList.forEach(System.out::println);
        System.out.println("왜안나오냐?");

        return outWarehouseBacklogList.stream().map(outWarehouseBacklog -> modelMapper.map(outWarehouseBacklog, OutWarehouseBacklogDTO.class)).collect(Collectors.toList());
    }
}
