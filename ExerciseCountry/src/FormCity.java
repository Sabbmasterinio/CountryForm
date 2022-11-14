import javafx.event.Event;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class FormCity {
    Stage stage;
    Label lblName, lblcountry, lblDistrict, lblPopulation;

    TextField txtName, txtDistrict, txtPopulation;
    ComboBox<String> comCountry;
    ListView<City> lvCities;
    Button buttonAdd,buttonWrite,buttonDelete,btnSave,btnCancel;
    HBox hBoxAddEditDel,hBoxSaveCancel;

    private City kabul, qandahar, herat, mazarelsharif;


    public FormCity() {

        kabul = new City("Kabul", "Afghanistan", "Kabol", 1780000L);
        qandahar = new City("Qandahar", "Afghanistan", "Qandahar", 237500L);
        herat = new City("Herat", "Afghanistan", "Herat", 186800L);
        mazarelsharif = new City("Mazar-e-Sharif", "Afghanistan", "Balkh", 731200L);

        // the grid
        GridPane grid = new GridPane();
        grid.setHgap(3);
        grid.setVgap(5);


        // name

        lblName = new Label("Name: ");
        txtName = new TextField();

        grid.add(lblName,1,0);
        GridPane.setHalignment(lblName, HPos.RIGHT);
        GridPane.setValignment(lblName, VPos.CENTER);

        grid.add(txtName,2,0);
        GridPane.setHalignment(txtName, HPos.LEFT);
        GridPane.setValignment(txtName, VPos.CENTER);


        //country - comboBox

        lblcountry = new Label("Country: ");

        comCountry = new ComboBox<>();
        comCountry.getItems().addAll("Aruba", "Afghanistan", "Angola", "Anguilla");
        comCountry.setEditable(true);
        new AutoCompleteComboBoxListener<>(comCountry);

        grid.add(lblcountry,1,1);
        GridPane.setHalignment(lblcountry, HPos.RIGHT);
        GridPane.setValignment(lblcountry, VPos.CENTER);

        grid.add(comCountry,2,1);
        GridPane.setHalignment(comCountry, HPos.LEFT);
        GridPane.setValignment(comCountry, VPos.CENTER);

        //district

        lblDistrict = new Label("District: ");
        txtDistrict = new TextField();

        grid.add(lblDistrict,1,2);
        GridPane.setHalignment(lblDistrict, HPos.RIGHT);
        GridPane.setValignment(lblDistrict, VPos.CENTER);

        grid.add(txtDistrict,2,2);
        GridPane.setHalignment(txtDistrict, HPos.LEFT);
        GridPane.setValignment(txtDistrict, VPos.CENTER);

        // population

        lblPopulation = new Label("Population: ");

        txtPopulation = new TextField();

        grid.add(lblPopulation,1,3);
        GridPane.setHalignment(lblPopulation, HPos.RIGHT);
        GridPane.setValignment(lblPopulation, VPos.CENTER);

        grid.add(txtPopulation,2,3);
        GridPane.setHalignment(txtPopulation, HPos.LEFT);
        GridPane.setValignment(txtPopulation, VPos.CENTER);

        // the listview
        lvCities = new ListView<>();
        lvCities.getItems().addAll(kabul, qandahar, herat, mazarelsharif);
        lvCities.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    if(newValue!=null) {
                        try{
                            load_form(newValue);
                        }catch (NumberFormatException e){
                            System.out.println("ee kai ti egine");
                        }
                        System.out.println("City -> "+newValue);
                    }
                });
        grid.add(lvCities,0, 0);
        GridPane.setRowSpan(lvCities, grid.getRowCount()+1);
        GridPane.setHalignment(lvCities, HPos.LEFT);


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
        buttonAdd.setPrefWidth(lvCities.getWidth()/3-3);
        buttonWrite.setPrefWidth(lvCities.getWidth()/3-3);
        buttonDelete.setPrefWidth(lvCities.getWidth()/3-3);

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
        grid.add(hBoxSaveCancel,2,5);

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
                    lvCities.setPrefHeight(scene.getHeight());
                });
        scene.widthProperty().addListener(
                (observable, oldValue, newValue)-> grid.setPrefWidth(scene.getWidth()));


        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("City");
        stage.setX((Screen.getPrimary().getVisualBounds().getWidth()-700)/2);
        stage.setY((Screen.getPrimary().getVisualBounds().getHeight()-600)/2);
        stage.setWidth(700);
        stage.setHeight(600);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(499);
        stage.setMinHeight(565);



        startState();
        lvCities.setOnMouseClicked(e-> {
            labelsAndTextfieldsVisible(true);
            buttonAdd.disableProperty().set(false);
            buttonWrite.disableProperty().set(false);
            buttonDelete.disableProperty().set(false);
            if(lvCities.getSelectionModel().getSelectedItem()==null){
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
        lvCities.setDisable(false);
        textFieldEditable(false);
    }

    private void addToListView(){
        btnSave.setVisible(true);
        btnCancel.setVisible(true);
        buttonAdd.disableProperty().set(true);
        buttonWrite.disableProperty().set(true);
        buttonDelete.disableProperty().set(true);
        lvCities.getSelectionModel().clearSelection();
        lvCities.setDisable(true);
        labelsAndTextfieldsVisible(true);
        textFieldEditable(true);
        textFieldEmpty();
        btnSave.setOnAction(e->saveForm());
    }

    private void editForm(){
        textFieldEditable(true);
        btnSave.setVisible(true);
        btnCancel.setVisible(true);
        lvCities.setDisable(true);
        buttonAdd.disableProperty().set(true);
        buttonWrite.disableProperty().set(true);
        buttonDelete.disableProperty().set(true);
        btnSave.setOnAction(e->saveForm(lvCities.getSelectionModel().getSelectedItem()));

    }

    private void deleteFromListView(){
        btnSave.setVisible(false);
        btnCancel.setVisible(false);
        if(lvCities.getItems().size()>1)
            lvCities.getItems().remove(lvCities.getSelectionModel().getSelectedItem());
    }

    private void saveForm(){
        if (validateForm()) {
            City newCity = new City(txtName.getText(),comCountry.getValue(),txtDistrict.getText(),Long.parseLong(txtPopulation.getText()));

            lvCities.getItems().add(newCity);
            startState();
        }
    }
    private void saveForm(City city){

        if (validateForm()) {
            city.setName(txtName.getText());
            city.setCountry(comCountry.getValue());
            city.setDistrict(txtDistrict.getText());
            city.setPopulation(Long.parseLong(txtPopulation.getText()));
            startState();
        }
    }

    private void cancelForm(){
        lvCities.getSelectionModel().clearSelection();
        startState();
    }

    private void labelsAndTextfieldsVisible(Boolean bool){
        lblName.setVisible(bool);
        txtName.setVisible(bool);
        lblcountry.setVisible(bool);
        comCountry.setVisible(bool);
        lblDistrict.setVisible(bool);
        txtDistrict.setVisible(bool);
        lblPopulation.setVisible(bool);
        txtPopulation.setVisible(bool);
    }

    private void textFieldEditable (Boolean enable){
        if (enable){
            txtName.setEditable(true);
            comCountry.setDisable(false);
            txtDistrict.setEditable(true);
            txtPopulation.setEditable(true);
        }
        else {
            txtName.setEditable(false);
            comCountry.setDisable(true);
            txtDistrict.setEditable(false);
            txtPopulation.setEditable(false);
        }
    }

    private void textFieldEmpty(){
        txtName.clear();
        comCountry.getSelectionModel().clearSelection();
        txtDistrict.clear();
        txtPopulation.clear();
    }

    private boolean validateForm() {
        String errors = "";
        // Name: <=35 chars and non empty
        String name = txtName.getText();
        if (name.length() > 35) {
            errors += "Name must be <= 35 chars\n";
        }
        if (name.isBlank()) {
            errors += "Name can't be empty\n";
        }
        // Country: value should be in the list
        String country = comCountry.getValue();
        if (!comCountry.getItems().contains(country)) {
            errors += "Country must be a valid value\n";
        }
        // District: <=20 chars
        String district = txtDistrict.getText();
        if (district.length() > 20) {
            errors += "Name must be <= 20 chars\n";
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

        if (errors.length()>0) {
            new MessageBoxOK(errors, "ERRORS");
            return false;
        }
        else
            return  true;
    }

    public void load_form(City c) {
        txtName.setText(c.getName());
        comCountry.setValue(c.getCountry());
        txtDistrict.setText(c.getDistrict());
        txtPopulation.setText(c.getPopulation().toString());
    }

}