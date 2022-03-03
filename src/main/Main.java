
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author: Dejan Smiljić; e-mail: dej4n.s@gmail.com
 */
public class Main extends Application {
    
    private Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 355.0;
    private final double MINIMUM_WINDOW_HEIGHT = 500.0;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        this.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/view/fxml/FXMLMain.fxml"));
        
        Scene scene = new Scene(root);
        this.stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        this.stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        this.stage.setTitle("Internet Deal Registration | Demo");
        this.stage.setScene(scene);
        this.stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
