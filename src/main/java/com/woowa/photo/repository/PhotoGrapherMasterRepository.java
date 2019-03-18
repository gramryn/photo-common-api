package com.woowa.photo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.woowa.photo.entity.PhotoGrapherMaster;


/**
 * PhotoGrapherMaster Repository 인터페이스
 *
 * @author 
 * @version 1.0
 * @since 2019.03.12
 */
@Repository
@Transactional
public interface PhotoGrapherMasterRepository extends JpaRepository<PhotoGrapherMaster, Long> {

		
    /**
     * PhotoGrapherMasterInfo 의 상세 정보를 조회한다.
     *
     * @param pgMasterId the PhotoGrapherMasterInfo pgMasterId
     * @return the PhotoGrapherMasterInfo
     */
    PhotoGrapherMaster findByPgMasterId(String pgMasterId);

    int countByPgMasterId(String pgMasterId);
    
    int deleteByPgMasterId(String pgMasterId);
}
