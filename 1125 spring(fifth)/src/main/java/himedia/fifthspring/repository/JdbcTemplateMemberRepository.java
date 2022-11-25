package himedia.fifthspring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import himedia.fifthspring.domain.Member;

//@Repository
public class JdbcTemplateMemberRepository implements MemberRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcTemplateMemberRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Member> memberRowMapper() {
		return (rs, rowNum) -> {
			Member member = new Member();
			member.setId(rs.getLong("id"));
			member.setName(rs.getString("name"));
			return member;
		};
	}

	@Override
	public Member save(Member member) {
		// 1. Insert
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
		
		// 2. Map - put(name)
		Map<String, String> parameter = new HashMap<>();
		parameter.put("name", member.getName());
		
		// 3. key
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameter));
		member.setId(key.longValue());
		
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		List<Member> result = jdbcTemplate.query("select * from member where id=?",
												 memberRowMapper(), id);
		// code 변경 : Stream
		for(Member member : result) {
			if(member.getId()==id)
				return Optional.ofNullable(member);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = jdbcTemplate.query("select * from member where name=?",
				 								 memberRowMapper(), name);
		// code 변경 : Stream
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
