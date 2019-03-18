package com.woowa.photo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;

/**
 * 사진작가마스터 Model 클래스
 *
 * @author 
 * @version 1.0
 * @since 2019.03.13
 */
@Entity
@Table(name = "PG_MASTER_INFO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PhotoGrapherMaster {

	// 사진작가ID
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PG_MASTER_ID")
    private String pgMasterId;

	// 이름
    @Column(name = "PG_MASTER_NM")
    private String pgMasterNm;

	// 휴대전화번호
    @Column(name = "PG_MBL_NO")
    private String pgMblNo;

	// 비상전화번호
    @Column(name = "PG_TLPH_NO")
    private String pgTlphNo;

    public String getPgMasterId() {
		return pgMasterId;
	}

	public void setPgMasterId(String pgMasterId) {
		this.pgMasterId = pgMasterId;
	}

	public String getPgMasterNm() {
		return pgMasterNm;
	}

	public void setPgMasterNm(String pgMasterNm) {
		this.pgMasterNm = pgMasterNm;
	}

	public String getPgMblNo() {
		return pgMblNo;
	}

	public void setPgMblNo(String pgMblNo) {
		this.pgMblNo = pgMblNo;
	}

	public String getPgTlphNo() {
		return pgTlphNo;
	}

	public void setPgTlphNo(String pgTlphNo) {
		this.pgTlphNo = pgTlphNo;
	}

}
