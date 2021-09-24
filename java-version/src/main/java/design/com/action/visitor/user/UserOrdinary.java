package design.com.action.visitor.user;

import design.com.action.visitor.User;
import design.com.action.visitor.Visitor;

public class UserOrdinary implements User {

    String estimation;
    String name = "UserOrdinary";

    public UserOrdinary(String estimation) {
        this.estimation = estimation;
    }

    public String getEstimation() {
        return estimation;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
