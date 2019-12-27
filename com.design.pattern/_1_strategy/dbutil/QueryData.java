package _1_strategy.dbutil;

public class QueryData {

    /**
     * 根据返回值，封装不同的对象
     * @param sql
     */
    void query(String sql){
        String result = executeQuery();

    }


    private String executeQuery() {
        return "result";
    }
}
