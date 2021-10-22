import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class printDischargeController implements Initializable{
        @FXML
        private TextField firstName;

        @FXML
        private TextField lastName;

        @FXML
        private TextField nightsStayed;

        @FXML
        private TextArea dischargeInfo;

    @FXML
    void toNurseMenu(ActionEvent event) throws IOException {
        Main.patient.setNightsStayed(Integer.parseInt(nightsStayed.getText()));

        DatabaseInterface.updatePatient(Main.patient);

        Parent nurseMenuParent = FXMLLoader.load(getClass().getResource("nurseMenu.fxml"));
        Scene nurseMenuScene = new Scene(nurseMenuParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(nurseMenuScene);
        window.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String name = Main.patient.getName();
        String[] nameSplit = name.split(" ");
        firstName.setText(nameSplit[0]);
        lastName.setText(nameSplit[1]);
    }
}
