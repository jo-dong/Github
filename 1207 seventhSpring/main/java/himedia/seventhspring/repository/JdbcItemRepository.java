package himedia.seventhspring.repository;

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

import himedia.seventhspring.domain.Item;

//@Repository
public class JdbcItemRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcItemRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<Item> itemRowMapper() {
		return (rs, rowNum) -> {
			Item item = new Item(null, 0, 0);
			item.setItemId(rs.getLong("itemId"));
			item.setItemName(rs.getString("itemName"));
			item.setPrice(rs.getInt("price"));
			item.setQuantity(rs.getInt("quantity"));
			return item;
		};
	}
	
	// save
	public Item save(Item item) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("item").usingGeneratedKeyColumns("itemId");
		
		Map<String, Object> parameter = new HashMap<>();
		
		parameter.put("itemId", item.getItemId());
		parameter.put("itemName", item.getItemName());
		parameter.put("price", item.getPrice());
		parameter.put("quantity", item.getQuantity());
		
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameter));
		item.setItemId(key.longValue());
		
		return item;
	}
	
	// findById
	public Optional<Item> findById(Long itemId) {
		List<Item> result = jdbcTemplate.query("select * from item where itemId=?", itemRowMapper(), itemId);
		
		return result.stream().findAny();
	}
	
	// findByName
	public Optional<Item> findByName(String itemName) {
		List<Item> result = jdbcTemplate.query("select * from item where itemName=?", itemRowMapper(), itemName);
		
		return result.stream().findAny();
	}
	
	// findAll
	public List<Item> findAll() {
		return jdbcTemplate.query("select * from item", itemRowMapper());
	}
	
	// update
	public void update(Long itemId, Item updateItem) {
		String sql = "update item set itemname=?, price=?, quantity=?" + " where itemid=?";
		jdbcTemplate.update(sql, updateItem.getItemName(), updateItem.getPrice(),
								 updateItem.getQuantity(), itemId);
	}
	
}