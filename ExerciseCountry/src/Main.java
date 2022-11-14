import javafx.application.*;
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


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        //epilogi manage
        Menu menuManage=new Menu("_Manage");
        MenuItem menuItemCountries=new MenuItem(("Countries"));
        MenuItem menuItemCities=new MenuItem(("Cities"));
        MenuItem menuItemLanguages=new MenuItem(("Languages"));
        menuManage.getItems().addAll(menuItemCountries,menuItemCities,menuItemLanguages);
        menuItemCountries.setOnAction(e->clickCountries());
        menuItemCountries.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN,KeyCombination.SHIFT_DOWN));
        menuItemCountries.setMnemonicParsing(true);
        menuItemCities.setOnAction(e->clickCities());
        menuItemCities.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN,KeyCombination.SHIFT_DOWN));
        menuItemCities.setMnemonicParsing(true);
        menuItemLanguages.setAccelerator(new KeyCodeCombination(KeyCode.L,KeyCombination.CONTROL_DOWN,KeyCombination.SHIFT_DOWN));
        menuItemLanguages.setMnemonicParsing(true);

        //epilogi diagrams
        Menu menuDiagrams=new Menu("_Diagrams");

        MenuItem menuItemCountriesPerContinent=new MenuItem("Countries per Continent");
        MenuItem menuItemCitiesPerCountry=new MenuItem(("Cities per Country"));
        MenuItem menuItemPopulationDistribution=new MenuItem(("PopulationDistribution"));
        MenuItem menuItemReligionDistribution=new MenuItem(("Religion Distribution"));
        menuDiagrams.getItems().addAll(menuItemCountriesPerContinent,menuItemCitiesPerCountry,new SeparatorMenuItem(),menuItemPopulationDistribution,menuItemReligionDistribution);

        //epilogi help
        Menu menuHelp=new Menu("_Help");
        MenuItem menuItemContents=new MenuItem(("Contents"));
        MenuItem menuItemAbout=new MenuItem(("About"));
        menuHelp.getItems().addAll(menuItemContents,menuItemAbout);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuManage,menuDiagrams,menuHelp);


        HBox menuPane = new HBox();
        menuPane.getChildren().addAll(menuBar);

        Image world=new Image("world.jpg");
        ImageView background = new ImageView(world);
        HBox hBox = new HBox();
        hBox.getChildren().add(background);


        BackgroundImage bImg = new BackgroundImage(world,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);





        VBox vBox=new VBox();
        vBox.getChildren().addAll(menuBar,hBox);



        Scene scene = new Scene(vBox);
        background.setFitHeight(scene.getHeight());
        background.setPreserveRatio(true);

        stage.setScene(scene);
        stage.setTitle("The World!");
        stage.setX((Screen.getPrimary().getVisualBounds().getWidth()-500)/2);
        stage.setY((Screen.getPrimary().getVisualBounds().getHeight()-600)/2);
        stage.setWidth(500);
        stage.setHeight(600);
        stage.setMaximized(true);

        stage.show();
    }

    public void clickCountries() {
        FormCountry fc = new FormCountry();
    }

    public void clickCities(){
        FormCity fc = new FormCity();
    }

    public static void main(String[] args) {
        launch(args);
    }
}