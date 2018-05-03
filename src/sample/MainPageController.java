package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainPageController implements Initializable{
    @FXML
    public Button main_btn;
    @FXML
    public Button users_btn;
    @FXML
    public Button logs_btn;
    @FXML
    public Button roles_btn;
    @FXML
    public Button logout_btn;
    @FXML
    public Label welcome_text;
    @FXML
    public Label db_label;
    @FXML
    public ImageView db_icon;
    @FXML
    public Label role_label;

    private User user = null;
    private Stage stage;
    private DbConnector dbConnector = new DbConnector();

    MainPageController(User user) {
        this.user = user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        CommonActions commonActions = new CommonActions(stage, user, main_btn, logs_btn, users_btn, roles_btn, logout_btn, db_label, db_icon, role_label);

        System.out.println(user.getUserName());

        String welcomeLabelWithName = welcome_text.getText() + ", " + user.getUserName();
        welcome_text.setText(welcomeLabelWithName);


//        switch (user.getRoleId())  {
//            case 21 :
//                System.out.println("Admin has all privileges");
//                role_label.setText("Admin");
//                break;
//            case 22 :
//                System.out.println("Moderator can view everything, edit roles (not admins and other mods), update user but not delete and can NOT edit the logs");
//                role_label.setText("Moderator");
//                break;
//            case 23 :
//                System.out.println("User can view Own LogsPageController, and users NOT roles and can edit NOTHING");
//                role_label.setText("User");
//                break;
//            default :
//                System.out.println("Guest can view just users and can edit NOTHING");
//                role_label.setText("Guest");
//                break;
//        }
        //Buid a URL

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

        new CoinmarketCapAPI();

        String  urlString = "https://api.coinmarketcap.com/v1/ticker/bitcoin/";
        try {
            URL url = new URL(urlString);

            //Read from the URL

            Scanner sc = new Scanner(url.openStream());
            StringBuilder str = new StringBuilder();
            while (sc.hasNext())
            {
                str.append(sc.nextLine());
            }

            str.deleteCharAt(0);
            str.deleteCharAt(str.length()-1);
            sc.close();

            System.out.println("MainPageController: String is " + str);

            //Build a JSONObject

            JSONObject obj = new JSONObject(str.toString());

            if (obj.getString("id").equals("bitcoin"))    {
                System.out.println("MainPageController: API can be read");
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
