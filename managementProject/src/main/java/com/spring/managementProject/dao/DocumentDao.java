package com.spring.managementProject.dao;
import java.util.List;
 
import javax.annotation.Resource;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
import com.spring.managementProject.dto.DocumentDto;
import com.spring.managementProject.form.DocumentForm;
 
// DAO 역할
// Service에 의해 호출되어 쿼리를 담당하는 SqlMapClientTemplate 객체를 Spring으로부터 주입받아서, SqlMapClientTemplate 객체에 쿼리 수행을 위임하고, 처리 결과를 Service에게 반환합니다.
// DAO @Repository, @Autowired SqlMapClientTemplate을 통해 쿼리 수행 후 결과 반환합니다.



@Repository
public class DocumentDao {
 
    @Resource(name = "sqlSession")
    private SqlSession sqlSession;
 
    private static final String NAMESPACE = "com.spring.document.documentMapper";
 
    /** 게시판 - 목록 조회  */
    public List<DocumentDto> getDocumentList(DocumentForm documentForm) throws Exception {
        
        return sqlSession.selectList(NAMESPACE + ".getDocumentList", documentForm);
    }
    
    /** 게시판 - 조회 수 수정  */
    public int updateDocumentHits(DocumentForm documentForm) throws Exception {
        
        return sqlSession.update(NAMESPACE + ".updateDocumentHits", documentForm);
    }
    
    /** 게시판 - 상세 조회  */
    public DocumentDto getDocumentDetail(DocumentForm documentForm) throws Exception {
        
        return sqlSession.selectOne(NAMESPACE + ".getDocumentDetail", documentForm);
    }
    
    /** 게시판 - 등록  */    
    public int insertDocument(DocumentForm documentForm) throws Exception {
        return sqlSession.insert(NAMESPACE + ".insertDocument", documentForm);
    }
    
    /** 게시판 - 삭제  */
    public int deleteDocument(DocumentForm documentForm) throws Exception {
        
        return sqlSession.delete(NAMESPACE + ".deleteDocument", documentForm);
    }
    
    /** 게시판 - 수정  */
    public int updateDocument(DocumentForm documentForm) throws Exception {
        
        return sqlSession.update(NAMESPACE + ".updateDocument", documentForm);
    }
}
