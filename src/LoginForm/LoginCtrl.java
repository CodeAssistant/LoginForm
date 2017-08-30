package LoginForm;

import FXUtility.WindowEffects;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginCtrl implements Initializable {

    private static final String FXML_MAIN_PATH = "MainForm/FXMLMain.fxml";
    

    @FXML
    private AnchorPane RootAnchorPane;

    @FXML
    private MaterialDesignIconView CloseButton;
    @FXML
    private JFXTextField Username;
    @FXML
    private JFXPasswordField Password;
    @FXML
    private JFXButton Accedi;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void CloseOnClick(MouseEvent event) {

        WindowEffects.CloseEffect(event);

    }

    @FXML
    private void AccediOnClick(ActionEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        try {

            FXMLLoader fxmlFile = new FXMLLoader(
                    this.getClass().getClassLoader().getResource(FXML_MAIN_PATH)
            );

            Parent root = (Parent) fxmlFile.load();
            Stage stageMain = new Stage();
            stageMain.setScene(new Scene(root));
            stageMain.show();

            stage.close();

        }
        catch (IOException ex) {
            Logger.getLogger(LoginCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
