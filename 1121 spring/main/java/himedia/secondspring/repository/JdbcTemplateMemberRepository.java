package himedia.secondspring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import himedia.secondspring.domain.Member;

public class JdbcTemplateMemberRepository implements MemberRepository {

	private final JdbcTemplate jdbcTemplate;
	
	public JdbcTemplateMemberRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Member> memberRowMapper() {	
//		return new RowMapper<Member>() {			// Anonymous class
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {	<- Overriding Body 파트 중괄호까지 블럭 지정 후
//				Member member = new Member();										   Ctrl + 1 => Lambda ~ : 자동 Lambda expression
//				member.setId(rs.getLong("id"));
//				member.setName(rs.getString("name"));
//				return member;
//			}
//		};
		
		// Lambda Expression
		return (rs, rowNum) -> {					// rowNum : 현재 row index - id와는 무관
			Member member = new Member();			
			member.setId(rs.getLong("id"));
			member.setName(rs.getString("name"));
			System.out.println("[memberRowMapper method] rowNum >> " + rowNum);
			return member;
		};
	}

	@Override
	public Member save(Member member) {
//		System.out.println("[save method] start");
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		
		jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", member.getName());
		
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
//		System.out.println("DB에 저장 후 리턴 받은 key value : " + key);
		
		member.setId(key.longValue());
		
//		System.out.println("[save method] end");
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		List<Member> result = jdbcTemplate.query("select * from member where id = ?",
												memberRowMapper() , id);
		for(Member member : result) {
			if(member.getId().equals(id))
				return Optional.ofNullable(member);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = jdbcTemplate.query("select * from member where name = ?", 
												memberRowMapper() , name);
		for(Member member : result) {
			if(member.getName().equals(name))
				return Optional.ofNullable(member);
		}
		return Optional.empty();
	}

	@Override
	public List<Member> findAll() {
		return jdbcTemplate.query("select * from member", memberRowMapper());
	}

	
	
}
