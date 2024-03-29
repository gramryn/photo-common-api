

CREATE TABLE IF NOT EXISTS PHOTO_ORD_MST(
PHOTO_PS_YMD varchar(8) NOT NULL COMMENT '촬영요청일자',
PHOTO_SEQ int(11) NOT NULL COMMENT '촬영요청seq',
PHOTO_CEO_ID varchar(8) DEFAULT NULL COMMENT '촬영요청사장님ID',
PHOTO_MENU_TITLE varchar(100) DEFAULT NULL COMMENT '촬영요청메뉴제목내용',
PHOTO_MENU_DTL varchar(1000) DEFAULT NULL COMMENT '촬영요청메뉴상세내용',
PHOTO_MENU_YN varchar(1) DEFAULT NULL COMMENT '촬영요청세트메뉴여부 Y ,N',
PHOTO_REQ_YMD varchar(8) DEFAULT NULL COMMENT '촬영요청예정일자',
PHOTO_REQ_TIMECODE varchar(2) DEFAULT NULL COMMENT '촬영요청시간구분코드',
PHOTO_ADDR varchar(100) DEFAULT NULL COMMENT '촬영요청장소주소 시도, 구군',
PHOTO_ADDR_DTL varchar(100) DEFAULT NULL COMMENT '촬영요청장소주소상세',
PHOTO_ADDR_MAP varchar(100) DEFAULT NULL COMMENT '촬영요청장소약도',
PHOTO_PARK_YN varchar(1) DEFAULT NULL COMMENT '촬영주차공간여부 Y ,N',
PHOTO_PARK_INFO varchar(100) DEFAULT NULL COMMENT '촬영주차공간내용',
TLPH_NO varchar(20) DEFAULT NULL COMMENT '비상전화번호',
PHOTO_REQ_CODE varchar(2) DEFAULT NULL COMMENT '촬영요청구분코드 00:신규, 10:재촬영',
PHOTO_COST int(11) DEFAULT NULL COMMENT '촬영요청금액',
PHOTO_STAT_CODE varchar(2) DEFAULT NULL COMMENT '촬영요청상태구분코드 00:신청,10:승인(가배정중), 20:스케쥴확정(작가배정완료) 30:촬영완료',
PHOTO_APPR_CODE varchar(2) DEFAULT NULL COMMENT '촬영요청승인구분코드',
PHOTO_CNSL_CODE varchar(2) DEFAULT NULL COMMENT '촬영요청취소구분코드 00:정상 10:취소 20:반려',
PHOTO_RTN_DTL varchar(500) DEFAULT NULL COMMENT '촬영요청반려사유내용',
DISPOSER_YMD varchar(8) DEFAULT NULL COMMENT '처리일자',
DISPOSER_IP varchar(20) DEFAULT NULL COMMENT '처리IP',
DISPOSER_ID varchar(20) DEFAULT NULL COMMENT '처리자ID',
PRIMARY KEY (PHOTO_PS_YMD, PHOTO_SEQ)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사진촬영요청 마스터';

CREATE TABLE IF NOT EXISTS PHOTO_DOWN_ORD (
PHOTO_PS_YMD varchar(8) NOT NULL COMMENT '촬영요청일자',
PHOTO_SEQ int(11) NOT NULL COMMENT '촬영요청seq',
PHOTO_REQ_SEQ int(11) NOT NULL COMMENT '촬영요청이미지신청seq',
PHOTO_REQ_CODE varchar(2) DEFAULT NULL COMMENT '촬영요청구분코드 00:신규, 10:재촬영',
PHOTO_COST int(11) DEFAULT NULL COMMENT '촬영요청금액',
PHOTO_STAT_CODE varchar(2) DEFAULT NULL COMMENT '촬영요청이미지상태구분코드 00:신청, 10:승인',
PHOTO_CNSL_CODE varchar(02) DEFAULT NULL COMMENT '촬영요청이미지취소구분코드 00:정상, 10:취소, 20:반려',
PHOTO_RTN_DTL varchar(500) DEFAULT NULL COMMENT '촬영요청이미지반려사유내용',
PRIMARY KEY (PHOTO_PS_YMD, PHOTO_SEQ),
KEY IDX_PHOTO_DOWN_ORD01 (PHOTO_REQ_SEQ)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사진촬영이미지다운로드신청내역';


CREATE TABLE IF NOT EXISTS PHOTO_CHG_ORD (
PHOTO_PS_YMD varchar(8) NOT NULL COMMENT '촬영요청일자',
PHOTO_SEQ int(11) NOT NULL COMMENT '촬영요청seq',
PHOTO_CHG_YMD varchar(8) DEFAULT NULL COMMENT '촬영요청변동일자',
PHOTO_CHG_CODE varchar(3) DEFAULT NULL COMMENT '촬영변경구분코드 000:촬영신규, 010:메뉴변경, 100:작가배정요청, 200:취소, 400:다운로드신청, 420:다운취소',
PHOTO_CHG_BINFO varchar(1000) DEFAULT NULL COMMENT '촬영변경전내용',
PHOTO_CHG_AINFO varchar(1000) DEFAULT NULL COMMENT '촬영변경후내용',
PHOTO_RTN_DTL varchar(500) DEFAULT NULL COMMENT '촬영요청반려사유내용',
PHOTO_REG_CODE varchar(2) DEFAULT NULL COMMENT '촬영변경자유형코드 00:사장님, 10:관리자, 20:작가, 30:포토팀',
PHOTO_CHG_ID varchar(20) DEFAULT NULL COMMENT '촬영변경자ID',
PRIMARY KEY (PHOTO_PS_YMD,PHOTO_SEQ)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사진촬영요청변동내역';

CREATE TABLE IF NOT EXISTS PG_ASSIGN_DTL (
PG_PS_YMD varchar(8) NOT NULL COMMENT '촬영요청일자',
PG_SEQ int(11) NOT NULL COMMENT '촬영요청seq',
PG_REQ_SEQ int(11) NOT NULL COMMENT '촬영요청작가배정seq',
PG_YMD varchar(8) DEFAULT NULL COMMENT '촬영배정일자',
PG_TIME varchar(6) DEFAULT NULL COMMENT '촬영배정시간',
PG_ID varchar(20) DEFAULT NULL COMMENT '촬영작가ID',
PG_TIME_CODE varchar(2) DEFAULT NULL COMMENT '촬영배정시간구분코드',
PG_MSTID varchar(20) DEFAULT NULL COMMENT '촬영배정관리자ID',
PG_CNCL_CODE varchar(02) DEFAULT NULL COMMENT '촬영배정취소구분코드 00 정상 10 :취소 20 반려',
PRIMARY KEY (PG_PS_YMD, PG_SEQ, PG_REQ_SEQ)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사진촬영작가배정내역';

CREATE TABLE IF NOT EXISTS PG_IMG_DTL (
PG_PS_YMD varchar(8) NOT NULL COMMENT '촬영요청일자',
PG_SEQ int(11) NOT NULL COMMENT '촬영요청seq',
PG_ORG_SEQ int(11) NOT NULL COMMENT '촬영요청원본이미지seq',
PG_ORG_NM varchar(100) DEFAULT NULL COMMENT '원본이미지',
PG_ORG_YMD varchar(8) DEFAULT NULL COMMENT '촬영원본등일자',
PG_ORG_ID varchar(20) DEFAULT NULL COMMENT '촬영원본등록자ID',
PG_ORG_CODE varchar(2) DEFAULT NULL COMMENT '촬영요청원본이미지상태구분코드 00:등록, 10:다운로드요청, 20:관리자승인, 30:다운로드',
PRIMARY KEY (PG_PS_YMD, PG_SEQ, PG_ORG_SEQ)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사진촬영원본이미지내역';

CREATE TABLE IF NOT EXISTS PG_MASTER_INFO (
PG_MASTER_ID varchar(20) NOT NULL COMMENT '사진작가ID',
PG_MASTER_NM varchar(100) DEFAULT NULL COMMENT '이름',
PG_MBL_NO varchar(20) DEFAULT NULL COMMENT '휴대전화번호',
PG_TLPH_NO varchar(20) DEFAULT NULL COMMENT '비상전화번호',
PRIMARY KEY (PG_MASTER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사진작가마스터';

CREATE TABLE IF NOT EXISTS POST_BNNR_MASTER (
BNNR_PS_YMD varchar(8) NOT NULL COMMENT '배너요청일자',
BNNR_SEQ int(11) NOT NULL COMMENT '배너요청seq',
BNNR_CEO_ID varchar(20) DEFAULT NULL COMMENT '배너요청사장님ID',
BNNR_GB_CODE varchar(3) DEFAULT NULL COMMENT '배너구분코드',
BNNR_ID varchar(5) DEFAULT NULL COMMENT '배너ID',
BNNR_MENU_INFO varchar(100) DEFAULT NULL COMMENT '배너메뉴제목내용',
BNNR_MENU_DTL varchar(1000) DEFAULT NULL COMMENT '배너메뉴상세내용',
BNNR_ORD_NN int(11) DEFAULT NULL COMMENT '배너주문수량',
BNNR_SCH_YMD varchar(8) DEFAULT NULL COMMENT '배너예정일자',
BNNR_ADDR varchar(100) DEFAULT NULL COMMENT '배너수령장소주소 시도, 구군',
BNNR_ADDR_DTL varchar(100) DEFAULT NULL COMMENT '배너수령장소주소상세',
BNNR_ADDR_MAP varchar(100) DEFAULT NULL COMMENT '배너수령장소약도',
TLPH_NO varchar(20) DEFAULT NULL COMMENT '비상전화번호',
BNNR_COST int(11) DEFAULT NULL COMMENT '배너금액',
BNNR_STAT_CODE varchar(2) DEFAULT NULL COMMENT '배너상태구분코드 신청, 주문, 완료',
BNNR_APPR_CODE varchar(2) DEFAULT NULL COMMENT '배너승인구분코드',
BNNR_CNSL_CODE varchar(2) DEFAULT NULL COMMENT '배너요청취소구분코드 00:정상, 10:취소, 20:반려',
BNNR_RTN_DTL varchar(500) DEFAULT NULL COMMENT '배너요청반려사유내용',
DISPOSER_YMD varchar(8) DEFAULT NULL COMMENT '처리일자',
DISPOSER_IP varchar(20) DEFAULT NULL COMMENT '처리IP',
DISPOSER_ID varchar(20) DEFAULT NULL COMMENT '처리자ID',
PRIMARY KEY (BNNR_PS_YMD, BNNR_SEQ)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='포스트배너 요청마스터';

CREATE TABLE IF NOT EXISTS POST_BNNR_ORDER (
BNNR_PS_YMD varchar(8) NOT NULL COMMENT '배너요청일자',
BNNR_SEQ int(11) NOT NULL COMMENT '배너요청seq',
BNNR_ORD_YMD varchar(8) DEFAULT NULL COMMENT '배너주문일자',
BNNR_ORD_TM varchar(6) DEFAULT NULL COMMENT '배너주문시간',
BNNR_ORD_MSTID varchar(20) DEFAULT NULL COMMENT '배너주문관리자ID',
PRIMARY KEY (BNNR_PS_YMD, BNNR_SEQ)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='포스트배너주문내역';

CREATE TABLE IF NOT EXISTS POST_BNNR_DTL (
BNNR_PS_YMD varchar(8) NOT NULL COMMENT '배너요청일자',
BNNR_SEQ int(11) NOT NULL COMMENT '배너요청seq',
BNNR_CHG_SEQ int(11) DEFAULT NULL COMMENT '배너요청변동seq',
BNNR_CHG_YMD varchar(8) DEFAULT NULL COMMENT '배너요청변동일자',
BNNR_CHG_CODE varchar(3) DEFAULT NULL COMMENT '배너변경구분코드',
BNNR_CHG_BINFO varchar(1000) DEFAULT NULL COMMENT '배너변경전내용',
BNNR_CHG_AINFO varchar(1000) DEFAULT NULL COMMENT '배너변경후내용',
BNNR_REG_CODE varchar(2) DEFAULT NULL COMMENT '배너변경자유형코드 사장님, 관리자, 작가, 포토팀',
BNNR_CHG_ID varchar(20) DEFAULT NULL COMMENT '배너변경자ID',
PRIMARY KEY (BNNR_PS_YMD, BNNR_SEQ)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='포스트배너요청변동내역';

CREATE TABLE IF NOT EXISTS POST_BNNR_INFO (
BNNR_ID varchar(5) DEFAULT NOT NULL COMMENT '배너ID',
BNNR_CODE varchar(3) DEFAULT NULL COMMENT '배너구분코드',
BNNR_PD_ID varchar(20) DEFAULT NULL COMMENT '배너생산자ID',
PRIMARY KEY (BNNR_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='포스트배너정보';
