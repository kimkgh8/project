package com.spring.managementProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.managementProject.dto.DocumentDto;
import com.spring.managementProject.form.DocumentForm;
import com.spring.managementProject.service.DocumentService;
 
@Controller
@RequestMapping(value = "/document")
public class DocumentController {
 
    @Autowired
    private DocumentService documentService;
 
    /** 문서 - 목록 페이지 이동 */
    @RequestMapping( value = "/DocumentList")
    public String documentList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        return "document/documentList";
    }
        
    /** 문서 - 목록 조회  */
    @RequestMapping(value = "/getDocumentList")
    @ResponseBody
    public List<DocumentDto> getDocumentList(HttpServletRequest request, HttpServletResponse response, DocumentForm documentForm) throws Exception {
 
        List<DocumentDto> documentDtoList = documentService.getDocumentList(documentForm);
 
        return documentDtoList;
    }
    
    /** 문서 - 상세 페이지 이동 */
    @RequestMapping( value = "/documentDetail")
    public String documentDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        return "document/documentDetail";
    }    
    
    /** 문서 - 상세 조회  */
    @RequestMapping(value = "/getDocumentDetail")
    @ResponseBody
    public DocumentDto getDocumentDetail(HttpServletRequest request, HttpServletResponse response, DocumentForm documentForm) throws Exception {
 
        DocumentDto documentDto = documentService.getDocumentDetail(documentForm);
 
        return documentDto;
    }
    
    /** 문서 - 작성 페이지 이동 */
    @RequestMapping( value = "/documentWrite")
    public String documentWrite(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        return "document/documentWrite";
    }
    
    /** 문서 - 등록 */
    @RequestMapping( value = "/insertDocument")
    @ResponseBody
    public DocumentDto insertDocument(HttpServletRequest request, HttpServletResponse response, DocumentForm documentForm) throws Exception{
        
        DocumentDto documentDto = documentService.insertDocument(documentForm);
        
        return documentDto;
    }
    
    /** 문서 - 삭제 */
    @RequestMapping( value = "/deleteDocument")
    @ResponseBody
    public DocumentDto deleteDocument(HttpServletRequest request, HttpServletResponse response, DocumentForm documentForm) throws Exception{
        
        DocumentDto documentDto = documentService.deleteDocument(documentForm);
        
        return documentDto;
    }
    
    /** 문서 - 수정 페이지 이동 */
    @RequestMapping( value = "/documentUpdate")
    public String documentUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        return "document/documentUpdate";
    }
    
    /** 문서 - 수정 */
    @RequestMapping( value = "/updateDocument")
    @ResponseBody
    public DocumentDto updateDocument(HttpServletRequest request, HttpServletResponse response, DocumentForm documentForm) throws Exception{
        
        DocumentDto documentDto = documentService.updateDocument(documentForm);
        
        return documentDto;
    }
}

