package com.spring.managementProject.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.spring.managementProject.dao.DocumentDao;
import com.spring.managementProject.dto.DocumentDto;
import com.spring.managementProject.form.DocumentForm;
 

// 서비스 역할
// Controller에 의해 호출되어 실제 비즈니스 로직과 트랜잭션을 처리하고, DB CRUD(Persistence)를 담당하는 DAO 객체를 Spring 으로부터 주입 받아서, DAO에 DB CRUD 처리를 위임하고, 처리 결과를 Controller에게 반환합니다.
// Service @Service, @Transactional, @Autowired 비즈니스 로직과 트랜잭션 처리합니다.

@Service
public class DocumentService {
 
    @Autowired
    private DocumentDao documentDao;
 
    /** 게시판 - 목록 조회 */
    public List<DocumentDto> getDocumentList(DocumentForm documentForm) throws Exception {
 
        return documentDao.getDocumentList(documentForm);
    }
 
    /** 게시판 - 상세 조회 */
    public DocumentDto getDocumentDetail(DocumentForm documentForm) throws Exception {
 
        DocumentDto documentDto = new DocumentDto();
 
        String searchType = documentForm.getSearch_type();
 
        if("S".equals(searchType)){
            
            int updateCnt = documentDao.updateDocumentHits(documentForm);
        
            if (updateCnt > 0) {
                documentDto = documentDao.getDocumentDetail(documentForm);
            }
            
        } else {
            
            documentDto = documentDao.getDocumentDetail(documentForm);
        }
 
        return documentDto;
    }
 
    /** 게시판 - 등록 */
    public DocumentDto insertDocument(DocumentForm documentForm) throws Exception {
 
        DocumentDto documentDto = new DocumentDto();
 
        int insertCnt = documentDao.insertDocument(documentForm);
 
        if (insertCnt > 0) {
            documentDto.setResult("SUCCESS");
        } else {
            documentDto.setResult("FAIL");
        }
 
        return documentDto;
    }
 
    /** 게시판 - 삭제 */
    public DocumentDto deleteDocument(DocumentForm documentForm) throws Exception {
 
        DocumentDto documentDto = new DocumentDto();
 
        int deleteCnt = documentDao.deleteDocument(documentForm);
 
        if (deleteCnt > 0) {
            documentDto.setResult("SUCCESS");
        } else {
            documentDto.setResult("FAIL");
        }
 
        return documentDto;
    }
 
    /** 게시판 - 수정 */
    public DocumentDto updateDocument(DocumentForm documentForm) throws Exception {
 
        DocumentDto documentDto = new DocumentDto();
 
        int updateCnt = documentDao.updateDocument(documentForm);
 
        if (updateCnt > 0) {
            documentDto.setResult("SUCCESS");
        } else {
            documentDto.setResult("FAIL");
        }
 
        return documentDto;
    }
}


