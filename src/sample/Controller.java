package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import model.AdapterGraph;
import model.Graph;


import java.util.ArrayList;

public class Controller {
    @FXML
    public TextField id_nameVertex;
    @FXML
    public ListView disp;

    @FXML
    public TextField startArc;
    @FXML
    public TextField endArc;
    @FXML
    public TextField val_Vertex;
    @FXML
    public GridPane gridPAneView;

     Graph theGraph=new Graph();
    public int kolVertex=0;
    public int stratArcVer;
    public int endArcVer;
    public int counter=0;
    public int columnIndex=0; //столбец
    public int rowIndex=0;  //строка

    String[] matrixLoylVertex;
    ArrayList<StackPane> stackPane = new ArrayList<StackPane>();

    public void addKolVertex(ActionEvent actionEvent) {

         kolVertex= Integer.valueOf(val_Vertex.getText());
         val_Vertex.setDisable(true);

        matrixLoylVertex = new String[kolVertex];


    }


    public void addVertexName(ActionEvent actionEvent) //метод добавления вершин
    {
                if(counter!=kolVertex) {
                    theGraph.addVertex(id_nameVertex.getText());
                    disp.getItems().add(theGraph.displayVertex());


                    Circle circle=new Circle();
                    Text text = new Text(id_nameVertex.getText());

                    circle.setRadius(40.0f);
                    circle.setFill(Color.ORANGE);

                    StackPane stackPane1= new StackPane();
                    stackPane1.getChildren().add(circle);
                    stackPane1.getChildren().add(text);

                    gridPAneView.setGridLinesVisible(true);
                    gridPAneView.setHgrow(stackPane1, Priority.ALWAYS);
                    gridPAneView.setVgrow(stackPane1, Priority.ALWAYS);
                    gridPAneView.setMargin(stackPane1, new Insets(15));
                    gridPAneView.add(stackPane1,columnIndex,rowIndex);
                    stackPane.add(counter,stackPane1);

                    Bounds boundsInScene = gridPAneView.localToScene(gridPAneView.getBoundsInLocal());


                    double x = boundsInScene.getMinX();
                    double y = boundsInScene.getMinY();

                    double x1 = boundsInScene.getWidth();     //ширина
                    double y1 = boundsInScene.getHeight();      //высоата
                    System.out.println(x+"  "+y);
                    System.out.println(x1+"  "+y1);
                    matrixLoylVertex[counter]=String.valueOf(x+" "+y);

                    for(int i=0;i<=counter;i++)
                    System.out.println(matrixLoylVertex[i]);

                    columnIndex++;
                    rowIndex++;
                    counter++;


                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Предупреждение: ");
                    alert.setHeaderText(null);
                    alert.setContentText("Достигнут лимит вершин!");
                    alert.showAndWait();
                    id_nameVertex.setDisable(true);
                }


    }

    public void addArc(ActionEvent actionEvent) //метод добавления дуг
    {
        stratArcVer=Integer.valueOf(startArc.getText());
        endArcVer=Integer.valueOf(endArc.getText());

             if(stratArcVer <counter   &&
                endArcVer<counter) {
                 theGraph.addEdge(stratArcVer, endArcVer);

                 Line line = new Line();


                 line.startXProperty().bind( stackPane.get(stratArcVer).layoutXProperty().add(stackPane.get(stratArcVer).getBoundsInParent().getWidth() / 2.0));
                 line.startYProperty().bind( stackPane.get(stratArcVer).layoutYProperty().add(stackPane.get(stratArcVer).getBoundsInParent().getHeight() / 2.0));

                 line.endXProperty().bind( stackPane.get(endArcVer).layoutXProperty().add( stackPane.get(endArcVer).getBoundsInParent().getWidth() / 2.0));
                 line.endYProperty().bind( stackPane.get(endArcVer).layoutYProperty().add( stackPane.get(endArcVer).getBoundsInParent().getHeight() / 2.0));


                 line.setStrokeWidth(5.0);
                 line.setStroke(Color.BLACK);

                 gridPAneView.getChildren().add(line);

                 disp.getItems().add(" Добавлена дуга: ("+theGraph.dispOneVertex(stratArcVer)+";"+theGraph.dispOneVertex(endArcVer)+")");

             }else{
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Предупреждение: ");
                 alert.setHeaderText(null);
                 alert.setContentText("Ошибка при заполнении дуги!");
                 alert.showAndWait();
             }
    }




}
