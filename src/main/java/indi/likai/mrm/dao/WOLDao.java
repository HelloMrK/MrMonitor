package indi.likai.mrm.dao;

import indi.likai.mrm.pojo.WOLClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WOLDao extends JpaRepository<WOLClientInfo,Integer> {

}
