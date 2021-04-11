package com.spring.managementProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.spring.managementProject.dto.BoardDto;
import com.spring.managementProject.form.BoardForm;
import com.spring.managementProject.service.BoardService;
 
//Model 영역
//애플리케이션에 비즈니스 로직과 사용되는 데이터를 다루는 영역입니다. 일반적으로 비즈니스 데이터는 DBMS에 의해 관리되고, 그 데이터를 다루는 연산은 SQL문을 통해 구현됩니다.

//View 영역
//최종 사용자에게 보여줄 프리젠테이션 로직을 담당하는 영역입니다. 일반적으로 자바 웹 애플리케이션에서는 JSP를 통해서 구현됩니다.

//Controller 영역
//컨트롤러는 흐름을 관리하는 역할을 하며, 모델과 뷰 영역간의 조정 역할을 합니다. 사용자의 요청을 받아 이를 수행하기 위한 비즈니스 로직을 선택하고 호출하며, 수행한 비즈니스 로직의 결과를 뷰를 통해 보여줍니다.


//컨트롤러의 역할
//DispatcherServlet에 의해 호출되어 사용자의 Request를 전달받고, 해당 요청의 비즈니스 처리를 담당하는 서비스 객체를 Spring으로부터 주입(Dependency Injection)받아서, 그 서비스 객체에 처리를 위임하고, 처리 결과와 결과 화면에 대한 정보를 DispatcherServlet에게 반환합니다.
//Controller @Controller, @RequestMapping, @Autowired 서비스 처리 결과를 Model에 담으면, 컨트롤러 클래스의 RequestMapping값을 기준으로, DispatcherServlet이 ViewResolver를 통해 화면 URL 생성합니다.
@Controller
@RequestMapping(value = "/board")
public class BoardController {
 
    @Autowired
    private BoardService boardService;
 
    @RequestMapping( value = "/boardList")
    public String getBoardList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        return "board/boardList";
    }
 
    @RequestMapping(value = "/getBoardList")
    @ResponseBody
    public List<BoardDto> getBoardList(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {
 
        List<BoardDto> boardList = boardService.getBoardList(boardForm);
 
        return boardList;
    }
}
