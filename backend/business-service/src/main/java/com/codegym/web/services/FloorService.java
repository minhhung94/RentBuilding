package com.codegym.web.services;
import com.codegym.dao.dto.FloorDTO;
import com.codegym.dao.entity.Floor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface FloorService {
    List<Floor> findAllByDeleteFlagIsNull();
    FloorDTO findAllByDeleteFlagIsNullAndIdIs(Integer id);
    Page<Floor> getFloorsByBuildingId(Integer buildingId, Pageable pageable);
    Page<Floor> getFloorsByNameFloor(String name, Pageable pageable);

    Floor findById(Integer id);

    void save(FloorDTO floorDTO);

    void remove(Integer id);

    void updateFloor(FloorDTO floorDTO);

    Page<Floor> searchAll(String nameBuilding, String nameFloor, Integer area,
                          String typeFloor_nameFloor, Pageable pageable);




}
