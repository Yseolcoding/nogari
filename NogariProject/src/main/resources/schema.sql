CREATE TABLE NOTICE_BOARD (
                              NTBD_CD INT NOT NULL,
                              FILE_CD VARCHAR(100) NOT NULL,
                              NTBD_DIV VARCHAR(2) NULL,
                              VIEW_CNT INT NULL,
                              TOP_YN VARCHAR(1) DEFAULT 'N' NULL,
                              POST_NM VARCHAR(400) NULL,
                              POST_CONT VARCHAR(2000) NULL,
                              POST_IN_DATE VARCHAR(8) NULL,
                              POST_OUT_DATE VARCHAR(8) NULL,
                              REG_DT TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                              REG_ID VARCHAR(20) NOT NULL,
                              UPD_DT TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                              UPD_ID VARCHAR(20) NOT NULL
);