package org.hdwyl.tags.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class String2TimestampTypeHandler extends BaseTypeHandler<String> {

	@Override
	public String getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return rs.getString(columnName);
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return rs.getString(columnIndex);
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return cs.getString(columnIndex);
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			String parameter, JdbcType jdbcType) throws SQLException {
		// ps.setInt(i, Integer.parseInt(parameter));
		if (parameter != null && parameter.length() > 0)
			try {
				ps.setTimestamp(
						i,
						new Timestamp(DateUtils.parseDate(parameter,
								"yyyy-MM-dd HH:mm:ss").getTime()));
			} catch (ParseException e) {
				e.printStackTrace(System.out);
			}
		else
			ps.setNull(i, Types.TIMESTAMP);
	}

}
