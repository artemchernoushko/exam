package com.tecmeskills.figuresfx.drawutils;

import com.tecmeskills.figuresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Drawer <E extends Figure> implements Drawable{
    private List<Figure> figures;

    public Drawer (List<Figure> figures){
        this.figures = figures;
    }


    @Override
    public void draw(GraphicsContext gc) {
        for (Figure figure : figures){
            figure.draw(gc);
        }
    }
}
