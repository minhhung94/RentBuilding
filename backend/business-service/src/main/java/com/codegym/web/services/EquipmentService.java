package com.codegym.web.services;

import com.codegym.dao.dto.EquipmentDTO;
import com.codegym.dao.entity.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EquipmentService {
    List<Equipment> findAllByDeleteFlagIsNull();
    EquipmentDTO findAllByDeleteFlagIsNullAndIdIs(Integer id);
    Equipment findById(Integer id);
    void delete(Integer id) ;

    Page<Equipment> getEquipments(String nameEquipment, Pageable pageable);
    void save(EquipmentDTO equipmentDTO);
    Page<Equipment> findAllByNameEquipmentContainingOrAmountContainingOrGround_CodeGroundOrTypeEquipment_NameType(String nameEquipment, Integer amount, String ground_codeGround, String typeEquipment_nameType, Pageable pageable);
    Page<Equipment> findAllByDeleteFlagIsNullAndNameEquipmentContainingOrAmountContainingOrGround_CodeGroundOrTypeEquipment_NameType(String nameEquipment, Integer amount, String ground_codeGround, String typeEquipment_nameType, Pageable pageable);
    Page<Equipment> findAllByNameEquipmentContainingOrAmountContainingOrGround_IdOrTypeEquipment_Id(String nameEquipment, Integer amount, Integer ground_id, Integer typeEquipment_id, Pageable pageable);
    void updateEquipment(EquipmentDTO equipmentDTO);

    Page<Equipment> searchAll(String nameEquipment, Integer amount ,String ground_codeGround, String typeEquipment_nameType, Pageable pageable);
}
