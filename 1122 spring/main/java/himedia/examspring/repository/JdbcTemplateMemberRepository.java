package himedia.examspring.repository;

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

import himedia.examspring.domain.Member;

@Repository
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
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

		jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

		Map<String, String> parameters = new HashMap<>();
		parameters.put("name", member.getName());

		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

		member.setId(key.longValue());

		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		List<Member> result = jdbcTemplate.query("select * from member where id=?", 
												memberRowMapper(), id);
		for (Member member : result) {
			if (member.getId().equals(id))
				return Optional.ofNullable(member);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = jdbcTemplate.query("select * from member where name=?", 
												memberRowMapper(), name);
		for (Member member : result) {
			if (member.getName().equals(name))
				return Optional.ofNullable(member);
		}
		return Optional.empty();
	}

	@Override
	public List<Member> findAll() {
		return jdbcTemplate.query("select * from member", memberRowMapper());
	}

}
