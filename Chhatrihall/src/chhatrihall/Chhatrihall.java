

package chhatrihall;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rituparna Datta
 */
public class Chhatrihall extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       Parent root=FXMLLoader.load(getClass().getResource("login_1.fxml"));
       Scene scene=new Scene(root);
       primaryStage.setResizable(false);
       primaryStage.setTitle("CHHATRIHALL SEAT ALLOCATION");
      
       primaryStage.setScene(scene);
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}