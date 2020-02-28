
package serverproject;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Server extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent Server = FXMLLoader.load(getClass().getResource("server.fxml"));
        Scene scene = new Scene(Server);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
