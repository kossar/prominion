package app;

import model.CallBack;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CallBackDao {
    private final JdbcTemplate template;

    public CallBackDao(JdbcTemplate template) {
        this.template = template;
    }

    public int[] saveCallBacks(List<CallBack> callBacks) {

        return this.template.batchUpdate(
                "insert into callback (GUID, LastResult, OrigCallerNbr, last, next, queuename, start) values(?,?,?,?,?,?,?)",
                new BatchPreparedStatementSetter() {

                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, callBacks.get(i).getGUID());
                        ps.setString(2, callBacks.get(i).getLastResult());
                        ps.setString(3, callBacks.get(i).getOrigCallerNbr());
                        ps.setString(4, callBacks.get(i).getLast());
                        ps.setString(5, callBacks.get(i).getNext());
                        ps.setString(6, callBacks.get(i).getQueuename());
                        ps.setString(7, callBacks.get(i).getStart());
                    }

                    public int getBatchSize() {
                        return callBacks.size();
                    }

                });
    }

    public List<CallBack> getAllCallBacks() {
        String sql = "select * from callback";

        return template.query(sql, new CallBackMapper());
    }
    private static final class CallBackMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            CallBack callBack = new CallBack();
            callBack.setGUID(rs.getString("GUID"));
            callBack.setLastResult(rs.getString("lastresult"));
            callBack.setOrigCallerNbr(rs.getString("origcallernbr"));
            callBack.setLast(rs.getString("last"));
            callBack.setNext(rs.getString("next"));
            callBack.setQueuename(rs.getString("queuename"));
            callBack.setStart(rs.getString("start"));
            return callBack;
        }
    }
    public void deleteById(String id) {

        System.out.println(id);
        String sql = "delete from callback WHERE guid = ?";

        this.template.update(sql, id);
    }
}
