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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UsersPageController implements Initializable {

    private Stage stage;

    public Button users_btn;
    public Button logs_btn;
    public Button roles_btn;
    public Button logout_btn;
    public Button main_btn;
    public Button delete_button;
    public Button edit_button;
    public Label db_label;
    public ImageView db_icon;
    public Label role_label;
    public TableView<User> users_table;
    public TableColumn<User, String> username_column;
    public TableColumn<User, String> usersurname_column;
    public TableColumn<User, String> rolename_column;
    public TableColumn<User, String> useremail_column;
    public TableColumn<User, String> userinterest_column;

    private User user;

    private DbConnector dbConnector = new DbConnector();


    UsersPageController(User user)  {
        this.user = user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CommonActions commonActions = new CommonActions(stage, user, main_btn, logs_btn, users_btn, roles_btn, logout_btn, db_label, db_icon, role_label);

        Connection connection;

        try {
            //Database connection is initialized.
            connection = dbConnector.getConnection();

//
//            CREATE PROCEDURE getUsers()
//                BEGIN
//                    SELECT u.UserName, u.UserSurname, u.UserEmail, u.UserInterest, r.RoleName
//                    FROM User_Roles ur
//                    INNER JOIN User u ON ur.UserID = u.UserID
//                    INNER JOIN Role r ON ur.RoleID = r.RoleID;
//                END

            CallableStatement stmt = connection.prepareCall("CALL getUsers()");
            ResultSet rs = stmt.executeQuery();

//            List usersList = resultSetToArrayList(rs);
            ArrayList<User> usersList = new ArrayList<>();

            //Processing ResultSet.
            while (rs.next())   {
                String userName = rs.getString(1);
                String userSurname = rs.getString(2);
                String userEmail = rs.getString(3);
                String userRoleName = rs.getString(4);
                String userInterest = rs.getString(5);

                User user1 = new User(userName, userSurname, userEmail, userInterest, userRoleName);
                usersList.add(user1);
                System.out.println(user1.getUserName() + " has been added to List");
            }
            //Setting User data to table.
            ObservableList<User> data = FXCollections.observableArrayList(usersList);

            //Placing data to columns.
            username_column.setCellValueFactory(new PropertyValueFactory<>("userName"));
            usersurname_column.setCellValueFactory(new PropertyValueFactory<>("userSurname"));
            useremail_column.setCellValueFactory(new PropertyValueFactory<>("userEmail"));
            userinterest_column.setCellValueFactory(new PropertyValueFactory<>("userInterest"));
            rolename_column.setCellValueFactory(new PropertyValueFactory<>("roleName"));

            users_table.setItems(data);

            //Database connection is closed.
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Listener for selected User to be able to operate some actions.
        users_table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null)   {
                delete_button.disableProperty().setValue(false);
                edit_button.disableProperty().setValue(false);
            }
        });

        //Default Button's Actions are set.
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
        logs_btn.setOnAction(e -> {
            try {
                LogsPageController logsPageController = new LogsPageController(user);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LogsPage.fxml"));
                loader.setController(logsPageController);
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
        roles_btn.setOnAction(e -> {
            try {
                RolesPageController rolesPageController = new RolesPageController(user);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("RolesPage.fxml"));
                loader.setController(rolesPageController);
                Parent root = loader.load();
                stage = (Stage) roles_btn.getScene().getWindow();
                Scene scene = new Scene(root, 850, 600);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
//    private List resultSetToArrayList(ResultSet rs) {
//        ArrayList list = new ArrayList();
//        try {
//            ResultSetMetaData md  = rs.getMetaData();
//            int columns = md.getColumnCount();
//            System.out.println("ResultSet Column Count: "+columns);
//
//            while (rs.next())   {
//                HashMap row = new HashMap(columns);
//                for (int i = 1; i<= columns; ++i)    {
//                    row.put(md.getColumnName(i),rs.getObject(i));
//                }
//                list.add(row);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(list);
//        return list;
//    }
}
