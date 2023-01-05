package himedia.eighthspring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import himedia.eighthspring.domain.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
* [테이블 생성] =============================
create table item (
id bigint generated by default as identity,
itemname varchar(255),
price int,
quantity int,
primary key(id)
);

* [조회] =====================================
select * from item;

* [추가] =====================================
insert into item(itemname, price, quantity)
values('빼빼로', 2500, 6); 
*/

//@Repository
@RequiredArgsConstructor
@Slf4j
public class JDBCTemplateItemRepository implements ItemInterfaceRepository {

	private final JdbcTemplate jdbcTemplate;
	
	private RowMapper<Item> itemRowMapper() {
		return (rs, rowNum) -> {
			Item item = new Item();
			item.setId(rs.getLong("id"));
			item.setItemName(rs.getString("itemname"));
			item.setPrice(rs.getInt("price"));
			item.setQuantity(rs.getInt("quantity"));
			return item;
		};
	}
	
	@Override
	public Item save(Item item) {
		log.info("1. [save] 시작 ");
		//SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		//jdbcInsert.withTableName("item").usingGeneratedKeyColumns("id");
		
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
				.withTableName("item")
				.usingGeneratedKeyColumns("id");
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("itemname", item.getItemName());
		parameters.put("price", item.getPrice());
		parameters.put("quantity", item.getQuantity());
		
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		
		item.setId(key.longValue());
		
		log.debug("2.1. [save] 종료 : (더하기 연산) id --> " + item.getId());
		log.debug("2.2. [save] 종료 : id --> {}", item.getId());
		
		/*
		 * [log level] ======================================================
		 * default : info
		 * 
		 * trace > debug > info > warn > error
		 * error < warn < info < debug < trace
		 * 
		 * 개발 서버 : debug
		 * 운영 서버 : info
		 */
		//String str = "TEST...";
		//log.trace("1. trace : {}", str);
		//log.debug("2. debug : {}", str);
		//log.info("3. info : {}", str);
		//log.warn("4. warn : {}", str);
		//log.error("5. error : {}", str);
		
		return item;
	}

	@Override
	public Optional<Item> findById(Long id) {
		return jdbcTemplate
				.query("select * from item where id = ?", itemRowMapper(), id)
				.stream()
				.findAny();
	}

	@Override
	public Optional<Item> findByName(String itemName) {
		return jdbcTemplate
				.query("select * from item where itemName = ?", itemRowMapper(), itemName)
				.stream()
				.findAny();
	}

	@Override
	public List<Item> findAll() {
		return jdbcTemplate.query("select * from item", itemRowMapper());
	}

	@Override
	public void update(Long itemId, Item updateItem) {
		String sql = "update item set itemname=?, price=?, quantity=? where id=?";
		int result = jdbcTemplate.update(sql,
						updateItem.getItemName(),
						updateItem.getPrice(),
						updateItem.getQuantity(),
						itemId);
		log.info("[update] result >> {}", result);
	}

//	@Override
//	public void clearStore() {
//		jdbcTemplate.execute("truncate table item");
//	}
}