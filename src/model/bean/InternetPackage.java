
package model.bean;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author: Dejan Smiljić; e-mail: dej4n.s@gmail.com
 *
 */
public class InternetPackage {

    private final IntegerProperty contractID = new SimpleIntegerProperty(this, "contractID");
    private final IntegerProperty speed = new SimpleIntegerProperty(this, "speed");
    private final StringProperty usage = new SimpleStringProperty(this, "usage");
    private final IntegerProperty contractDuration = new SimpleIntegerProperty(this, "contractDuration");
    private final StringProperty clientName = new SimpleStringProperty(this, "clientName");
    private final StringProperty clientAddress = new SimpleStringProperty(this, "clientAddress");
    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());

    //CONSTRUCTOR
    public InternetPackage() {
    }

    public InternetPackage(int contractId, int speed, String usage, int contractDuration, String clientName, String clientAddress) {

        this.contractID.set(contractId);
        this.speed.set(speed);
        this.usage.set(usage);
        this.contractDuration.set(contractDuration);
        this.clientName.set(clientName);
        this.clientAddress.set(clientAddress);

    }

    //GETTER, SETTER
    public ObjectProperty<ArrayList<String>> errorListProperty() {
        return errorList;
    }

    public String getClientAddress() {
        return clientAddress.get();
    }

    public void setClientAddress(String value) {
        clientAddress.set(value);
    }

    public StringProperty clientAddressProperty() {
        return clientAddress;
    }

    public String getClientName() {
        return clientName.get();
    }

    public void setClientName(String value) {
        clientName.set(value);
    }

    public StringProperty clientNameProperty() {
        return clientName;
    }

    public int getContractDuration() {
        return contractDuration.get();
    }

    public void setContractDuration(int value) {
        contractDuration.set(value);
    }

    public IntegerProperty contractDurationProperty() {
        return contractDuration;
    }

    public String getUsage() {
        return usage.get();
    }

    public void setUsage(String value) {
        usage.set(value);
    }

    public StringProperty usageProperty() {
        return usage;
    }

    public int getSpeed() {
        return speed.get();
    }

    public void setSpeed(int value) {
        speed.set(value);
    }

    public IntegerProperty speedProperty() {
        return this.speed;
    }

    public int getContractID() {
        return contractID.get();
    }

    public void setContractID(int value) {
        contractID.set(value);
    }

    public IntegerProperty contractIDProperty() {
        return contractID;
    }
    //GETTER, SETTER end

    //HELPER METHOD
    public boolean isValid() {
        boolean isValid = true;

        if (speed.get() == 0) {
            errorList.getValue().add("\n\tMissing data:\tInternet speed\n");
            isValid = false;
        }

        if (usage.get() == null) {
            errorList.getValue().add("\tMissing data:\tMonthly usage\n");
            isValid = false;
        }

        if (contractDuration.get() == 0) {
            errorList.getValue().add("\tMissing data:\tContract duration\n");
            isValid = false;
        }

        if (clientName.get() == null) {
            errorList.getValue().add("\tMissing data:\tFull name\n");
            isValid = false;
        }

        if (clientAddress.get() == null) {
            errorList.getValue().add("\tMissing data:\tAddress\n");
            isValid = false;
        }
        return isValid;
    }//isValid() END
    
    
}
