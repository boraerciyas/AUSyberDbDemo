package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RolesPageController implements Initializable{
    public Label db_label;
    public ImageView db_icon;
    public Label role_label;
    public TableView<UserRoles> roles_tableview;
    public TableColumn<UserRoles, String> role_name_column;
    public TableColumn<UserRoles, Boolean> view_logs_column;
    public TableColumn<UserRoles, Boolean> view_roles_column;
    public TableColumn<UserRoles, Boolean> view_users_column;
    public TableColumn<UserRoles, Boolean> edit_logs_column;
    public TableColumn<UserRoles, Boolean> edit_roles_column;
    public TableColumn<UserRoles, Boolean> edit_users_column;

    private Stage stage;

    private final ObservableList<UserRoles> data = FXCollections.observableArrayList(
            new UserRoles("Admin", true, true, true, true, true, true),
            new UserRoles("Moderator", true, true, true, false, true, false),
            new UserRoles("User", true, false, true, false,false,false),
            new UserRoles("Guest", false, false, true, false, false, false)
    );
    public Button users_btn;
    public Button logs_btn;
    public Button roles_btn;
    public Button logout_btn;
    public Button main_btn;

    private User user;

    RolesPageController(User user)   {
        this.user = user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        role_name_column.setCellValueFactory(new PropertyValueFactory<>("roleName"));
        view_logs_column.setCellValueFactory(new PropertyValueFactory<>("view_logs"));
        view_roles_column.setCellValueFactory(new PropertyValueFactory<>("view_roles"));
        view_users_column.setCellValueFactory(new PropertyValueFactory<>("view_users"));
        edit_logs_column.setCellValueFactory(new PropertyValueFactory<>("edit_logs"));
        edit_roles_column.setCellValueFactory(new PropertyValueFactory<>("edit_roles"));
        edit_users_column.setCellValueFactory(new PropertyValueFactory<>("edit_users"));
        roles_tableview.setItems(data);

        CommonActions commonActions = new CommonActions(stage, user, main_btn, logs_btn, users_btn, roles_btn, logout_btn, db_label, db_icon, role_label);

        main_btn.setOnAction(e ->{
            try {
                MainPageController mainPageController = new MainPageController(user);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
                loader.setController(mainPageController);
                Parent root = loader.load();
                stage= (Stage) roles_btn.getScene().getWindow();
                Scene scene = new Scene(root, 850, 600);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        users_btn.setOnAction(e -> {
            try {
                UsersPageController usersPageController = new UsersPageController(user);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("UsersPage.fxml"));
                loader.setController(usersPageController);
                Parent root = loader.load();
                stage= (Stage) users_btn.getScene().getWindow();
                Scene scene = new Scene(root, 850, 600);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        logs_btn.setOnAction(e -> {
            try {
                LogsPageController logsPageController = new LogsPageController(user);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LogsPage.fxml"));
                loader.setController(logsPageController);
                Parent root = loader.load();
                stage= (Stage) logs_btn.getScene().getWindow();
                Scene scene = new Scene(root, 850, 600);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        roles_btn.setOnAction(e -> {
            try {
                RolesPageController rolesPageController = new RolesPageController(user);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("RolesPage.fxml"));
                loader.setController(rolesPageController);
                Parent root = loader.load();
                stage= (Stage) roles_btn.getScene().getWindow();
                Scene scene = new Scene(root, 850, 600);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }
}
