package com.codegym.web.services.impl;


import com.codegym.dao.dto.EquipmentDTO;
import com.codegym.dao.entity.Equipment;
import com.codegym.dao.repository.EquipmentRepository;
import com.codegym.dao.repository.GroundRepository;
import com.codegym.dao.repository.TypeEquipmentRepository;
import com.codegym.web.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    GroundRepository groundRepository;

    @Autowired
    TypeEquipmentRepository typeEquipmentRepository;

    @Override
    public List<Equipment> findAllByDeleteFlagIsNull() {
        return equipmentRepository.findAllByDeleteFlagIsNull();
    }

    @Override
    public EquipmentDTO findAllByDeleteFlagIsNullAndIdIs(Integer id) {
            Equipment equipment = equipmentRepository.findAllByDeleteFlagIsNullAndIdIs(id);
            if (equipment != null) {
                EquipmentDTO equipmentDTO = new EquipmentDTO();
                equipmentDTO.setId(equipment.getId());
                equipmentDTO.setTypeEquipmentId(equipment.getTypeEquipment().getId());
                equipmentDTO.setNameEquipment(equipment.getNameEquipment());
                equipmentDTO.setAmount(equipment.getAmount());
                equipmentDTO.setAmountOfBroken(equipment.getAmountOfBroken());
                equipmentDTO.setNote(equipment.getNote());
                equipmentDTO.setGroundId(equipment.getGround().getId());
                return equipmentDTO;
            }
            return null;
    }


    @Override
    public Equipment findById(Integer id) {
        return equipmentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        Equipment equipment = equipmentRepository.findAllByDeleteFlagIsNullAndIdIs(id);
        equipment.setDeleteFlag(1);
        equipmentRepository.save(equipment);
    }

    @Override
    public Page<Equipment> getEquipments( String nameEquipment, Pageable pageable) {
        return equipmentRepository.findAllByDeleteFlagIsNullAndNameEquipmentContaining(nameEquipment, pageable);
    }

//    @Override
//    public Page<Equipment> findAllByNameEquipmentContainingOrAmountContaining(String nameEquipment, Integer amount, Pageable pageable) {
//        return equipmentRepository.findAllByNameEquipmentContainingOrAmountContaining(nameEquipment, amount, pageable);
//    }

    @Override
    public void save(EquipmentDTO equipmentDTO) {
        Equipment equipment = new Equipment();

        equipmentDTO.setId(equipmentDTO.getId());
        equipment.setTypeEquipment(typeEquipmentRepository.findById(equipmentDTO.getTypeEquipmentId()).orElse(null));
        equipment.setNameEquipment(equipmentDTO.getNameEquipment());
        equipment.setAmount(equipmentDTO.getAmount());
        equipment.setAmountOfBroken(equipmentDTO.getAmountOfBroken());
        equipment.setNote(equipmentDTO.getNote());
        equipment.setGround(groundRepository.findById(equipmentDTO.getGroundId()).orElse(null));

        equipmentRepository.save(equipment);
    }

    @Override
    public Page<Equipment> findAllByNameEquipmentContainingOrAmountContainingOrGround_CodeGroundOrTypeEquipment_NameType(String nameEquipment, Integer amount, String ground_codeGround, String typeEquipment_nameType, Pageable pageable) {
        return equipmentRepository.findAllByNameEquipmentContainingOrAmountContainingOrGround_CodeGroundOrTypeEquipment_NameType(nameEquipment, amount, ground_codeGround, typeEquipment_nameType, pageable);
    }

    @Override
    public Page<Equipment> findAllByDeleteFlagIsNullAndNameEquipmentContainingOrAmountContainingOrGround_CodeGroundOrTypeEquipment_NameType(String nameEquipment, Integer amount, String ground_codeGround, String typeEquipment_nameType, Pageable pageable) {
        return equipmentRepository.searchAll(nameEquipment, amount, ground_codeGround, typeEquipment_nameType, pageable);
    }

    @Override
    public Page<Equipment> findAllByNameEquipmentContainingOrAmountContainingOrGround_IdOrTypeEquipment_Id(String nameEquipment, Integer amount, Integer ground_id, Integer typeEquipment_id, Pageable pageable) {
        return equipmentRepository.findAllByNameEquipmentContainingOrAmountContainingOrGround_IdContainingOrTypeEquipment_IdContaining(nameEquipment, amount, ground_id, typeEquipment_id, pageable);
    }

//    @Override
//    public Page<Equipment> findAllByDeleteFlagIsNullAndAmountContaining(Integer amount, Pageable pageable) {
//        return equipmentRepository.findAllByDeleteFlagIsNullAndAmountContaining(amount, pageable);
//    }

    @Override
    public void updateEquipment(EquipmentDTO equipmentDTO) {
        Equipment equipment = equipmentRepository.findAllByDeleteFlagIsNullAndIdIs(equipmentDTO.getId());

        equipment.setId(equipmentDTO.getId());
        equipment.setTypeEquipment(typeEquipmentRepository.findById(equipmentDTO.getTypeEquipmentId()).orElse(null));
        equipment.setNameEquipment(equipmentDTO.getNameEquipment());
        equipment.setAmount(equipmentDTO.getAmount());
        equipment.setAmountOfBroken(equipmentDTO.getAmountOfBroken());
        equipment.setNote(equipmentDTO.getNote());
        equipment.setGround(groundRepository.findById(equipmentDTO.getGroundId()).orElse(null));

        equipmentRepository.save(equipment);
    }

    @Override
    public Page<Equipment> searchAll(String nameEquipment,Integer amount ,String ground_codeGround, String typeEquipment_nameType, Pageable pageable) {
        return equipmentRepository.searchAll(nameEquipment, amount, ground_codeGround, typeEquipment_nameType, pageable);
    }


}
