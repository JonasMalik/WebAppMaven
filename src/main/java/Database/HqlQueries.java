package Database;

/**
 * Created by jonas on 2016-12-07.
 */
public class HqlQueries {

    private static HqlQueries instance = null;
    protected HqlQueries() {}
    public static HqlQueries getInstance() {
        if(instance == null) {
            instance = new HqlQueries();
        }
        return instance;
    }

    // All queries
    private String loginQuery = "FROM Users U " +
                                "WHERE U.password = :password " +
                                "and  U.email = :email";

    private String ShowDatabase = "FROM Users " +
                                  "WHERE name LIKE :search";

    // All getters
    public String getLoginQuery() {
        return loginQuery;
    }

    public String getShowDatabase() {
        return ShowDatabase;
    }
}
