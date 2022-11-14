import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.io.*;


public class FormCountry {
        Stage stage;
        Label lblCode, lblName, lblContinent, lblRegion,
                lblSurfaceArea, lblIndepYear, lblPopulation,
                lblLifeExpectancy, lblGNP, lblLocalName,
                lblGovernmentForm, lblHeadOfState, lblCapital, lblCode2;
        TextField txtCode, txtName, txtRegion,
                txtSurfaceArea, txtIndepYear, txtPopulation,
                txtLifeExpectancy, txtGNP, txtLocalName,
                txtGovernmentForm, txtHeadOfState, txtCapital, txtCode2;
        ComboBox<String> comContinent;
        ListView<Country> lvCountries;
        Button buttonAdd,buttonWrite,buttonDelete,btnSave,btnCancel;
        HBox hBoxAddEditDel,hBoxSaveCancel;

        public FormCountry() {

                // the grid
                GridPane grid = new GridPane();
                grid.setHgap(3);
                grid.setVgap(5);


                // code
                lblCode = new Label("Code: ");
                txtCode = new TextField();

                grid.add(lblCode,1,0);
                GridPane.setHalignment(lblCode, HPos.RIGHT);
                GridPane.setValignment(lblCode, VPos.CENTER);

                grid.add(txtCode,2,0);
                GridPane.setHalignment(txtCode, HPos.LEFT);
                GridPane.setValignment(txtCode, VPos.CENTER);


                // name

                lblName = new Label("Name: ");
                txtName = new TextField();

                grid.add(lblName,1,1);
                GridPane.setHalignment(lblName, HPos.RIGHT);
                GridPane.setValignment(lblName, VPos.CENTER);

                grid.add(txtName,2,1);
                GridPane.setHalignment(txtName, HPos.LEFT);
                GridPane.setValignment(txtName, VPos.CENTER);


                // continent

                lblContinent = new Label("Continent: ");

                comContinent = new ComboBox<>();
                comContinent.setEditable(true);
                comContinent.getItems().addAll("Africa", "Antarctica", "Asia", "Europe", "North America", "Oceania", "South America");
                new AutoCompleteComboBoxListener<>(comContinent);

                grid.add(lblContinent,1,2);
                GridPane.setHalignment(lblContinent, HPos.RIGHT);
                GridPane.setValignment(lblContinent, VPos.CENTER);

                grid.add(comContinent,2,2);
                GridPane.setHalignment(comContinent, HPos.LEFT);
                GridPane.setValignment(comContinent, VPos.CENTER);


                // region

                lblRegion = new Label("Region: ");

                txtRegion = new TextField();

                grid.add(lblRegion,1,3);
                GridPane.setHalignment(lblRegion, HPos.RIGHT);
                GridPane.setValignment(lblRegion, VPos.CENTER);

                grid.add(txtRegion,2,3);
                GridPane.setHalignment(txtRegion, HPos.LEFT);
                GridPane.setValignment(txtRegion, VPos.CENTER);


                // surface

                lblSurfaceArea = new Label("Surface Area: ");

                txtSurfaceArea = new TextField();

                grid.add(lblSurfaceArea,1,4);
                GridPane.setHalignment(lblSurfaceArea, HPos.RIGHT);
                GridPane.setValignment(lblSurfaceArea, VPos.CENTER);

                grid.add(txtSurfaceArea,2,4);
                GridPane.setHalignment(txtSurfaceArea, HPos.LEFT);
                GridPane.setValignment(txtSurfaceArea, VPos.CENTER);


                // independence year

                lblIndepYear = new Label("Independence Year: ");

                txtIndepYear = new TextField();

                grid.add(lblIndepYear,1,5);
                GridPane.setHalignment(lblIndepYear, HPos.RIGHT);
                GridPane.setValignment(lblIndepYear, VPos.CENTER);

                grid.add(txtIndepYear,2,5);
                GridPane.setHalignment(txtIndepYear, HPos.LEFT);
                GridPane.setValignment(txtIndepYear, VPos.CENTER);


                // population

                lblPopulation = new Label("Population: ");

                txtPopulation = new TextField();

                grid.add(lblPopulation,1,6);
                GridPane.setHalignment(lblPopulation, HPos.RIGHT);
                GridPane.setValignment(lblPopulation, VPos.CENTER);

                grid.add(txtPopulation,2,6);
                GridPane.setHalignment(txtPopulation, HPos.LEFT);
                GridPane.setValignment(txtPopulation, VPos.CENTER);


                // life expectancy

                lblLifeExpectancy = new Label("Life Expectancy: ");

                txtLifeExpectancy = new TextField();

                grid.add(lblLifeExpectancy,1,7);
                GridPane.setHalignment(lblLifeExpectancy, HPos.RIGHT);
                GridPane.setValignment(lblLifeExpectancy, VPos.CENTER);

                grid.add(txtLifeExpectancy,2,7);
                GridPane.setHalignment(txtLifeExpectancy, HPos.LEFT);
                GridPane.setValignment(txtLifeExpectancy, VPos.CENTER);


                // GNP

                lblGNP = new Label("GNP: ");

                txtGNP = new TextField();

                grid.add(lblGNP,1,8);
                GridPane.setHalignment(lblGNP, HPos.RIGHT);
                GridPane.setValignment(lblGNP, VPos.CENTER);

                grid.add(txtGNP,2,8);
                GridPane.setHalignment(txtGNP, HPos.LEFT);
                GridPane.setValignment(txtGNP, VPos.CENTER);


                // local name

                lblLocalName = new Label("Local Name: ");

                txtLocalName = new TextField();

                grid.add(lblLocalName,1,9);
                GridPane.setHalignment(lblLocalName, HPos.RIGHT);
                GridPane.setValignment(lblLocalName, VPos.CENTER);

                grid.add(txtLocalName,2,9);
                GridPane.setHalignment(txtLocalName, HPos.LEFT);
                GridPane.setValignment(txtLocalName, VPos.CENTER);


                // government form

                lblGovernmentForm = new Label("Government Form: ");

                txtGovernmentForm = new TextField();

                grid.add(lblGovernmentForm,1,10);
                GridPane.setHalignment(lblGovernmentForm, HPos.RIGHT);
                GridPane.setValignment(lblGovernmentForm, VPos.CENTER);

                grid.add(txtGovernmentForm,2,10);
                GridPane.setHalignment(txtGovernmentForm, HPos.LEFT);
                GridPane.setValignment(txtGovernmentForm, VPos.CENTER);


                // head of state

                lblHeadOfState = new Label("Head of State: ");

                txtHeadOfState = new TextField();

                grid.add(lblHeadOfState,1,11);
                GridPane.setHalignment(lblHeadOfState, HPos.RIGHT);
                GridPane.setValignment(lblHeadOfState, VPos.CENTER);

                grid.add(txtHeadOfState,2,11);
                GridPane.setHalignment(txtHeadOfState, HPos.LEFT);
                GridPane.setValignment(txtHeadOfState, VPos.CENTER);


                // capital

                lblCapital = new Label("Capital: ");

                txtCapital = new TextField();

                grid.add(lblCapital,1,12);
                GridPane.setHalignment(lblCapital, HPos.RIGHT);
                GridPane.setValignment(lblCapital, VPos.CENTER);

                grid.add(txtCapital,2,12);
                GridPane.setHalignment(txtCapital, HPos.LEFT);
                GridPane.setValignment(txtCapital, VPos.CENTER);


                // code 2

                lblCode2 = new Label("Code2: ");

                txtCode2 = new TextField();

                grid.add(lblCode2,1,13);
                GridPane.setHalignment(lblCode2, HPos.RIGHT);
                GridPane.setValignment(lblCode2, VPos.CENTER);

                grid.add(txtCode2,2,13);
                GridPane.setHalignment(txtCode2, HPos.LEFT);
                GridPane.setValignment(txtCode2, VPos.CENTER);



                // the listview
                lvCountries = new ListView<>();
                lvCountries.getSelectionModel().selectedItemProperty().
                        addListener((observable, oldValue, newValue) -> {
                                if(newValue!=null) {
                                    try{
                                            load_form(newValue);
                                    }catch (NumberFormatException e){
                                            System.out.println("ee kai ti egine");
                                    }
                                    System.out.println("Country -> "+newValue);
                                }
                        });
                grid.add(lvCountries,0, 0);
                GridPane.setRowSpan(lvCountries, grid.getRowCount()+1);
                GridPane.setHalignment(lvCountries, HPos.LEFT);


                //The buttons used
                buttonAdd=new Button();
                buttonWrite=new Button();
                buttonDelete=new Button();
                btnSave=new Button("Save");
                btnCancel=new Button("Cancel");


                //button images
                buttonAdd.setGraphic(new ImageView(new Image("add.png")));
                buttonWrite.setGraphic(new ImageView(new Image("write.png")));
                buttonDelete.setGraphic(new ImageView(new Image("delete.png")));

                //some button prefs
                buttonAdd.setPrefWidth(lvCountries.getWidth()/3-3);
                buttonWrite.setPrefWidth(lvCountries.getWidth()/3-3);
                buttonDelete.setPrefWidth(lvCountries.getWidth()/3-3);

//buttons clicked
                buttonAdd.setOnAction(e->addToListView());
                buttonWrite.setOnAction(e->editForm());
                buttonDelete.setOnAction(e->deleteFromListView());

                btnCancel.setOnAction(e->cancelForm());




                //hbox for image-buttons
                hBoxAddEditDel = new HBox();
                hBoxAddEditDel.getChildren().addAll(buttonAdd,buttonWrite,buttonDelete);
                hBoxAddEditDel.setSpacing(10);
                hBoxAddEditDel.setAlignment(Pos.CENTER);
                grid.add(hBoxAddEditDel,0,grid.getRowCount()+1);

                //hbox for save-cancel
                hBoxSaveCancel = new HBox();
                hBoxSaveCancel.getChildren().addAll(btnSave,btnCancel);
                hBoxSaveCancel.setSpacing(10);
                hBoxSaveCancel.setAlignment(Pos.TOP_LEFT);
                grid.add(hBoxSaveCancel,2,14);

                GridPane.setRowSpan(hBoxSaveCancel,3);
                GridPane.setHalignment(hBoxSaveCancel,HPos.CENTER);

                // some more grid work
                grid.setPrefWidth(700);
                grid.setAlignment(Pos.TOP_CENTER);
                grid.setPadding(new Insets(5));

                ColumnConstraints col0 = new ColumnConstraints();
                col0.setPrefWidth(200);
                col0.setHalignment(HPos.LEFT);
                ColumnConstraints col1 = new ColumnConstraints();
                col1.setHgrow(Priority.SOMETIMES);
                ColumnConstraints col2 = new ColumnConstraints();
                col2.setHgrow(Priority.SOMETIMES);

                //empty space

                Region rEmpty = new Region();
                grid.add(rEmpty, 3,0);
                ColumnConstraints col3 = new ColumnConstraints();
                col3.setHgrow(Priority.SOMETIMES);

                grid.getColumnConstraints().addAll(col0, col1, col2, col3);

                // the scene
                Scene scene = new Scene(grid);
                scene.heightProperty().addListener(
                        (observable, oldValue, newValue)-> {
                                grid.setPrefHeight(scene.getHeight());
                                lvCountries.setPrefHeight(scene.getHeight());
                        });
                scene.widthProperty().addListener(
                        (observable, oldValue, newValue)-> grid.setPrefWidth(scene.getWidth()));

                stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Country");
                stage.setX((Screen.getPrimary().getVisualBounds().getWidth()-700)/2);
                stage.setY((Screen.getPrimary().getVisualBounds().getHeight()-600)/2);
                stage.setWidth(700);
                stage.setHeight(600);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setMinWidth(499);
                stage.setMinHeight(565);
                stage.setOnCloseRequest(e-> {
                        saveFile("countries.data");
                });

                loadFile("countries.data");
                startState();
                lvCountries.setOnMouseClicked(e-> {
                    labelsAndTextfieldsVisible(true);
                    buttonAdd.disableProperty().set(false);
                    buttonWrite.disableProperty().set(false);
                    buttonDelete.disableProperty().set(false);
                        if(lvCountries.getSelectionModel().getSelectedItem()==null){
                                labelsAndTextfieldsVisible(false);
                        }
                });

                stage.show();

        }


        private void startState(){
                labelsAndTextfieldsVisible(false);
                btnSave.setVisible(false);
                btnCancel.setVisible(false);
                buttonAdd.disableProperty().set(false);
                buttonWrite.disableProperty().set(true);
                buttonDelete.disableProperty().set(true);
                lvCountries.setDisable(false);
                textFieldEditable(false);
        }

        private void addToListView(){
                btnSave.setVisible(true);
                btnCancel.setVisible(true);
                buttonAdd.disableProperty().set(true);
                buttonWrite.disableProperty().set(true);
                buttonDelete.disableProperty().set(true);
                lvCountries.getSelectionModel().clearSelection();
                lvCountries.setDisable(true);
                labelsAndTextfieldsVisible(true);
                textFieldEditable(true);
                textFieldEmpty();
                btnSave.setOnAction(e->saveForm());
        }

        private void editForm(){
                textFieldEditable(true);
                btnSave.setVisible(true);
                btnCancel.setVisible(true);
                lvCountries.setDisable(true);
                buttonAdd.disableProperty().set(true);
                buttonWrite.disableProperty().set(true);
                buttonDelete.disableProperty().set(true);
                btnSave.setOnAction(e->saveForm(lvCountries.getSelectionModel().getSelectedItem()));

        }

        private void deleteFromListView(){
                btnSave.setVisible(false);
                btnCancel.setVisible(false);
                if(lvCountries.getItems().size()>1)
                        lvCountries.getItems().remove(lvCountries.getSelectionModel().getSelectedItem());
        }

        private void saveForm(){
                if (validateForm()) {
                        Country newCountry = new Country(txtCode.getText(),txtName.getText(),comContinent.getValue(),txtRegion.getText(),Double.valueOf(txtSurfaceArea.getText()),
                                Integer.valueOf(txtIndepYear.getText()),Long.valueOf(txtPopulation.getText()),Double.valueOf(txtLifeExpectancy.getText()),
                                Double.valueOf(txtGNP.getText()), Double.valueOf(txtGNP.getText()),txtLocalName.getText(),txtGovernmentForm.getText(),
                                txtHeadOfState.getText(),Integer.valueOf(txtCapital.getText()),txtCode2.getText());

                        lvCountries.getItems().add(newCountry);
                        startState();
                }
        }
        private void saveForm(Country country){

                                if (validateForm()) {
                                        country.setCode(txtCode.getText());
                                        country.setName(txtName.getText());
                                        country.setContinent(comContinent.getValue());
                                        country.setRegion(txtRegion.getText());
                                        country.setSurfaceArea(Double.valueOf(txtSurfaceArea.getText()));
                                        country.setIndepYear(Integer.valueOf(txtIndepYear.getText()));
                                        country.setPopulation(Long.valueOf(txtPopulation.getText()));
                                        country.setLifeExpectancy(Double.valueOf(txtLifeExpectancy.getText()));
                                        country.setGNP(Double.valueOf(txtGNP.getText()));
                                        country.setLocalName(txtLocalName.getText());
                                        country.setGovernmentForm(txtGovernmentForm.getText());
                                        country.setHeadOfState(txtHeadOfState.getText());
                                        country.setCapital(Integer.valueOf(txtCapital.getText()));
                                        country.setCode2(txtCode2.getText());
                                        startState();
                                }

        }

        private void cancelForm(){
                lvCountries.getSelectionModel().clearSelection();
                startState();
        }

        private void labelsAndTextfieldsVisible(Boolean bool){
        lblCode.setVisible(bool);
        txtCode.setVisible(bool);
        lblName.setVisible(bool);
        txtName.setVisible(bool);
        lblContinent.setVisible(bool);
        comContinent.setVisible(bool);
        lblRegion.setVisible(bool);
        txtRegion.setVisible(bool);
        lblSurfaceArea.setVisible(bool);
        txtSurfaceArea.setVisible(bool);
        lblIndepYear.setVisible(bool);
        txtIndepYear.setVisible(bool);
        lblPopulation.setVisible(bool);
        txtPopulation.setVisible(bool);
        lblLifeExpectancy.setVisible(bool);
        txtLifeExpectancy.setVisible(bool);
        lblGNP.setVisible(bool);
        txtGNP.setVisible(bool);
        lblLocalName.setVisible(bool);
        txtLocalName.setVisible(bool);
        lblGovernmentForm.setVisible(bool);
        txtGovernmentForm.setVisible(bool);
        lblHeadOfState.setVisible(bool);
        txtHeadOfState.setVisible(bool);
        lblCapital.setVisible(bool);
        txtCapital.setVisible(bool);
        lblCode2.setVisible(bool);
        txtCode2.setVisible(bool);
    }

        private void textFieldEditable (Boolean enable){
                if (enable){
                        txtCode.setEditable(true);
                        txtName.setEditable(true);
                        comContinent.setDisable(false);
                        txtRegion.setEditable(true);
                        txtSurfaceArea.setEditable(true);
                        txtIndepYear.setEditable(true);
                        txtPopulation.setEditable(true);
                        txtLifeExpectancy.setEditable(true);
                        txtGNP.setEditable(true);
                        txtLocalName.setEditable(true);
                        txtGovernmentForm.setEditable(true);
                        txtHeadOfState.setEditable(true);
                        txtCapital.setEditable(true);
                        txtCode2.setEditable(true);
                }
                else {
                        txtCode.setEditable(false);
                        txtName.setEditable(false);
                        comContinent.setDisable(true);
                        txtRegion.setEditable(false);
                        txtSurfaceArea.setEditable(false);
                        txtIndepYear.setEditable(false);
                        txtPopulation.setEditable(false);
                        txtLifeExpectancy.setEditable(false);
                        txtGNP.setEditable(false);
                        txtLocalName.setEditable(false);
                        txtGovernmentForm.setEditable(false);
                        txtHeadOfState.setEditable(false);
                        txtCapital.setEditable(false);
                        txtCode2.setEditable(false);
                }
        }

        private void textFieldEmpty(){
            txtCode.clear();
            txtName.clear();
            comContinent.getSelectionModel().clearSelection();
            txtRegion.clear();
            txtSurfaceArea.clear();
            txtIndepYear.clear();
            txtPopulation.clear();
            txtLifeExpectancy.clear();
            txtGNP.clear();
            txtLocalName.clear();
            txtGovernmentForm.clear();
            txtHeadOfState.clear();
            txtCapital.clear();
            txtCode2.clear();

        }

        private boolean validateForm() {
                String errors = "";
                // Code: 3 characters
                String code = txtCode.getText().toUpperCase();
                if (code.length() != 3) {
                        errors += "Code must be exactly 3 characters\n";
                }
                // Name: <=52 chars and non empty
                String name = txtName.getText();
                if (name.length() > 52) {
                        errors += "Name must be <= 52 chars\n";
                }
                if (name.isBlank()) {
                        errors += "Name can't be empty\n";
                }
                // Continent: value should be in the list
                String continent = comContinent.getValue();
                if (!comContinent.getItems().contains(continent)) {
                        errors += "Continent must be a valid value\n";
                }
                // Region: <=26 chars
                String region = txtRegion.getText();
                if (region.length() > 26) {
                        errors += "Region must be <= 26 chars\n";
                }
                if (region.isBlank()) {
                        errors += "Region can't be empty\n";
                }
                // SurfaceArea: must be double
                Double surfaceArea = null;
                try {
                        surfaceArea = Double.valueOf(txtSurfaceArea.getText());
                } catch (NumberFormatException ob) {
                        errors += "Surface Area must be a number\n";
                }
                // IndepYear: must be an integer <=9999
                Integer indepYear = null;
                try {
                        indepYear = Integer.valueOf(txtIndepYear.getText());
                        if (indepYear>9999)
                                errors += "Invalid IndepYear\n";
                } catch (NumberFormatException ob) {
                        errors += "Indep Year must be a number\n";

                }
                // Population: must be a long < 10bn
                Long population = null;
                try {
                        population = Long.valueOf(txtPopulation.getText());
                        if (population<0 || population>10000000000L)
                                errors += "Invalid Population\n";
                } catch (NumberFormatException ob) {
                        errors += "Population must be a number\n";
                }
                // LifeExpectancy: must be double
                Double lifeExpectancy = null;
                try {
                        lifeExpectancy = Double.valueOf(txtLifeExpectancy.getText());
                } catch (NumberFormatException ob) {
                        if (txtLifeExpectancy.getText().length()!=0)
                                errors += "Life Expectancy must be a number\n";
                }
                // GNP: must be double
                Double GNP = null;
                try {
                        GNP = Double.valueOf(txtGNP.getText());
                } catch (NumberFormatException ob) {
                        if (txtGNP.getText().length()!=0)
                                errors += "GNP must be a number\n";
                }
                // LocalName: <=45 chars
                String localName = txtLocalName.getText();
                if (localName.length() > 45) {
                        errors += "Local Name must be <= 26 chars\n";
                }
                if (localName.isBlank()) {
                        errors += "Local Name can't be empty\n";
                }
                // GovernmentForm: <=45 chars
                String governmentForm = txtGovernmentForm.getText();
                if (governmentForm.length() > 45) {
                        errors += "GovernmentForm must be <= 45 chars\n";
                }
                if (governmentForm.isBlank()) {
                        errors += "Government Form can't be empty\n";
                }
                // HeadOfState: <=60 chars
                String headOfState = txtHeadOfState.getText();
                if (headOfState.length() > 60) {
                        errors += "GovernmentForm must be <= 60 chars\n";
                }
                // Capital: let it be for now
                String capital = txtCapital.getText();
                // Code: 2 characters
                String code2 = txtCode2.getText().toUpperCase();
                if (code2.length() != 2) {
                        errors += "Code2 must be exactly 2 characters\n";
                }
                if (code2.isBlank()) {
                        errors += "Code2 can't be empty\n";
                }

                if (errors.length()>0) {
                        new MessageBoxOK(errors, "ERRORS");
                        return false;
                }
//                else {
//                       // stage.close();
//                        String output =
//                                "code: " + code + "\n" +
//                                        "name: " + name + "\n" +
//                                        "continent: " + continent + "\n" +
//                                        "region: " + region + "\n" +
//                                        "surface area: " + surfaceArea + "\n" +
//                                        "independence year: " + indepYear + "\n" +
//                                        "population: " + population + "\n" +
//                                        "life expectancy: " + lifeExpectancy + "\n" +
//                                        "GNP: " + GNP + "\n" +
//                                        "local name: " + localName + "\n" +
//                                        "government form: " + governmentForm + "\n" +
//                                        "head of state: " + headOfState + "\n" +
//                                        "capital: " + capital + "\n" +
//                                        "code2: " + code2 + "\n";
//                        System.out.println(output);
//                        return true;
//                }
                else return  true;
        }

        public void load_form(Country c) {
                txtCode.setText(c.getCode());
                txtName.setText(c.getName());
                comContinent.setValue(c.getContinent());
                txtRegion.setText(c.getRegion());
                txtSurfaceArea.setText(c.getSurfaceArea().toString());
                txtIndepYear.setText(c.getIndepYear()==null?"":c.getIndepYear().toString());
                txtPopulation.setText(c.getPopulation().toString());
                txtLifeExpectancy.setText(c.getLifeExpectancy()==null?"":c.getLifeExpectancy().toString());
                txtGNP.setText(c.getGNP()==null?"":c.getGNP().toString());
                txtLocalName.setText(c.getLocalName());
                txtGovernmentForm.setText(c.getGovernmentForm());
                txtHeadOfState.setText(c.getHeadOfState()==null?"":c.getHeadOfState());
                txtCapital.setText(c.getCapital()==null?"":c.getCapital().toString());
                txtCode2.setText(c.getCode2());
        }

        public void saveFile(String fileName) {
                File f = new File(fileName);

                try(ObjectOutputStream os = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(f)))) {
                        for (var country: lvCountries.getItems())
                                os.writeObject(country);
                }
                catch (IOException ignored) {}
        }

        public void loadFile(String fileName) {
                File f = new File(fileName);
                try(ObjectInputStream os = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(f)))) {
                        while(true)
                                lvCountries.getItems().add((Country) os.readObject());
                }
                catch (IOException | ClassNotFoundException ignored) { }
        }

}