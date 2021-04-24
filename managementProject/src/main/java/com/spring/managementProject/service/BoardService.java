package com.spring.managementProject.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.spring.managementProject.dao.BoardDao;
import com.spring.managementProject.dto.BoardDto;
import com.spring.managementProject.form.BoardForm;
 

// 서비스 역할
// Controller에 의해 호출되어 실제 비즈니스 로직과 트랜잭션을 처리하고, DB CRUD(Persistence)를 담당하는 DAO 객체를 Spring 으로부터 주입 받아서, DAO에 DB CRUD 처리를 위임하고, 처리 결과를 Controller에게 반환합니다.
// Service @Service, @Transactional, @Autowired 비즈니스 로직과 트랜잭션 처리합니다.

@Service
public class BoardService {
 
    @Autowired
    private BoardDao boardDao;
 
    /** 게시판 - 목록 조회 */
    public List<BoardDto> getBoardList(BoardForm boardForm) throws Exception {
 
        return boardDao.getBoardList(boardForm);
    }
 
    /** 게시판 - 상세 조회 */
    public BoardDto getBoardDetail(BoardForm boardForm) throws Exception {
 
        BoardDto boardDto = new BoardDto();
 
        String searchType = boardForm.getSearch_type();
 
        if("S".equals(searchType)){
            
            int updateCnt = boardDao.updateBoardHits(boardForm);
        
            if (updateCnt > 0) {
                boardDto = boardDao.getBoardDetail(boardForm);
            }
            
        } else {
            
            boardDto = boardDao.getBoardDetail(boardForm);
        }
 
        return boardDto;
    }
 
    /** 게시판 - 등록 */
    public BoardDto insertBoard(BoardForm boardForm) throws Exception {
 
        BoardDto boardDto = new BoardDto();
 
        int insertCnt = boardDao.insertBoard(boardForm);
 
        if (insertCnt > 0) {
            boardDto.setResult("SUCCESS");
        } else {
            boardDto.setResult("FAIL");
        }
 
        return boardDto;
    }
 
    /** 게시판 - 삭제 */
    public BoardDto deleteBoard(BoardForm boardForm) throws Exception {
 
        BoardDto boardDto = new BoardDto();
 
        int deleteCnt = boardDao.deleteBoard(boardForm);
 
        if (deleteCnt > 0) {
            boardDto.setResult("SUCCESS");
        } else {
            boardDto.setResult("FAIL");
        }
 
        return boardDto;
    }
 
    /** 게시판 - 수정 */
    public BoardDto updateBoard(BoardForm boardForm) throws Exception {
 
        BoardDto boardDto = new BoardDto();
 
        int updateCnt = boardDao.updateBoard(boardForm);
 
        if (updateCnt > 0) {
            boardDto.setResult("SUCCESS");
        } else {
            boardDto.setResult("FAIL");
        }
 
        return boardDto;
    }
}


