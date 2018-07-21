package rex.vote;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.event.*;
import javafx.scene.input.*;
public class Vote extends Application {
	static Label lbl = null;
	static Button btn = null;
	static TextField tf;
	@Override public void start(Stage primaryStage) {
		Group root = new Group();
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 0 ,20, 0));
		tf = new TextField();
		tf.setStyle("-fx-pref-width: 200px; -fx-pref-height: 34px;-fx-font-size: 16px;");
		Label tlbl = new Label("Enter Age: ");
		tlbl.setStyle("-fx-font-size: 16px;");
		tlbl.setPadding(new Insets(5, 10, 0 ,20));
		hb.getChildren().addAll(tlbl, tf);
		VBox vb = new VBox();
		// vb.setPadding(new Insets(20));
		lbl = new Label("No Information Available Currently");
		lbl.setStyle("-fx-font-size: 16px;");
		lbl.setPadding(new Insets(20, 0 , 20 ,0));
		btn = new Button("Check");

		btn.setStyle("-fx-pref-width: 100px; -fx-pref-height: 34px;-fx-base: #337ab7;-fx-font-size: 16px;");
		vb.getChildren().addAll(hb, btn, lbl);
		vb.setStyle("-fx-alignment: center");
		root.getChildren().add(vb);
		Scene scene = new Scene(root, 320, 240, Color.rgb(240, 240, 240));
		primaryStage.setTitle("Voting Eligiblity Program");
		primaryStage.setScene(scene);
		primaryStage.show();

		btn.setDisable(true);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				checkAge();
			}
		});
		btn.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				checkAge();
			}
		});

		tf.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				btn.setDisable(false);
			}
		});
	}
	public void checkAge() {
		try {
			int age = Integer.parseInt(tf.getText());
			if (age < 18) {
				age = 18 - age;
				throw new InvalidAgeException("Wait " + age + " years and then try to Vote.");
			} else {
				throw new ValidAgeException("You are ready to Vote.");
			}
		} catch(NumberFormatException e) {
			lbl.setText("Please Enter a Valid Age, can't caste "+tf.getText() + " to Integer.");
		} catch(InvalidAgeException e) {
			lbl.setText(":( - " + e.getMessage());
		} catch(ValidAgeException e) {
			lbl.setText(":) - " + e.getMessage());
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}