package com.codegym.web.services.impl;

import com.codegym.dao.dto.GroundDTO;
import com.codegym.dao.entity.*;
import com.codegym.dao.repository.FloorRepository;
import com.codegym.dao.repository.GroundRepository;
import com.codegym.dao.repository.TypeGroundRepository;
import com.codegym.web.services.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroundServiceImpl implements GroundService {
    @Autowired
    private GroundRepository groundRepository;
    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private TypeGroundRepository typeGroundRepository;

    @Override
    public List<Ground> findAllByDeleteFlagIsNull() {
        return groundRepository.findAllByDeleteFlagIsNull();
    }

    @Override
    public GroundDTO findAllByDeleteFlagIsNullAndIdIs(Integer id) {
        Ground ground = groundRepository.findAllByDeleteFlagIsNullAndIdIs(id);
        if (ground != null) {
            GroundDTO groundDTO = new GroundDTO();
            groundDTO.setId(ground.getId());
            groundDTO.setCodeGround(ground.getCodeGround());
            groundDTO.setArea(ground.getArea());
            groundDTO.setStatusGround(ground.getStatusGround());
            groundDTO.setPrice(ground.getPrice());
            groundDTO.setPriceManager(ground.getPriceManager());
            groundDTO.setEquipments(ground.getEquipments());
            groundDTO.setContracts(ground.getContracts());
            groundDTO.setNote(ground.getNote());
            groundDTO.setBuildingId(ground.getBuildingId());

            // Chuyển đổi kiểu lưu đối tượng từ ground sang kiểu lưu integer groundDTO
            groundDTO.setFloorId(ground.getFloor().getId());
            groundDTO.setTypeGroundId(ground.getTypeGround().getId());
            return groundDTO;
        }
        return null;
    }

    @Override
    public void save(GroundDTO groundDTO) {
        Ground ground = new Ground();
        ground.setId(groundDTO.getId());
        ground.setCodeGround(groundDTO.getCodeGround());
        ground.setArea(groundDTO.getArea());
        ground.setStatusGround(groundDTO.getStatusGround());
        ground.setPrice(groundDTO.getPrice());
        ground.setPriceManager(groundDTO.getPriceManager());
        ground.setDeleteFlag(groundDTO.getDeleteFlag());
        ground.setEquipments(groundDTO.getEquipments());
        ground.setContracts(groundDTO.getContracts());
        ground.setNote(groundDTO.getNote());
        ground.setBuildingId(groundDTO.getBuildingId());

        ground.setFloor(floorRepository.findAllByDeleteFlagIsNullAndIdIs(groundDTO.getFloorId()));

        ground.setTypeGround(typeGroundRepository.findById(groundDTO.getTypeGroundId()).orElse(null));
        groundRepository.save(ground);
    }

    @Override
    public void remove(Integer id) {
        Ground ground = groundRepository.findAllByDeleteFlagIsNullAndIdIs(id);
        ground.setDeleteFlag(1);
        groundRepository.save(ground);

    }

    @Override
    public void updateGround(GroundDTO groundDTO) {
        Ground ground = groundRepository.findAllByDeleteFlagIsNullAndIdIs(groundDTO.getId());
        ground.setId(groundDTO.getId());
        ground.setCodeGround(groundDTO.getCodeGround());
        ground.setArea(groundDTO.getArea());
        ground.setStatusGround(groundDTO.getStatusGround());
        ground.setPrice(groundDTO.getPrice());
        ground.setPriceManager(groundDTO.getPriceManager());
        ground.setDeleteFlag(groundDTO.getDeleteFlag());
        ground.setEquipments(groundDTO.getEquipments());
        ground.setContracts(groundDTO.getContracts());
        ground.setNote(groundDTO.getNote());
        ground.setBuildingId(groundDTO.getBuildingId());
        ground.setFloor(floorRepository.findAllByDeleteFlagIsNullAndIdIs(groundDTO.getFloorId()));
        ground.setTypeGround(typeGroundRepository.findById(groundDTO.getTypeGroundId()).orElse(null));
        groundRepository.save(ground);

    }

    @Override
    public Page<Ground> getGrounds(String codeGround, Pageable pageable) {
        return groundRepository.findAllByDeleteFlagIsNullAndCodeGroundContaining(codeGround, pageable);
    }

    @Override
    public Page<Ground> searchAll(String nameFloor, String codeGround, Integer area, String typeGround_nameGround, Pageable pageable) {
        return groundRepository.searchAll(nameFloor, codeGround, area, typeGround_nameGround, pageable);
    }
}
