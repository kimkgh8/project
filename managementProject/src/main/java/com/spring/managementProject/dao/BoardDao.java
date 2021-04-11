package com.spring.managementProject.dao;
import java.util.List;
 
import javax.annotation.Resource;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
import com.spring.managementProject.dto.BoardDto;
import com.spring.managementProject.form.BoardForm;
 
// DAO 역할
// Service에 의해 호출되어 쿼리를 담당하는 SqlMapClientTemplate 객체를 Spring으로부터 주입받아서, SqlMapClientTemplate 객체에 쿼리 수행을 위임하고, 처리 결과를 Service에게 반환합니다.
// DAO @Repository, @Autowired SqlMapClientTemplate을 통해 쿼리 수행 후 결과 반환합니다.



@Repository
public class BoardDao {
 
    @Resource(name = "sqlSession")
    private SqlSession sqlSession;
 
    private static final String NAMESPACE = "com.spring.board.boardMapper";
 
    public List<BoardDto> getBoardList(BoardForm boardForm) throws Exception {
 
        return sqlSession.selectList(NAMESPACE + ".getBoardList");
    }
}

