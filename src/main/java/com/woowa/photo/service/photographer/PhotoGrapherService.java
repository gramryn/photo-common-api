package com.woowa.photo.service.photographer;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woowa.photo.common.CommonService;
import com.woowa.photo.common.Constants;
import com.woowa.photo.entity.PhotoGrapherMaster;
import com.woowa.photo.repository.PhotoGrapherMasterRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * getPhotoGrapher Service 클래스
 *
 * @author 
 * @version 1.0
 * @since 2019.03.12
 */
@Service
public class PhotoGrapherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoGrapherService.class);
    
    private final PhotoGrapherMasterRepository photoGrapherMasterRepository;
    private final CommonService commonService;
    
    //@Autowired
    //private JinqSource jinqSource;

    /**
     * Instantiates a new PhotoGrapherMaster service.
     *
     * @param PhotoGrapherMasterRepository the user repository
     */
    @Autowired
    public PhotoGrapherService(CommonService commonService, PhotoGrapherMasterRepository photoGrapherMasterRepository) {
        this.photoGrapherMasterRepository = photoGrapherMasterRepository;
        this.commonService = commonService;
    }

    /**
     * 사진작가 마스터 목록을 조회한다.
     *
     * @return the photoGraphere Master list
     */
    public List<PhotoGrapherMaster> getPhotoGrapherMasterList() {
        return photoGrapherMasterRepository.findAll();
    }

    /**
     * 사진작가 마스터 상세조회
     *
     * @param pg master id
     * @return the PhotoGrapherMasterInfo
     */
    public PhotoGrapherMaster getPhotoGrapherMasterInfo(String pgMasterId) {
    	LOGGER.debug("info : getPhotoGrapherMasterInfo...");
        return photoGrapherMasterRepository.findByPgMasterId(pgMasterId);
    }
  
    /**
     * 사진작가마스터를 생성한다.
     *
     * @param photoGrapherMaster the PhotoGrapherMaster
     * @return the PhotoGrapherMaster
     */
    public PhotoGrapherMaster createPhotoGrapherMaster(PhotoGrapherMaster photoGrapherMaster) {
    	
    	String result = commonService.procValidator(photoGrapherMaster);
    	int resultCnt = photoGrapherMasterRepository.countByPgMasterId(photoGrapherMaster.getPgMasterId());
    	
    	if (result.equals(Constants.RESULT_STATUS_SUCCESS) && (resultCnt == 0)) {
            return photoGrapherMasterRepository.save(photoGrapherMaster);
        } else {
            return (PhotoGrapherMaster) commonService.setResultModel(PhotoGrapherMaster.class, Constants.RESULT_STATUS_FAIL);
        }
    }
    
    /**
     * 사진작가마스터를 수정한다.
     *
     * @param photoGrapherMaster the PhotoGrapherMaster
     * @return the PhotoGrapherMaster
     */
    public PhotoGrapherMaster updatePhotoGrapherMaster(String pgMasterId, PhotoGrapherMaster photoGrapherMaster) {
    	
    	int resultCnt = photoGrapherMasterRepository.countByPgMasterId(pgMasterId);
    	String result = commonService.procValidator(photoGrapherMaster);
    	
        if (result.equals(Constants.RESULT_STATUS_SUCCESS) && (resultCnt > 0)) {
            return photoGrapherMasterRepository.save(photoGrapherMaster);
        } else {
            return (PhotoGrapherMaster) commonService.setResultModel(PhotoGrapherMaster.class, Constants.RESULT_STATUS_FAIL);
        }
    }
    
    /**
     * 사진작가마스터를 삭제한다.
     *
     * @param photoGrapherMaster the PhotoGrapherMaster
     * @return the PhotoGrapherMaster
     */
    public Map<String, Object> deletePhotoGrapherMaster(String pgMasterId) {
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	map.put("result", (photoGrapherMasterRepository.deleteByPgMasterId(pgMasterId)>0)?true:false);
    	
    	return map;
    	    	
    }
    
}
