package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable{
    @FXML
    public TextField username_tf;
    @FXML
    public PasswordField password_pf;
    @FXML
    public Button enter_btn;
    @FXML
    public Label db_label;
    @FXML
    public ImageView db_icon;

    private DbConnector dbConnector = new DbConnector();

    @Override
    public void initialize(URL location, ResourceBundle resources){

        Image connected_img = new Image("img/database-connected.png");
        Image not_connected_img = new Image("img/database-not-connected.png");

        if (dbConnector.isConnected())  {
            db_label.setText("Database is Connected");
            db_label.setStyle("-fx-text-fill: limegreen");
            db_icon.setImage(connected_img);
        }
        else {
            db_label.setText("Database is NOT Connected");
            db_label.setStyle("-fx-text-fill: red");
            db_icon.setImage(not_connected_img);
        }
    }

    public void enterAction(ActionEvent actionEvent)  {
        //Input values is taking from content.
        String userEmail = username_tf.getText();
        String pass = password_pf.getText();
        String hashedPass = null;
        //MySql Connection will be initialized.
        Connection conn;

        Stage stage;
        //Password is Hashing
        try {
            hashedPass = hashSha1(pass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //System.out.println("Username: " + userEmail + "\nPassword: " + pass +  "\nHashedPassword: " + hashedPass);

        //Login checking will be made by a Procedure which has been already set on Database.
        try {

            //MySql Connection is initializing.
            conn = dbConnector.getConnection();

            /*
              Procedure Details;
               PROCEDURE checkLogin(IN UserMail CHAR(80),
                                    IN HashedPassword CHAR(42),
                                    OUT UserID INT,
                                    OUT UserName VARCHAR(32),
                                    OUT UserSurname VARCHAR(42),
                                    OUT UserRole INT),
                                    OUT UserInterest VARCHAR(80)
             */

            //Stored Procedure is calling and its parameters are setting.
            CallableStatement stmt = conn.prepareCall("{CALL checkLogin(?,?,?,?,?,?,?)}");
            stmt.setString(1, userEmail);
            stmt.setString(2, hashedPass);
            stmt.registerOutParameter(3, Types.INTEGER);
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.registerOutParameter(5, Types.VARCHAR);
            stmt.registerOutParameter(6, Types.VARCHAR);
            stmt.registerOutParameter(7, Types.VARCHAR);

            stmt.execute();

            int userId = stmt.getInt(3);
            String userName = stmt.getString(4);
            String userSurname = stmt.getString(5);
            String roleName = stmt.getString(6);
            String userInterest = stmt.getString(7);

            stmt.close();
            conn.close();

            User user = new User(userName, userSurname, userInterest, userId, roleName);
            System.out.println(user.toString());

            if (userId > 0) {
                System.out.println("Username and Password are True...");
                try{
                    if (actionEvent.getSource() == enter_btn)   {
                        MainPageController mainPageController = new MainPageController(user);
                        System.out.println("Source has been found. And ready to action.");
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
                        loader.setController(mainPageController);
                        System.out.println("FXMLLoader has been loaded Main Page.");
                        Parent root = loader.load();
                        System.out.println("Parent has been loaded from loader.");
                        stage = (Stage) enter_btn.getScene().getWindow();
                        System.out.println("Stage has been initialized.");
                        Scene scene = new Scene(root, 850, 600);

                        stage.setScene(scene);

                        stage.show();
                    }
                }   catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static String hashSha1(String input) throws NoSuchAlgorithmException    {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        byte[] result = messageDigest.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte aResult : result) {
            sb.append(Integer.toString((aResult & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}