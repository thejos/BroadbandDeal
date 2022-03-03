
package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import model.bean.InternetPackage;

/**
 * FXML Controller class
 *
 * @author: Dejan Smiljić; e-mail: dej4n.s@gmail.com
 */
public class InternetPackageController {

    @FXML
    private JFXComboBox<Number> cbSpeed;
    @FXML
    private JFXComboBox<String> cbUsage;
    @FXML
    private JFXComboBox<Number> cbDuration;
    @FXML
    private JFXTextField tfName;
    @FXML
    private JFXTextField tfAddress;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnDelete;
    @FXML
    TableView<InternetPackage> tableView = new TableView<>();
    
    ObservableList<InternetPackage> contractList = FXCollections.<InternetPackage>observableArrayList();
    InternetPackage internetPackage;

    public InternetPackageController() {
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        internetPackage = new InternetPackage();
        
        tfName.textProperty().bindBidirectional(internetPackage.clientNameProperty());
        tfAddress.textProperty().bindBidirectional(internetPackage.clientAddressProperty());
        cbSpeed.valueProperty().bindBidirectional(internetPackage.speedProperty());
        cbUsage.valueProperty().bindBidirectional(internetPackage.usageProperty());
        cbDuration.valueProperty().bindBidirectional(internetPackage.contractDurationProperty());
        
        cbSpeed.getItems().addAll(2, 5, 10, 20, 50, 100);
        cbUsage.getItems().addAll("1", "5", "10", "100", "Flat");
        cbDuration.getItems().addAll(1, 2);
    }

    @FXML
    private void persistData(){
        if(internetPackage.isValid()){
            
            contractList = tableView.getItems();
            int id = contractList.size()+1;
            int speed = (int) cbSpeed.getSelectionModel().getSelectedItem();
            String usage = cbUsage.getSelectionModel().getSelectedItem();
            int duration = (int)cbDuration.getSelectionModel().getSelectedItem();
            contractList.add(new InternetPackage(id, speed, usage, duration, tfName.getText(), tfAddress.getText()));
            tableView.setItems(contractList);
        }else{
            StringBuilder errMsg = new StringBuilder();

	    ArrayList<String> errList = internetPackage.errorListProperty().get();
	    for(String errList1 : errList)
		errMsg.append(errList1);

	    Alert alert = new Alert(Alert.AlertType.WARNING);
	    alert.setTitle("Data Persistence Warning");
	    alert.setHeaderText(null);
	    alert.setContentText(errMsg.toString());
	    alert.showAndWait();
	    errList.clear();
        }
    }//persistData() END
    
    @FXML
    private void deleteData()
    {
	contractList = tableView.getItems();
	int index = tableView.selectionModelProperty().getValue().getSelectedIndex();
	       try {
            contractList.remove(index);
        } catch (Exception e) {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Data Deletion Error");
                   alert.setHeaderText(null);
                   alert.setContentText("\n\tNo data was selected!");
                   alert.showAndWait();
        }

	tableView.setItems(contractList);
    }
    
}
