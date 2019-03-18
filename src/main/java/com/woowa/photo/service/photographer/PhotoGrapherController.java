package com.woowa.photo.service.photographer;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.woowa.photo.entity.PhotoGrapherMaster;


import java.util.List;
import java.util.Map;

/**
 * PhotoGrapher Controller 클래스
 *
 * @author 
 * @version 1.0
 * @since 2019.03.12
 */
@RestController
public class PhotoGrapherController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PhotoGrapherController.class);
    private final PhotoGrapherService photoGrapherService;
    private  final String URI_API_PG = "/photo";

    /**
     * Instantiates a new PhotoGrapher controller.
     *
     * @param photoGrapherService the PhotoGrapher service
     */
    @Autowired
    public PhotoGrapherController(PhotoGrapherService photoGrapherService) {
    	this.photoGrapherService = photoGrapherService;
    }

    /**
     * 사진작가마스터 목록을 조회한다.
     *
     * @return the photoGrapher Master list
     */
    @GetMapping(value = URI_API_PG + "/photographers")
    List<PhotoGrapherMaster> getPhotoGrapherMasterList() {
    	
    	LOGGER.debug("> into getPhotoGrapherMasterList ...");
    	return photoGrapherService.getPhotoGrapherMasterList();
    }
    
    /**
     * 사진작가마스터 상세조회한다.
     * 
     * @param pgMasterId the pgMasterId
     * @return the PhotoGrapherMaster
     */
    
    @GetMapping(value = URI_API_PG + "/photographers/{pgMasterId:.+}")
    PhotoGrapherMaster getPhotoGrapherMasterInfo(@PathVariable String pgMasterId) {
    	LOGGER.debug("> into getPhotoGrapherMasterInfo ...");
    	return photoGrapherService.getPhotoGrapherMasterInfo(pgMasterId);
    }
    
    /**
     * 사진작가마스터를 생성한다.
     *
     * @param photoGrapherMaster the PhotoGrapherMaster
     * @return the PhotoGrapherMaster
     */
    @PostMapping(value = URI_API_PG + "/photographers")
    PhotoGrapherMaster createPhotoGrapherMaster(@RequestBody PhotoGrapherMaster photoGrapherMaster) {
    	LOGGER.debug("> into createPhotoGrapherMaster ...");
    	
        return photoGrapherService.createPhotoGrapherMaster(photoGrapherMaster);
    }

    /**
     * 사진작가마스터를 수정한다.
     *
     * @param photoGrapherMaster the PhotoGrapherMaster
     * @return the PhotoGrapherMaster
     */
    @PutMapping(value = URI_API_PG + "/photographers/{pgMasterId:.+}")
    PhotoGrapherMaster updatePhotoGrapherMaster(@PathVariable String pgMasterId, @RequestBody PhotoGrapherMaster photoGrapherMaster) {
    	LOGGER.debug("> into updatePhotoGrapherMaster ...");
    	
        return photoGrapherService.updatePhotoGrapherMaster(pgMasterId, photoGrapherMaster);
    }
    
    /**
     * 사진작가마스터를 삭제한다.
     *
     * @param photoGrapherMaster the PhotoGrapherMaster
     * @return the PhotoGrapherMaster
     */
    @DeleteMapping(value = URI_API_PG + "/photographers/{pgMasterId:.+}")
    Map<String, Object> deletePhotoGrapherMaster(@PathVariable String pgMasterId) {
    	LOGGER.debug("> into deletePhotoGrapherMaster ...");
    	Map<String, Object> result = photoGrapherService.deletePhotoGrapherMaster(pgMasterId); 
        return result;
    }
}























