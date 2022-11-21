import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollBar;



public class Main extends Application 
{ 
  public GridPane gp = new GridPane();
  

  
  @Override
  public void start(Stage primaryStage) {
    double red= 0;
    double green=0;
    double blue=0;
    double opacity= .99; 

    ScrollBar slR = new ScrollBar();
    slR.setMax(255);
    ScrollBar slB = new ScrollBar();
    slB.setMax(255);
    ScrollBar slG = new ScrollBar();
    slG.setMax(255);
    ScrollBar slO = new ScrollBar();
    slO.setMax(1);

    

    Text text = new Text(100, 100, "Show Colors");
    text.setFill(Color.rgb((int)red, (int)green, (int)blue, opacity));
    text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    

    slR.valueProperty().addListener(ov ->
           {
               Color c = Color.rgb(
                       (int) slR.getValue(),
                       (int) slG.getValue(),
                       (int) slB.getValue(),
                       slO.getValue()); 
               text.setFill(c);    
           });
        
    slG.valueProperty().addListener(ov ->
           {
               Color c = Color.rgb(
                       (int) slR.getValue(),
                       (int) slG.getValue(),
                       (int) slB.getValue(),
                       slO.getValue());
               text.setFill(c);    
           });
        
    slB.valueProperty().addListener(ov ->
           {
               Color c = Color.rgb((int) slR.getValue(),(int) slG.getValue(),(int) slB.getValue(),slO.getValue());
               text.setFill(c);    
           });

    slO.valueProperty().addListener(ov ->
           {
               Color c = Color.rgb(
                       (int) slR.getValue(),
                       (int) slG.getValue(),
                       (int) slB.getValue(),
                       slO.getValue()); 
               text.setFill(c);    
           });
   


    
    gp.add(new Label("red"), 1,2);
    gp.add(new Label("Green"), 1,4);
    gp.add(new Label("Blue"), 1,6);
    gp.add(new Label("Opacity"), 1,8);
    gp.add(slO, 2, 8);
    gp.add(slG, 2, 4);
    gp.add(slB, 2, 6);
    gp.add(slR, 2, 2);
    gp.add(text, 2, 0);
    gp.setAlignment(Pos.CENTER);
    gp.setHgap(5);
    gp.setVgap(5);
    gp.setStyle("-fx-background-color: white");
    Scene scene = new Scene(gp, 600, 200);
    primaryStage.setTitle("yep");
    primaryStage.setScene(scene);
    primaryStage.show();
  } 
    
  public static void main(String[] args) {
    launch(args);
  }
} 