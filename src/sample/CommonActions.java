package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

class CommonActions {
    private Stage stage1;

    CommonActions(Stage stage, User user, Button main_btn, Button logs_btn, Button users_btn, Button roles_btn, Button logout_btn, Label db_label, ImageView db_icon, Label role_label)   {

        this.stage1 = stage;
        DbConnector dbConnector = new DbConnector();
        if (dbConnector.isConnected())  {
            db_label.setText("Database is Connected");
            db_label.setStyle("-fx-text-fill: limegreen");
            Image connected_img = new Image("img/database-connected.png");
            db_icon.setImage(connected_img);
        }
        else {
            db_label.setText("Database is NOT Connected");
            db_label.setStyle("-fx-text-fill: red");
            Image not_connected_img = new Image("img/database-not-connected.png");
            db_icon.setImage(not_connected_img);
        }

//        main_btn.setOnAction(e -> {});

//        logs_btn.setOnAction(e -> {});

//        users_btn.setOnAction(e -> {});

//        roles_btn.setOnAction(e -> {
//            try {
//                RolesPageController rolesPageController = new RolesPageController(user);
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("RolesPage.fxml"));
//                loader.setController(rolesPageController);
//                Parent root = loader.load();
//                stage1 = (Stage) roles_btn.getScene().getWindow();
//                Scene scene = new Scene(root, 850, 600);
//                stage1.setScene(scene);
//                stage1.show();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//
//        });
//
        logout_btn.setOnAction(e -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
                stage1 = (Stage) logout_btn.getScene().getWindow();
                stage1.setTitle("AUCyber");
                stage1.setScene(new Scene(root, 850, 600));
                stage1.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        switch (user.getRoleName())  {
            case "admin" :
                System.out.println("Admin has all privileges");
                role_label.setText("Admin");
                break;
            case "moderator" :
                System.out.println("Moderator can view everything, edit roles (not admins and other mods), update user but not delete and can NOT edit the logs");
                role_label.setText("Moderator");
                break;
            case "user" :
                System.out.println("User can view Own LogsPageController, and users NOT roles and can edit NOTHING");
                role_label.setText("User");
                break;
            default :
                System.out.println("Guest can view just users and can edit NOTHING");
                role_label.setText("Guest");
                break;
        }
    }
}
