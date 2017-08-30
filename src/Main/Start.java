
package Main;

import FXUtility.WindowEffects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Start extends Application {
    
    
    private static final String FXML_LOGIN = "LoginForm/FXMLLogin.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
    
        FXMLLoader loader = new FXMLLoader(
                this.getClass().getClassLoader().getResource(FXML_LOGIN)
        );
        
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        
        WindowEffects effect = new WindowEffects(primaryStage, root);
        
        effect.MakeUndecoratedAndMovable();
        
        
        primaryStage.show();
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
