package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			HBox hBox = new HBox() ;
			hBox.setAlignment(Pos.CENTER);
			hBox.setPadding(new Insets(10));
			hBox.setSpacing(10) ;
			
			Button btnCreate = new Button("生成号码") ;	
			btnCreate.setPrefWidth(100);
			TextField redArea = new TextField() ;
			HBox.setHgrow(redArea, Priority.ALWAYS);
			TextField blueArea = new TextField() ;
			blueArea.setPrefWidth(30);
			hBox.getChildren().addAll(redArea,blueArea,btnCreate) ;
			
			btnCreate.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0)
				{
					String red6 = GetNum.red6In33() ;
					String blue1 = GetNum.blue1In16();
					
					redArea.setText(red6);
					blueArea.setText(blue1);
					
					DataBase.insertNum(red6, blue1);
					DataBase.getResult();
					
				}
			});
			
			Scene scene = new Scene(hBox, 370, 40);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args)
	{
		DataBase.createDataBase();
		launch(args);		
	}
}
