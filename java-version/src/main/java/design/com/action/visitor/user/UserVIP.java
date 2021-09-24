package design.com.action.visitor.user;

import design.com.action.visitor.User;
import design.com.action.visitor.Visitor;

public class UserVIP implements User {

    String estimation;
    String name = "UserVIP";

    public UserVIP(String estimation) {
        this.estimation = estimation;
    }

    public String getEstimation() {
        return estimation;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @param visitor 访问者
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
