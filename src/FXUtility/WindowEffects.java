package FXUtility;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class WindowEffects {

    private final Stage primaryStage;
    private final Parent root;
    private double xOffset;
    private double yOffset;

    public WindowEffects(Stage primaryStage, Parent root) {
        this.primaryStage = primaryStage;
        this.root = root;
    }

    public final void MakeUndecoratedAndMovable() {

        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        root.setOnMousePressed((MouseEvent event) -> {
            
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
            
        });
        
        root.setOnMouseDragged((MouseEvent event) -> {
            
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);

        });
              
    }
    
    
    public static final void CloseEffect(MouseEvent event){
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        Timeline timeline = new Timeline();
        
        KeyFrame key = new KeyFrame(
                Duration.millis(100) , 
                new KeyValue(
                        stage.getScene().getRoot().opacityProperty(), 0
                )
        );
        
        timeline.getKeyFrames().add(key);
        timeline.setOnFinished((ae) -> stage.close());
        timeline.play();
        
    }

}
