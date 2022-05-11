package com.greedy.jaegojaego.client.model.dto;

import com.greedy.jaegojaego.client.model.entity.Client;
import com.greedy.jaegojaego.client.model.entity.ClientContractItem;
import lombok.Data;

@Data
public class ClientCbrDTO {

    private int clientCbrNo;
    private String clientCbrOriginalName;
    private String clientCbrhangedName;
    private String clientCbrFileUrl;
    private String clientCbrFileDeleteYn;
    private String clientCbrFileDivision;
    private Client client;
    private int clientCbrCategoryNo;

}
