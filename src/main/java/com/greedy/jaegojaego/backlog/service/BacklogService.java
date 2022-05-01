package com.greedy.jaegojaego.backlog.service;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklogDTO;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;
import com.greedy.jaegojaego.backlog.repository.InWarehouseBacklogRepository;
import org.modelmapper.ModelMapper;
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

        List<InWarehouseBacklog> inWarehouseBacklogList = inWarehouseBacklogRepository.findAll();
        System.out.println("inWarehouseBacklogList = " + inWarehouseBacklogList);

        return inWarehouseBacklogList.stream().map(inWarehouseBacklog -> modelMapper.map(inWarehouseBacklog, InWarehouseBacklogDTO.class)).collect(Collectors.toList());
    }
}
