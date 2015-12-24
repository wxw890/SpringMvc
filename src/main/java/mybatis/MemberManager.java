package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.netsong7.member.repository.Member;

public class MemberManager {
	private static SqlSessionFactory sqlFactory;
	static{
		try{//가장 기본적으로 처리될 일
			Reader reader = Resources.getResourceAsReader("mybatis/sqlmapConfig.xml");
			sqlFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		catch(IOException err){
			throw new RuntimeException("SqlSessionFactory 인스턴스 생성 실패!!!");
		}
	}
	
	public static void write2(Member dto){
		System.out.println("어디까지 오는걸까? : " + dto.getName());
		SqlSession session = sqlFactory.openSession();
		session.insert("write2", dto);//boardMapper.xml에 id가 write인 메서드에 dto를 param으로 넘겨준다.
		session.commit();//insert, update, delete는 commit()을 해줘야 완성이 된다.
	}
	
	public static Member selectByEmail(String email){//로그인할 특정 email
		SqlSession session = sqlFactory.openSession();
		Member dto = session.selectOne("selectByEmail", email);//특정 email값을 DB와 비교하기 위해서 세션이 저장하여 dto에 넘긴다.
		return dto; //Member 즉 dto로 넘겨줘야한다.
	}
}
