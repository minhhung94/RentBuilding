package com.codegym.web.services.impl;

import com.codegym.dao.dto.FloorDTO;

import com.codegym.dao.entity.Floor;

import com.codegym.dao.repository.BuildingRepository;
import com.codegym.dao.repository.FloorRepository;
import com.codegym.dao.repository.TypeFloorRepository;
import com.codegym.web.services.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private FloorRepository floorRepository;
    @Autowired
    private TypeFloorRepository typeFloorRepository;
    @Autowired
    private BuildingRepository buildingRepository;


    @Override
    public List<Floor> findAllByDeleteFlagIsNull() {
        return floorRepository.findAllByDeleteFlagIsNull();
    }

    @Override
    public Page<Floor> getFloorsByNameFloor(String name, Pageable pageable) {
        return floorRepository.findAllByDeleteFlagIsNullAndNameFloorContaining(name, pageable);
    }

    @Override
    public Page<Floor> getFloorsByBuildingId(Integer buildingId, Pageable pageable) {
        return floorRepository.findAllByDeleteFlagIsNullAndBuildingIdIs(buildingId, pageable);
    }

    @Override
    public FloorDTO findAllByDeleteFlagIsNullAndIdIs(Integer id) {
        Floor floor = floorRepository.findAllByDeleteFlagIsNullAndIdIs(id);
        if (floor != null) {
            FloorDTO floorDTO = new FloorDTO();
            floorDTO.setId(floor.getId());
            floorDTO.setNameFloor(floor.getNameFloor());
            floorDTO.setCodeFloor(floor.getCodeFloor());
            floorDTO.setArea(floor.getArea());
            floorDTO.setCapacity(floor.getCapacity());
            floorDTO.setStatusFloor(floor.getStatusFloor());
            floorDTO.setGrounds(floor.getGrounds());

            // Chuyển kiểu integer sang object
            floorDTO.setTypeFloorId(floor.getTypeFloor().getId());
            floorDTO.setBuildingId(floor.getBuilding().getId());
            return floorDTO;
        }
       return null;
    }



    @Override
    public Floor findById(Integer id) {
          return floorRepository.findById(id).orElse(null);
    }

    @Override
    public void save(FloorDTO floorDTO) {
        Floor floor = new Floor();
        floor.setId(floorDTO.getId());
        floor.setNameFloor(floorDTO.getNameFloor());
        floor.setCodeFloor(floorDTO.getCodeFloor());
        floor.setArea(floorDTO.getArea());
        floor.setCapacity(floorDTO.getCapacity());
        floor.setStatusFloor(floorDTO.getStatusFloor());
        floor.setGrounds(floor.getGrounds());

        floor.setTypeFloor(typeFloorRepository.findById(floorDTO.getTypeFloorId()).orElse(null));
        floor.setBuilding(buildingRepository.findAllByDeleteFlagIsNullAndIdIs(floorDTO.getBuildingId()));
        floorRepository.save(floor);
    }

    @Override
    public void remove(Integer id) {
        Floor floor = floorRepository.findAllByDeleteFlagIsNullAndIdIs(id);
        floor.setDeleteFlag(1);
        floorRepository.save(floor);

    }

    @Override
    public void updateFloor(FloorDTO floorDTO) {
        Floor floor = floorRepository.findAllByDeleteFlagIsNullAndIdIs(floorDTO.getId());
        floor.setId(floorDTO.getId());
        floor.setNameFloor(floorDTO.getNameFloor());
        floor.setCodeFloor(floorDTO.getCodeFloor());
        floor.setArea(floorDTO.getArea());
        floor.setCapacity(floorDTO.getCapacity());
        floor.setStatusFloor(floorDTO.getStatusFloor());
        floor.setTypeFloor(typeFloorRepository.findById(floorDTO.getTypeFloorId()).orElse(null));
        floor.setBuilding(buildingRepository.findAllByDeleteFlagIsNullAndIdIs(floorDTO.getBuildingId()));
        floor.setGrounds(floor.getGrounds());
        floorRepository.save(floor);

    }

    @Override
    public Page<Floor> searchAll(String nameBuilding, String nameFloor, Integer area, String typeFloor_nameFloor, Pageable pageable) {
        return floorRepository.searchAll(nameBuilding, nameFloor, area, typeFloor_nameFloor, pageable);
    }


}
