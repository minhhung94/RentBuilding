package com.codegym.web.services;



import com.codegym.dao.dto.GroundDTO;
import com.codegym.dao.entity.Ground;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GroundService {
    List<Ground> findAllByDeleteFlagIsNull();
    GroundDTO findAllByDeleteFlagIsNullAndIdIs(Integer id);


    void save(GroundDTO groundDTO);

    void remove(Integer id);

    void updateGround(GroundDTO groundDTO);

    Page<Ground> getGrounds(String codeGround, Pageable pageable);

    Page<Ground> searchAll(String nameFloor, String codeGround, Integer area,
                           String typeGround_nameGround, Pageable pageable);
}
