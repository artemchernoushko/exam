package com.tecmeskills.figuresfx.controller;

import com.tecmeskills.figuresfx.drawutils.Drawer;
import com.tecmeskills.figuresfx.exception.FigureException;
import com.tecmeskills.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import jdk.nashorn.internal.runtime.Context;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);
    private ArrayList<Figure> figures = new ArrayList<>();
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("Start");
        random = new Random(System.currentTimeMillis());

    }

    private Figure createFigure(double x, double y) {
        Figure figure = null;

        switch (random.nextInt(5)){
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x,y, Math.max(random.nextInt(4),10) , Color.BLUE, random.nextInt(50));
                logger.info("Circle created");
                break;
            case  Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x,y,Math.max(random.nextInt(4),10), Color.GREEN,random.nextInt(100), random.nextInt(50));
                logger.info("Rectangle created");
                break;
            case  Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x,y,Math.max(random.nextInt(4),10),Color.YELLOW,random.nextInt(70));
                logger.info("Triangle created");
                break;
            case Figure.FIGURE_TYPE_SQUARE:
                figure = new Square(x,y,Math.max(random.nextInt(4),10),Color.GRAY, random.nextInt(50));
                logger.info("Square created");
                break;
            case Figure.FIGURE_TYPE_ELLIPSE:
                figure = new Ellipse(x,y,Math.max(random.nextInt(4),10),Color.BLACK, random.nextInt(50));
                logger.info("Ellipse created");
                break;
            default:
                try {
                    throw new FigureException("Failed to create shape");
                } catch (FigureException e) {
                    Context.ThrowErrorManager logger = null;
                    logger.error(e.getMessage());
                }
        }
        return figure;
    }

    private void repaint(){
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        figures.add(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
    }
}
