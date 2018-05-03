package sample;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserRoles {
    private final SimpleStringProperty roleName;
    private final SimpleBooleanProperty edit_logs;
    private final SimpleBooleanProperty view_roles;
    private final SimpleBooleanProperty view_users;
    private final SimpleBooleanProperty edit_users;
    private final SimpleBooleanProperty edit_roles;
    private final SimpleBooleanProperty view_logs;

    UserRoles(String roleName, boolean view_logs, boolean view_roles, boolean view_users, boolean edit_logs, boolean edit_users, boolean edit_roles) {
        this.view_logs = new SimpleBooleanProperty(view_logs);
        this.roleName = new SimpleStringProperty(roleName);
        this.view_roles = new SimpleBooleanProperty(view_roles);
        this.view_users = new SimpleBooleanProperty(view_users);
        this.edit_logs = new SimpleBooleanProperty(edit_logs);
        this.edit_users = new SimpleBooleanProperty(edit_users);
        this.edit_roles = new SimpleBooleanProperty(edit_roles);
    }

    public String getRoleName() {
        return roleName.get();
    }

    public SimpleStringProperty roleNameProperty() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName.set(roleName);
    }

    public boolean isEdit_logs() {
        return edit_logs.get();
    }

    public SimpleBooleanProperty edit_logsProperty() {
        return edit_logs;
    }

    public void setEdit_logs(boolean edit_logs) {
        this.edit_logs.set(edit_logs);
    }

    public boolean isView_roles() {
        return view_roles.get();
    }

    public SimpleBooleanProperty view_rolesProperty() {
        return view_roles;
    }

    public void setView_roles(boolean view_roles) {
        this.view_roles.set(view_roles);
    }

    public boolean isView_users() {
        return view_users.get();
    }

    public SimpleBooleanProperty view_usersProperty() {
        return view_users;
    }

    public void setView_users(boolean view_users) {
        this.view_users.set(view_users);
    }

    public boolean isEdit_users() {
        return edit_users.get();
    }

    public SimpleBooleanProperty edit_usersProperty() {
        return edit_users;
    }

    public void setEdit_users(boolean edit_users) {
        this.edit_users.set(edit_users);
    }

    public boolean isEdit_roles() {
        return edit_roles.get();
    }

    public SimpleBooleanProperty edit_rolesProperty() {
        return edit_roles;
    }

    public void setEdit_roles(boolean edit_roles) {
        this.edit_roles.set(edit_roles);
    }

    public boolean isView_logs() {
        return view_logs.get();
    }

    public SimpleBooleanProperty view_logsProperty() {
        return view_logs;
    }

    public void setView_logs(boolean view_logs) {
        this.view_logs.set(view_logs);
    }
}
