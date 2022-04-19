<<<<<<< HEAD
//package com.greedy.jaegojaego.materials.model.service;
//
//import com.greedy.jaegojaego.materials.model.dto.MaterialsDTO;
//import com.greedy.jaegojaego.materials.model.repository.MaterialsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MaterialsService {
//
//    private final MaterialsRepository materialsRepository;
//
//    @Autowired
//    public MaterialsService(MaterialsRepository materialsRepository) {
//        this.materialsRepository = materialsRepository;
//    }
//
//    public List<MaterialsDTO> findMaterialsList() {
//    }
//}
=======
package com.greedy.jaegojaego.materials.model.service;

import com.greedy.jaegojaego.materials.model.dto.MaterialsDTO;
import com.greedy.jaegojaego.materials.model.repository.MaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialsService {

    private final MaterialsRepository materialsRepository;

    @Autowired
    public MaterialsService(MaterialsRepository materialsRepository) {
        this.materialsRepository = materialsRepository;
    }

    public List<MaterialsDTO> findMaterialsList() {

        return null;
    }
}
>>>>>>> feature/materials
